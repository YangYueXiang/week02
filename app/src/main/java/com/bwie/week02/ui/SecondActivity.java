package com.bwie.week02.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.week02.R;
import com.bwie.week02.di.IContract;
import com.bwie.week02.di.PresenterImp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity implements IContract.iview{

    @BindView(R.id.regist_username)
    EditText registUsername;
    @BindView(R.id.regist_password)
    EditText registPassword;
    @BindView(R.id.register)
    Button register;
    private PresenterImp presenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        presenterImp = new PresenterImp();
        //关联视图
        presenterImp.attachView(this);

    }

    @OnClick(R.id.register)
    public void onViewClicked() {
        String registusername = registUsername.getText().toString();
        String registpassword  = registPassword.getText().toString();
        presenterImp.requestInfo(registusername,registpassword);

    }

    @Override
    public void showData(final String message) {
        //强制切回主线程
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SecondActivity.this,message,Toast.LENGTH_SHORT).show();
                if (message.equals("注册成功")){

                    /*Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);*/
                    finish();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterImp.detachView(this);
    }
}
