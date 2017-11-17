package com.lei.demo.ts.login.constract;

import com.lei.base.module.IModule;
import com.lei.base.scope.ActivityScope;
import com.lei.demo.ts.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/15
 * @contact email:907238552@qq.com
 */
@Module
public class LoginModule extends IModule {

    LoginContact.View mView;

    public LoginModule(LoginContact.View view) {
        this.mView = view;
    }

    @ActivityScope
    @Provides
    ILoginService provideILoginService(Retrofit retrofit) {
        return retrofit.create(ILoginService.class);
    }

    @ActivityScope
    @Provides
    LoginPresenter provideLoginPresenter(ILoginService service) {
        return new LoginPresenter(mView, service);
    }


}
