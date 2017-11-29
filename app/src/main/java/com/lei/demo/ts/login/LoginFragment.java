package com.lei.demo.ts.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lei.base.BaseApplication;
import com.lei.base.BaseFragment;
import com.lei.base.util.LogUtils;
import com.lei.base.util.ToastUtils;
import com.lei.demo.ts.R;
import com.lei.demo.ts.TestActivity;
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
                createShortCut();
//                LogUtils.e("", "on", String.valueOf(BaseApplication.getApplication().getRetrofit()));
//                mPresenter.doLogin(mEtAccount.getText().toString(), mEtPassword.getText().toString());
                break;
        }
    }
    public void createShortCut(){
        Intent intent1 = new Intent(getActivity(), TestActivity.class);
        intent1.setAction(Intent.ACTION_MAIN);
        intent1.addCategory(Intent.CATEGORY_LAUNCHER);

        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME,"test_");
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON, R.mipmap.ic_launcher_round);
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent1);
        getActivity().sendBroadcast(intent);

    }
}
