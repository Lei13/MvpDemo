package com.lei.demo.ts.login;

import android.view.View;
import android.widget.Button;

import com.lei.base.BaseFragment;
import com.lei.base.util.ToastUtils;
import com.lei.demo.ts.R;
import com.lei.demo.ts.login.constract.LoginContact;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/15
 * @contact email:907238552@qq.com
 */

public class LoginFragment extends BaseFragment implements LoginContact.View {

    @Inject
    LoginPresenter mPresenter;
    @BindView(R.id.btn_login)
    Button mBtnLogin;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initIntent() {

    }

    @Override
    public void initView() {
        ToastUtils.show(String.valueOf(mBtnLogin) + "  " + String.valueOf(mPresenter));
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_login})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                ToastUtils.show(String.valueOf(mPresenter));
                break;
        }
    }
}
