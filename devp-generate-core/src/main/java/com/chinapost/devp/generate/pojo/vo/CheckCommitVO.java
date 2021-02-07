package com.chinapost.devp.generate.pojo.vo;

/**
 * git代码提交校验结果
 *
 * @author: cpit
 * @date: 2020/11/26
 */
public class CheckCommitVO {

    private String remoteUrl;

    private Boolean firstCommit;

    private GenHistoryShowVO lastGenHistory;

    public Boolean getFirstCommit() {
        return firstCommit;
    }

    public void setFirstCommit(Boolean firstCommit) {
        this.firstCommit = firstCommit;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public GenHistoryShowVO getLastGenHistory() {
        return lastGenHistory;
    }

    public void setLastGenHistory(GenHistoryShowVO lastGenHistory) {
        this.lastGenHistory = lastGenHistory;
    }

}
