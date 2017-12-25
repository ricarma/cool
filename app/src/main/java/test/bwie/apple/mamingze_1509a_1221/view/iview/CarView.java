package test.bwie.apple.mamingze_1509a_1221.view.iview;

import java.util.List;

import test.bwie.apple.mamingze_1509a_1221.bean.CarBean;

/**
 * Created by Apple on 2017/12/21.
 */

public interface CarView {
    public void car(List<CarBean.DataBean> grouplist,List<List<CarBean.DataBean.ListBean>> childlist);
}
