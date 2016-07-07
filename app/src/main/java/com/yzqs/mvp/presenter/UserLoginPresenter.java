package com.yzqs.mvp.presenter;

import com.yzqs.mvp.bean.User;
import com.yzqs.mvp.biz.IUserBiz;
import com.yzqs.mvp.biz.OnLoginListener;
import com.yzqs.mvp.biz.UserBiz;
import com.yzqs.mvp.view.IUserLoginView;

/**
 * 作者：lixiang on 2016/7/5 11:18
 * 邮箱：xiang.li@spreadwin.com
 */

public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoanding();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassWord(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                userLoginView.toMainActivity(user);
                userLoginView.hideLoanding();
            }

            @Override
            public void loginFailed() {
                userLoginView.showFailedErrot();
                userLoginView.hideLoanding();
            }
        });

    }

    public void clean() {
        userLoginView.cleanPassWord();
        userLoginView.cleanUserName();
    }

}
