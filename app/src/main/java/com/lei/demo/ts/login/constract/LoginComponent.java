package com.lei.demo.ts.login.constract;

import com.lei.base.compoment.ApplicationComponent;
import com.lei.base.compoment.IComponent;
import com.lei.base.scope.ActivityScope;
import com.lei.demo.ts.login.LoginFragment;

import dagger.Component;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/15
 * @contact email:907238552@qq.com
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = LoginModule.class)
public interface LoginComponent extends IComponent<LoginFragment> {


}
