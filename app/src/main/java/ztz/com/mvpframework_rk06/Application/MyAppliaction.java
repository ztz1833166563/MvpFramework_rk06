package ztz.com.mvpframework_rk06.Application;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by TR on 2017/11/7.
 */

public class MyAppliaction extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(),"fc233b5ebe", false);

    }
}
