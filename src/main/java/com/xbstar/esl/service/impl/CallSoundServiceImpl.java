package com.xbstar.esl.service.impl;

import com.xbstar.esl.common.BaseMapper;
import com.xbstar.esl.common.BaseServiceImpl;
import com.xbstar.esl.dao.CallRecordMapper;
import com.xbstar.esl.dao.CallSoundMapper;
import com.xbstar.esl.domain.CallRecord;
import com.xbstar.esl.domain.CallSound;
import com.xbstar.esl.service.CallSoundService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Simon on 2019/9/9 13:49
 */
@Service
public class CallSoundServiceImpl extends BaseServiceImpl<CallSound> implements CallSoundService {
    @Resource
    private CallSoundMapper callSoundMapper;

    @Override
    public BaseMapper<CallSound> getMapper() {
        return this.callSoundMapper;
    }

}
