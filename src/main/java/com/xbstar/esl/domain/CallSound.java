package com.xbstar.esl.domain;

import javax.persistence.Id;

/**
 * Created by Simon on 2019/9/9 16:37
 */
public class CallSound {

    @Id
    private Long id;

    private String callUuid;

    private String filePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallUuid() {
        return callUuid;
    }

    public void setCallUuid(String callUuid) {
        this.callUuid = callUuid;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
