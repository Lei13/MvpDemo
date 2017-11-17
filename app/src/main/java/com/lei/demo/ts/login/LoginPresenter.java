package com.lei.demo.ts.login;

import android.util.Log;

import com.lei.base.presenter.BasePresenter;
import com.lei.base.util.LogUtils;
import com.lei.base.util.ToastUtils;
import com.lei.base.view.IView;
import com.lei.demo.ts.login.constract.ILoginService;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/15
 * @contact email:907238552@qq.com
 */

public class LoginPresenter extends BasePresenter {
    ILoginService mILoginService;

    @Inject
    public LoginPresenter(IView view, ILoginService service) {
        super(view);
        mILoginService = service;
    }

    public void doLogin(String name, String pass) {
        if (mILoginService != null) {
            //Oauth&act=authorize
            mILoginService.login(name, pass).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<LoginBean>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {
                            LogUtils.e("onSubscribe");
                        }

                        @Override
                        public void onNext(@NonNull LoginBean loginBean) {
                            LogUtils.e("onNext"+loginBean);
                            if (loginBean.status == 1) {
                                ToastUtils.show(loginBean.oauth_token_secret);
                            }else{
                                ToastUtils.show(loginBean.msg);
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                            LogUtils.e("onError"+e.getMessage());
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }else{
            ToastUtils.show("request null");
        }
    }

}
