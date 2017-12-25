package test.bwie.apple.mamingze_1509a_1221.presenter;

import test.bwie.apple.mamingze_1509a_1221.bean.RegBean;
import test.bwie.apple.mamingze_1509a_1221.model.RegModel;
import test.bwie.apple.mamingze_1509a_1221.model.imodel.IRegModel;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;
import test.bwie.apple.mamingze_1509a_1221.view.iview.RegView;

/**
 * Created by Apple on 2017/12/21.
 */

public class RegPresenter {
    IRegModel iRegModel;
    RegView regView;

    public RegPresenter(RegView regView) {
        this.regView = regView;
        iRegModel = new RegModel();
    }
    public void dorp(String mobile,String password){
        iRegModel.doreg(mobile, password, new OnNetListener<RegBean>() {
            @Override
            public void onSuccess(RegBean regBean) {
                regView.reg(regBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
