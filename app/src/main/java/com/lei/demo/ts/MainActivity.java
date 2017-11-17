package com.lei.demo.ts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.lei.base.BaseActivity;
import com.lei.demo.ts.login.LoginActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_test)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initIntent() {

    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
        if (btn != null)
            startActivity(new Intent(this, LoginActivity.class));
    }
}
