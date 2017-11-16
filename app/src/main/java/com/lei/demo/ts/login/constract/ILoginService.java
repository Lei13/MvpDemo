package com.lei.demo.ts.login.constract;

import com.lei.demo.ts.login.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/16
 * @contact email:907238552@qq.com
 */

public interface ILoginService {

    /**
     * 登录
     *
     * @param accountName
     * @param password
     * @return
     */
    @FormUrlEncoded
    @GET("?mod=Oauth&act=authorize")
    Observable<LoginBean> login(@Query("login") String accountName, @Query("password") String password);
}
