package com.yzqs.mvp.biz;

import com.yzqs.mvp.bean.User;

/**
 * 作者：lixiang on 2016/7/5 11:17
 * 邮箱：xiang.li@spreadwin.com
 */
public class UserBiz implements IUserBiz {

    @Override
    public void login(final String userName, final String passWord, final OnLoginListener onLoginListener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("lixiang".equals(userName) && "123456".equals(passWord)) {
                    User user = new User();
                    user.setPassWord(passWord);
                    user.setUserName(userName);
                    onLoginListener.loginSuccess(user);
                } else {
                    onLoginListener.loginFailed();
                }
            }
        }.start();
    }
}
