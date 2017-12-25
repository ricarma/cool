package test.bwie.apple.mamingze_1509a_1221.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import test.bwie.apple.mamingze_1509a_1221.R;
import test.bwie.apple.mamingze_1509a_1221.bean.RegBean;
import test.bwie.apple.mamingze_1509a_1221.presenter.RegPresenter;
import test.bwie.apple.mamingze_1509a_1221.view.iview.RegView;

public class ZhuceActivity extends AppCompatActivity implements RegView{
    @BindView(R.id.back)
    ImageView iv;
    @BindView(R.id.name)
    EditText name;
    EditText pass;
    @BindView(R.id.zc)
    Button zc;
    private RegPresenter regPresenter;
    private String mobile,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        iv = findViewById(R.id.back);
        regPresenter = new RegPresenter(this);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        zc = findViewById(R.id.zc);
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobile = name.getText().toString();
                password = pass.getText().toString();
                regPresenter.dorp(mobile,password);
            }
        });
    }

    @Override
    public void reg(RegBean regBean) {
        String code = regBean.getCode();
        String msg = regBean.getMsg();
        if (code.equals("0")){
            Toast.makeText(ZhuceActivity.this,msg,Toast.LENGTH_SHORT).show();
            Intent it = new Intent(ZhuceActivity.this,ShowActivity.class);
            startActivity(it);
            finish();
        }else {
            Toast.makeText(ZhuceActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
    }
}
