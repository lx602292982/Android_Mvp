package com.yzqs.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yzqs.mvp.bean.User;
import com.yzqs.mvp.presenter.UserLoginPresenter;
import com.yzqs.mvp.view.IUserLoginView;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView, View.OnClickListener {
    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;
    private String TAG = "UserLoginActivity";
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    public void initViews() {
        mEtUsername = (EditText) findViewById(R.id.id_et_username);
        mEtPassword = (EditText) findViewById(R.id.id_et_password);

        mBtnClear = (Button) findViewById(R.id.id_btn_clear);
        mBtnLogin = (Button) findViewById(R.id.id_btn_login);

        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);

        mBtnClear.setOnClickListener(this);
        mPbLoading.setOnClickListener(this);
    }


    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassWord() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void cleanUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void cleanPassWord() {
        mEtPassword.setText("");
    }

    @Override
    public void showLoanding() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoanding() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        toast("登陆成功" + user.getUserName());
    }

    @Override
    public void showFailedErrot() {
        toast("登陆失败");
    }

    @Override
    public void toast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mLog(String log) {
        Log.d(TAG, log);
    }


    @Override
    public void onClick(View v) {
        if (v.equals(mBtnLogin)) {
            mUserLoginPresenter.login();
        } else if (v.equals(mBtnClear)) {
            mUserLoginPresenter.clean();
        }
    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
    }

    @Override
    protected void onDestroy() {
        finishAfterTransition();
        super.onDestroy();
    }
}
