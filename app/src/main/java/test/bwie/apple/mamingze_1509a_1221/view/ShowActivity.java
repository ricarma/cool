package test.bwie.apple.mamingze_1509a_1221.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import test.bwie.apple.mamingze_1509a_1221.R;
import test.bwie.apple.mamingze_1509a_1221.adapter.RvAdapter;
import test.bwie.apple.mamingze_1509a_1221.bean.ShopQingBean;
import test.bwie.apple.mamingze_1509a_1221.presenter.ShopPresenter;
import test.bwie.apple.mamingze_1509a_1221.view.iview.ShopView;

public class ShowActivity extends AppCompatActivity implements ShopView {
    private ShopPresenter presenter;
    private RvAdapter adapter;
    private RecyclerView rv;
    private String uid;
    private List<ShopQingBean.DataBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        rv = findViewById(R.id.rv);
        Intent intent = getIntent();
        uid = intent.getStringExtra("uid");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        rv.setLayoutManager(gridLayoutManager);
        presenter = new ShopPresenter(this);
        presenter.doxq();
    }

    @Override
    public void sp(ShopQingBean xiangQingBean) {
        list = xiangQingBean.getData();
        adapter = new RvAdapter(this,list);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new RvAdapter.OnItemClickListener() {
            @Override
            public void onItemClieck(String str) {
                Intent it = new Intent(ShowActivity.this,XiangQingActivity.class);
                it.putExtra("pid",str);
                it.putExtra("uid",uid);
                startActivity(it);
            }
        });

    }
}
