package com.lei.base.module;

import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.lei.base.BaseConfig;
import com.lei.base.RequestIntercept;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/15
 * @contact email:907238552@qq.com
 */
@Module
public class ApplicationModule {

    @Provides
    @Singleton
    RequestIntercept provideRequestIntercept() {
        return new RequestIntercept();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(RequestIntercept intercept) {
        return new OkHttpClient.Builder()
                .addInterceptor(intercept)
                .build();
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BaseConfig.BASE_URL)
                .client(client)
                .build();
    }


}
