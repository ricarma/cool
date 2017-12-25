package test.bwie.apple.mamingze_1509a_1221.presenter;

import test.bwie.apple.mamingze_1509a_1221.bean.DelBean;
import test.bwie.apple.mamingze_1509a_1221.model.DelModel;
import test.bwie.apple.mamingze_1509a_1221.model.imodel.IDelModel;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;
import test.bwie.apple.mamingze_1509a_1221.view.iview.DelView;

/**
 * Created by Apple on 2017/12/21.
 */

public class DelPresenter {
    IDelModel iDelModel;
    DelView delView;

    public DelPresenter(DelView delView) {
        this.delView = delView;
        iDelModel = new DelModel();
    }
    public void dodp(){
        iDelModel.dodel(new OnNetListener<DelBean>() {
            @Override
            public void onSuccess(DelBean delBean) {
                delView.del(delBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
