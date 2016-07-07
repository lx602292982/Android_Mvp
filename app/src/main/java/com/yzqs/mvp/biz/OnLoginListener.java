package com.yzqs.mvp.biz;

import com.yzqs.mvp.bean.User;

/**
 * 作者：lixiang on 2016/7/5 11:17
 * 邮箱：xiang.li@spreadwin.com
 */
public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();
}
