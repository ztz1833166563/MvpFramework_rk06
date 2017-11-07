package ztz.com.mvpframework_rk06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tencent.bugly.crashreport.CrashReport;

import ztz.com.mvpframework_rk06.presenter.LoginPresenter;
import ztz.com.mvpframework_rk06.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{

    private EditText edit_phone;
    private EditText edit_password;
    private Button btn_login;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取id
        edit_phone = findViewById(R.id.edit_phone);
        edit_password = findViewById(R.id.edit_password);
        btn_login = findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter(this);

        //登录按钮的点击事件
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取到手机号和密码传到presenter,进行登录
                loginPresenter.login(edit_phone.getText().toString(),edit_password.getText().toString());

            }
        });
    }

    @Override
    public void phoneEmpty() {
        Toast.makeText(MainActivity.this,"phone is empty",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordEmpty() {
        Toast.makeText(MainActivity.this,"password is empty",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,data,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void failed(final int code) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,code+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
