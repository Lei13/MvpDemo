package com.lei.base.compoment;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/15
 * @contact email:907238552@qq.com
 */

public interface IComponent<T>{
    void inject(T o);
}
