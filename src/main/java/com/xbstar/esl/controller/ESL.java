package com.xbstar.esl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xbstar.esl.domain.CallRecord;
import com.xbstar.esl.domain.CallSound;
import com.xbstar.esl.service.impl.CallRecordServiceImpl;
import com.xbstar.esl.service.impl.CallSoundServiceImpl;
import com.xbstar.esl.util.EventConstant;
import org.freeswitch.esl.client.IEslEventListener;
import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.inbound.InboundConnectionFailure;
import org.freeswitch.esl.client.transport.event.EslEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Java esl调用FreeSWITCH发起呼叫等
 *
 * @author SimonHua
 */
@Controller
public class ESL {
    @Autowired
    CallRecordServiceImpl callRecordService;
    @Autowired
    CallSoundServiceImpl callSoundService;

    private static final Logger log = LoggerFactory.getLogger(ESL.class);
    /**
     * autoload_configs目录event_socket.conf.xml文件中
     */
    private static String host = "192.168.6.31";
    private static int port = 8021;
    private static String password = "ClueCon";

    @PostConstruct
    public Client inBand() {

        final Client client = new Client();
        try {
            client.connect(host, port, password, 20);
        } catch (InboundConnectionFailure e) {
            log.error("Connect failed", e);
            return null;
        }

        // 注册事件处理程序
        client.addEventListener(new IEslEventListener() {
            public void eventReceived(EslEvent event) {
                String type = event.getEventName();
                Map<String,String> map = event.getEventHeaders();
                String call_uuid = map.get("Unique-ID");
                String caller_id_name = map.get("Caller-Caller-ID-Number");
                String caller_id_number = map.get("Caller-Caller-ID-Name");
                String destination_number = map.get("Caller-Destination-Number");

                JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
                switch (type){
                    case EventConstant.RECORD_START:
                        String filepath = map.get("Record-File-Path");
                        CallSound callSound = new CallSound();
                        callSound.setCallUuid(call_uuid);
                        callSound.setFilePath(filepath);
                        callSoundService.insert(callSound);
                        break;
                    case EventConstant.RECORD_STOP:
                        break;
//                    case EventConstant.CHANNEL_ANSWER:
//                        break;
                    case EventConstant.CHANNEL_BRIDGE:
                        long startTime = Long.parseLong(map.get("Caller-Channel-Created-Time"));
                        long answerTime = Long.parseLong(map.get("Caller-Channel-Answered-Time"));
                        CallRecord record = new CallRecord();
                        record.setCallUuid(call_uuid);
                        record.setCallerIdName(caller_id_name);
                        record.setCallerIdNumber(caller_id_number);
                        record.setDestinationNumber(destination_number);
                        record.setStartStamp(startTime);
                        record.setAnswerStamp(answerTime);
                        callRecordService.insert(record);
                        break;
//                    case EventConstant.CHANNEL_DESTROY:
//                        break;
                    case EventConstant.CHANNEL_HANGUP_COMPLETE:
                        String hangupCause = map.get("variable_hangup_cause");
                        long endTime = Long.parseLong(map.get("Caller-Channel-Hangup-Time"));
                        CallRecord callRecord = callRecordService.findByuuid(call_uuid);
                        if(callRecord==null)break;
                        callRecord.setEndStamp(endTime);
                        callRecord.setUduration(endTime-callRecord.getStartStamp());
                        int billsec = Integer.parseInt((endTime-callRecord.getAnswerStamp())/(1000*1000)+"");
                        callRecord.setBillsec(billsec);
                        callRecord.setHangupCause(hangupCause);
                        callRecordService.update(callRecord);
                        break;
                    default:
                        break;
                }
            }

            public void backgroundJobResultReceived(EslEvent event) {
                // String uuid = event.getEventHeaders().get("Job-UUID");
                log.info("Background job result received+:" + event.getEventName() + "/" + event.getEventHeaders());// +"/"+JoinString(event.getEventHeaders())+"/"+JoinString(event.getEventBodyLines()));
            }
        });
        client.setEventSubscriptions("plain", "all");
        return client;
    }


}