package com.chinapost.devp.generate.config;

/**
 * 配置参数类，该类中的参数来自配置文件
 *
 * @author: cpit
 * @date: 2017/5/12
 */
public class GenerateProperties {

    /**
     * 是否启用web服务
     */
    private Boolean enable;

    /**
     * 开发模式：0非开发模式，1本地工程全替换，2本地工程部分替换
     *
     * @see com.chinapost.devp.generate.constant.DevMode
     */
    private Integer devMode = 0;

    /**
     * 数据文件夹路径
     * 如果不指定，则自动使用操作系统临时文件目录
     */
    private String dataDir;

    /**
     * 自动分支名称
     */
    private String autoBranchName;

    /**
     * 本地开发工程路径
     */
    private String devProjectDir;

    /**
     * 系统版本
     */
    private String version;
    /**
     * aes对称加密Key
     */
    private String aesKey;

    /**
     * 是否启用登录校验
     */
    private boolean securityEnabled;

    /**
     * 是否启用项目组共享功能
     */
    private boolean teamEnabled;

    public boolean isTeamEnabled() {
        return teamEnabled;
    }

    public void setTeamEnabled(boolean teamEnabled) {
        this.teamEnabled = teamEnabled;
    }

    public String getDataDir() {
        return dataDir;
    }

    public void setDataDir(String dataDir) {
        this.dataDir = dataDir;
    }

    public boolean isSecurityEnabled() {
        return securityEnabled;
    }

    public void setSecurityEnabled(boolean securityEnabled) {
        this.securityEnabled = securityEnabled;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getDevMode() {
        return devMode;
    }

    public void setDevMode(Integer devMode) {
        this.devMode = devMode;
    }

    public String getDevProjectDir() {
        return devProjectDir;
    }

    public void setDevProjectDir(String devProjectDir) {
        this.devProjectDir = devProjectDir;
    }

    public String getAutoBranchName() {
        return autoBranchName;
    }

    public void setAutoBranchName(String autoBranchName) {
        this.autoBranchName = autoBranchName;
    }
}
