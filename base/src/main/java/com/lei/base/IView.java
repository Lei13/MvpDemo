package com.lei.base;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/15
 * @contact email:907238552@qq.com
 */

public interface IView {

    /**
     * 布局id
     *
     * @return
     */
    int getLayoutId();

    /**
     * 传过来参数
     */
    void initIntent();


    /**
     * 初始化view
     */
    void initView();


    /**
     * 初始化数据
     */
    void initData();
}
