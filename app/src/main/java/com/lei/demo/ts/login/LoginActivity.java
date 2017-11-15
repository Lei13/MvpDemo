package com.lei.demo.ts.login;

import com.lei.base.BaseActivity;
import com.lei.demo.ts.R;
import com.lei.demo.ts.login.constract.DaggerLoginComponent;
import com.lei.demo.ts.login.constract.LoginContact;
import com.lei.demo.ts.login.constract.LoginModule;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/15
 * @contact email:907238552@qq.com
 */

public class LoginActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initIntent() {

    }

    @Override
    public void initView() {
        mFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mFragment).commit();
        DaggerLoginComponent.builder().loginModule(new LoginModule((LoginContact.View) mFragment)).build().inject((LoginFragment) mFragment);
    }

    @Override
    public void initData() {

    }
}
