package com.lei.demo.ts.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    @BindView(R.id.et_account)
    EditText mEtAccount;
    @BindView(R.id.et_password)
    EditText mEtPassword;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initIntent() {

    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_login})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                mPresenter.doLogin(mEtAccount.getText().toString(), mEtPassword.getText().toString());
                break;
        }
    }
}
