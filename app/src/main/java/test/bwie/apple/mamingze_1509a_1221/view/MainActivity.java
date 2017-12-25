package test.bwie.apple.mamingze_1509a_1221.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import test.bwie.apple.mamingze_1509a_1221.R;
import test.bwie.apple.mamingze_1509a_1221.bean.LoginBean;
import test.bwie.apple.mamingze_1509a_1221.net.MyApp;
import test.bwie.apple.mamingze_1509a_1221.presenter.LoginPresenter;
import test.bwie.apple.mamingze_1509a_1221.view.iview.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{
    @BindView(R.id.tv_zc)
    TextView tv;
    @BindView(R.id.et_name)
    EditText et1;
    EditText et2;
    @BindView(R.id.button)
    Button bt;
    private LoginPresenter loginPresenter;
    private String mobile,pass;
    private ImageView qq;
    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1105602574";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv_zc);
        et1 = findViewById(R.id.et_name);
        et2 = findViewById(R.id.et_pass);
        bt = findViewById(R.id.button);
        qq = findViewById(R.id.mqq);
        mTencent = Tencent.createInstance(APP_ID,MainActivity.this.getApplicationContext());
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIUiListener = new BaseUiListener();
                //all表示获取所有权限
                mTencent.login(MainActivity.this,"all", mIUiListener);
            }
        });
        loginPresenter = new LoginPresenter(this);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,ZhuceActivity.class);
                startActivity(it);
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobile = et1.getText().toString();
                pass = et2.getText().toString();
                loginPresenter.dolp(mobile,pass);
//                Intent it = new Intent(MainActivity.this,ShowActivity.class);
//                startActivity(it);
            }
        });
    }
    private class BaseUiListener implements IUiListener{

        @Override
        public void onComplete(Object response) {
            Toast.makeText(MainActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken,expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(),qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e(TAG,"登录成功"+response.toString());
                        Intent it = new Intent(MainActivity.this,ShowActivity.class);
                        startActivity(it);
                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG,"登录失败"+uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG,"登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onError(UiError uiError) {
            Toast.makeText(MainActivity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private String getMD5Str(String str) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();

            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        //16位加密，从第9位到25位
        return md5StrBuff.substring(8, 24).toString().toUpperCase();
    }
    @Override
    public void login(LoginBean loginBean) {
        String code = loginBean.getCode();
        String msg= loginBean.getMsg();
        if (code.equals("0")){
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            Intent it = new Intent(MainActivity.this,ShowActivity.class);
            int uid = loginBean.getData().getUid();
            Log.i("ttt",uid+"");
            MyApp.edit.putString("uid",uid+"");
            MyApp.edit.commit();
            startActivity(it);
        }else {
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
    }
}
