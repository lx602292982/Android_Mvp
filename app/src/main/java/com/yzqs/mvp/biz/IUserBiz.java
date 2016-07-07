package com.yzqs.mvp.biz;

/**
 * 作者：lixiang on 2016/7/5 11:17
 * 邮箱：xiang.li@spreadwin.com
 */
public interface IUserBiz {

    void login(String userName, String passWord, OnLoginListener onLoginListener);

}
