package test.bwie.apple.mamingze_1509a_1221.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import rx.schedulers.Schedulers;
import test.bwie.apple.mamingze_1509a_1221.R;
import test.bwie.apple.mamingze_1509a_1221.adapter.MyAdapter;
import test.bwie.apple.mamingze_1509a_1221.bean.CarBean;
import test.bwie.apple.mamingze_1509a_1221.bean.DelBean;
import test.bwie.apple.mamingze_1509a_1221.event.MessageEvent;
import test.bwie.apple.mamingze_1509a_1221.event.PriceAndCountEvent;
import test.bwie.apple.mamingze_1509a_1221.presenter.CarPresenter;
import test.bwie.apple.mamingze_1509a_1221.presenter.DelPresenter;
import test.bwie.apple.mamingze_1509a_1221.view.iview.CarView;
import test.bwie.apple.mamingze_1509a_1221.view.iview.DelView;

public class CarActivity extends AppCompatActivity implements CarView,DelView{
    private CarPresenter carPresenter;
    private MyAdapter adapter;
    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    private TextView mTvPrice;
    private TextView mTvNum;
    private TextView tv_num;
    private DelPresenter delPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        mElv =  findViewById(R.id.elv);
        mCheckbox2 = findViewById(R.id.checkbox2);
        mTvPrice =  findViewById(R.id.tv_price);
        mTvNum =  findViewById(R.id.tv_num);
        tv_num = findViewById(R.id.tv_num);
        carPresenter = new CarPresenter(this);
        carPresenter.docp();
        delPresenter = new DelPresenter(this);
        delPresenter.dodp();
        EventBus.getDefault().register(this);
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void car(List<CarBean.DataBean> grouplist, List<List<CarBean.DataBean.ListBean>> childlist) {
        adapter = new MyAdapter(this,grouplist,childlist);
        mElv.setAdapter(adapter);
        mElv.setGroupIndicator(null);
        for (int i=0;i<grouplist.size();i++){
            mElv.expandGroup(i);
        }
    }
    @Subscribe
    public void onMessageEvent(MessageEvent event){
        mCheckbox2.setChecked(event.isChecked());
    }
    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event){
        mTvNum.setText("结算(" + event.getCount() + ")");
        mTvPrice.setText(event.getPrice() + "");
    }

    @Override
    public void del(DelBean delBean) {
        String msg = delBean.getMsg();
        //Toast.makeText(CarActivity.this,"msg",Toast.LENGTH_SHORT).show();
    }
}
