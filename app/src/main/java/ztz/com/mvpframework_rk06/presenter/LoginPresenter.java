package ztz.com.mvpframework_rk06.presenter;

import android.text.TextUtils;

import ztz.com.mvpframework_rk06.model.LoginModel;
import ztz.com.mvpframework_rk06.model.Model;
import ztz.com.mvpframework_rk06.view.LoginView;

/**
 * Created by TR on 2017/11/7.
 *
 * 进行model层和view层的交互,拥有者复杂的逻辑代码
 */

public class LoginPresenter {

    private LoginView LoginView;
    private final LoginModel loginModel;

    public LoginPresenter(LoginView LoginView) {
        this.LoginView = LoginView;
        loginModel = new LoginModel();
    }

    public void login(String phone,String password){
        if (TextUtils.isEmpty(phone)){
            LoginView.phoneEmpty();
            return;
        }
        if (TextUtils.isEmpty(password)){
            LoginView.passwordEmpty();
            return;
        }
        loginModel.login(phone,password, new Model() {
            @Override
            public void success(String data) {
                LoginView.success(data);
            }

            @Override
            public void failed(int code) {
                LoginView.failed(code);
            }
        });

    }

}
