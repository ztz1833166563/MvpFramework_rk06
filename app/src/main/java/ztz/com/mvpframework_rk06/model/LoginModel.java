package ztz.com.mvpframework_rk06.model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by TR on 2017/11/7.
 *
 * model页面进行网络请求,数据库操作
 */

public class LoginModel {

    public void login(String phone, String password, final Model model) {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://120.27.23.105/user/login?mobile=" + phone + "&password=" + password)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            //失败回调的方法
            @Override
            public void onFailure(Call call, IOException e) {
                model.failed(1);
            }

            //成功回调的方法
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String result = response.body().string() ;
                //请求到的数据
                model.success(result);
            }
        });
    }
}
