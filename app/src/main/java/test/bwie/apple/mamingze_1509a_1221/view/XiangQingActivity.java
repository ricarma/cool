package test.bwie.apple.mamingze_1509a_1221.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import test.bwie.apple.mamingze_1509a_1221.R;
import test.bwie.apple.mamingze_1509a_1221.adapter.RvAdapter;
import test.bwie.apple.mamingze_1509a_1221.bean.AddBean;
import test.bwie.apple.mamingze_1509a_1221.bean.ShopQingBean;
import test.bwie.apple.mamingze_1509a_1221.bean.XiangQingBean;
import test.bwie.apple.mamingze_1509a_1221.net.MyApp;
import test.bwie.apple.mamingze_1509a_1221.presenter.AddPresenter;
import test.bwie.apple.mamingze_1509a_1221.presenter.ShopPresenter;
import test.bwie.apple.mamingze_1509a_1221.presenter.XiangQingPrensenter;
import test.bwie.apple.mamingze_1509a_1221.view.iview.AddView;
import test.bwie.apple.mamingze_1509a_1221.view.iview.ShopView;
import test.bwie.apple.mamingze_1509a_1221.view.iview.XiangQingView;

public class XiangQingActivity extends AppCompatActivity implements XiangQingView,AddView{
    //展示详情
    private XiangQingPrensenter prensenter;
    //加入购物车
    private AddPresenter addPresenter;
    @BindView(R.id.xqprice)
    TextView price;
    TextView title;
    @BindView(R.id.add)
    RadioButton add;
    RadioButton go;
    @BindView(R.id.sdv)
    SimpleDraweeView sdv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        price = findViewById(R.id.xqprice);
        title = findViewById(R.id.xqtitle);
        add = findViewById(R.id.add);
        sdv = findViewById(R.id.sdv);
        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(XiangQingActivity.this,CarActivity.class);
                startActivity(it);
            }
        });
        //good
        Intent intent = getIntent();
        String pid = intent.getStringExtra("pid");
        String uid = intent.getStringExtra("uid");
        prensenter = new XiangQingPrensenter(this);
        addPresenter = new AddPresenter(this);
        prensenter.doxqp(pid);
        String uid2 = MyApp.sp.getString("uid","");
        addPresenter.ap(pid);
    }

    @Override
    public void xiangqing(XiangQingBean xiangQingBean) {
        price.setText(xiangQingBean.getData().getPrice()+"");
        title.setText(xiangQingBean.getData().getTitle());
        String images = xiangQingBean.getData().getImages();
        String[] sqite = images.split("\\|");
        sdv.setImageURI(sqite[0]);
    }

    @Override
    public void add(AddBean addBean) {
        final String msg = addBean.getMsg();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(XiangQingActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
