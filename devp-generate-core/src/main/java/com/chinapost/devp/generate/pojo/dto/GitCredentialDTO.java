package com.chinapost.devp.generate.pojo.dto;

/**
 * git认证对象
 *
 * @author: cpit
 * @date: 2020/3/17
 */
public class GitCredentialDTO {

    private String username;

    private String password;

    public GitCredentialDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
