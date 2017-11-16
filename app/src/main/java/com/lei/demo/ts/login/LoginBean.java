package com.lei.demo.ts.login;

import java.io.Serializable;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/16
 * @contact email:907238552@qq.com
 */

public class LoginBean implements Serializable {
    /**
     * {
     * "oauth_token": "d6ab7275bce6b89a6a349e0a9446217b",
     * "oauth_token_secret": "c2a3abaa78abf5487e759dd8732ebe40",
     * "uid": 46811,
     * "status": 1
     * }
     */
    public String oauth_token;
    public String oauth_token_secret;
    public long uid;
    public int status;
}
