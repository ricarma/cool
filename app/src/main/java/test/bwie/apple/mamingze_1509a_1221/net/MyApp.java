package test.bwie.apple.mamingze_1509a_1221.net;

import android.app.Application;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.BuildConfig;
import butterknife.ButterKnife;

/**
 * Created by Apple on 2017/12/21.
 */

public class MyApp extends Application{
    public static SharedPreferences sp;
    public static SharedPreferences.Editor edit;
    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(BuildConfig.DEBUG);
        Fresco.initialize(this);
        sp = getSharedPreferences("users",MODE_PRIVATE);
        edit = sp.edit();
    }
}
