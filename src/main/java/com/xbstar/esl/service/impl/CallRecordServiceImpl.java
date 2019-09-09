package com.xbstar.esl.service.impl;

import com.xbstar.esl.common.BaseMapper;
import com.xbstar.esl.common.BaseServiceImpl;
import com.xbstar.esl.dao.CallRecordMapper;
import com.xbstar.esl.domain.CallRecord;
import com.xbstar.esl.service.CallRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Simon on 2019/9/9 13:49
 */
@Service
public class CallRecordServiceImpl extends BaseServiceImpl<CallRecord> implements CallRecordService {
    @Resource
    private CallRecordMapper callRecordMapper;

    @Override
    public BaseMapper<CallRecord> getMapper() {
        return this.callRecordMapper;
    }

    @Override
    public CallRecord findByuuid(String uuid){
       return callRecordMapper.findByuuid(uuid);
    }
}
