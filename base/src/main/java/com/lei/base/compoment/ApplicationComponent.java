package com.lei.base.compoment;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.lei.base.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/15
 * @contact email:907238552@qq.com
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    /**
     * 注入
     *
     * @param application
     */
    void inject(Application application);

//    OkHttpClient okHttpClient();
//
    Retrofit retrofit();
}
