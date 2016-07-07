package com.yzqs.mvp.view;

import com.yzqs.mvp.bean.User;

/**
 * 作者：lixiang on 2016/7/5 11:18
 * 邮箱：xiang.li@spreadwin.com
 */
public interface IUserLoginView {

    String getUserName();

    String getPassWord();

    void cleanUserName();

    void cleanPassWord();

    void showLoanding();

    void hideLoanding();

    void toMainActivity(User user);

    void showFailedErrot();

    void toast(String text);

    void mLog(String log);

}
