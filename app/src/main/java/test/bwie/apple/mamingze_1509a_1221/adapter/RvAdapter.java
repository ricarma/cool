package test.bwie.apple.mamingze_1509a_1221.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import test.bwie.apple.mamingze_1509a_1221.R;
import test.bwie.apple.mamingze_1509a_1221.bean.ShopQingBean;

/**
 * Created by Apple on 2017/12/21.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder>{
    private Context context;
    private List<ShopQingBean.DataBean> list;
    private LayoutInflater inflater;

    public RvAdapter(Context context, List<ShopQingBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_rv,null);
        return new MyViewHolder(view);
    }
    //设置一个变量
    public OnItemClickListener onItemClickListener;
    //3.定义一个方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    //1.首先自定义一个接口
    public interface OnItemClickListener {
        public void onItemClieck(String str);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ShopQingBean.DataBean dataBean = list.get(position);
        MyViewHolder myViewHolder = holder;
        String images = dataBean.getImages();
        String[] sqite = images.split("\\|");
        holder.sdv.setImageURI(sqite[0]);
        holder.tv.setText(dataBean.getPrice()+"");
        holder.tv2.setText(dataBean.getTitle());
        final int pid = dataBean.getPid();
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClieck(pid+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView sdv;
        private TextView tv,tv2;
        private RelativeLayout ll;
        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            tv = itemView.findViewById(R.id.tv_title);
            tv2 = itemView.findViewById(R.id.tv_mess);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
