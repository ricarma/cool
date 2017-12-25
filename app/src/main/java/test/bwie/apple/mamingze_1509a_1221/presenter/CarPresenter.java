package test.bwie.apple.mamingze_1509a_1221.presenter;

import java.util.ArrayList;
import java.util.List;

import test.bwie.apple.mamingze_1509a_1221.bean.CarBean;
import test.bwie.apple.mamingze_1509a_1221.model.CarModel;
import test.bwie.apple.mamingze_1509a_1221.model.imodel.ICarModel;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;
import test.bwie.apple.mamingze_1509a_1221.view.iview.CarView;

/**
 * Created by Apple on 2017/12/21.
 */

public class CarPresenter {
    ICarModel iCarModel;
    CarView carView;

    public CarPresenter(CarView carView) {
        this.carView = carView;
        iCarModel = new CarModel();
    }
    public void docp(){
        iCarModel.docar(new OnNetListener<CarBean>() {
            @Override
            public void onSuccess(CarBean carBean) {
                List<CarBean.DataBean> dataBeans = carBean.getData();
                List<List<CarBean.DataBean.ListBean>> childlist = new ArrayList<List<CarBean.DataBean.ListBean>>();
                for (int i=0;i<dataBeans.size();i++){
                    List<CarBean.DataBean.ListBean> datas = dataBeans.get(i).getList();
                    childlist.add(datas);
                }
                carView.car(dataBeans,childlist);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
