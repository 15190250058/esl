package com.xbstar.esl.dao;

import com.xbstar.esl.domain.CallRecord;
import com.xbstar.esl.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CallRecordMapper extends BaseMapper<CallRecord> {

    CallRecord findByuuid(String uuid);
}