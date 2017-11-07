package ztz.com.mvpframework_rk06.view;

/**
 * Created by TR on 2017/11/7.
 */

public interface LoginView {
    void phoneEmpty();
    void passwordEmpty();
    void success(String data);
    void failed(int code);

}
