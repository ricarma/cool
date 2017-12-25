package test.bwie.apple.mamingze_1509a_1221.presenter;

import test.bwie.apple.mamingze_1509a_1221.bean.XiangQingBean;
import test.bwie.apple.mamingze_1509a_1221.model.XiangQingModel;
import test.bwie.apple.mamingze_1509a_1221.model.imodel.IXiangQingModel;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;
import test.bwie.apple.mamingze_1509a_1221.view.iview.XiangQingView;

/**
 * Created by Apple on 2017/12/21.
 */

public class XiangQingPrensenter {
    IXiangQingModel iXiangQingModel;
    XiangQingView xiangQingView;

    public XiangQingPrensenter(XiangQingView xiangQingView) {
        this.xiangQingView = xiangQingView;
        iXiangQingModel = new XiangQingModel();
    }
    public void doxqp(String pid){
        iXiangQingModel.doxiangqing(pid, new OnNetListener<XiangQingBean>() {
            @Override
            public void onSuccess(XiangQingBean xiangQingBean) {
                xiangQingView.xiangqing(xiangQingBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
