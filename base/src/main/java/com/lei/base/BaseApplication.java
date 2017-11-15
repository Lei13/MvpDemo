package com.lei.base;

import android.app.Application;

import com.lei.base.compoment.ApplicationComponent;
import com.lei.base.compoment.DaggerApplicationComponent;
import com.lei.base.module.ApplicationModule;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/15
 * @contact email:907238552@qq.com
 */

public class BaseApplication extends Application {

    @Inject
    Retrofit mRetrofit;

    @Inject
    OkHttpClient mOkHttpClient;
    private static BaseApplication sBaseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApplication = this;
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule()).build().inject(this);
    }

    public static BaseApplication getApplication() {
        return sBaseApplication;
    }
}
