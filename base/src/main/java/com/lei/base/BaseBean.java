package com.lei.base;

import java.io.Serializable;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/16
 * @contact email:907238552@qq.com
 */

public class BaseBean<T> implements Serializable {
    public String msg;
    public int status;
    public T data;
}
