package com.xbstar.esl.service;

import com.xbstar.esl.domain.CallRecord;

/**
 * Created by Simon on 2019/9/9 13:49
 */
public interface CallRecordService {

    CallRecord findByuuid(String uuid);
}
