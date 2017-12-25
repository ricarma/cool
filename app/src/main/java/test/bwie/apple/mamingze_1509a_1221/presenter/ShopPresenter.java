package test.bwie.apple.mamingze_1509a_1221.presenter;

import test.bwie.apple.mamingze_1509a_1221.bean.ShopQingBean;
import test.bwie.apple.mamingze_1509a_1221.model.ShopModel;
import test.bwie.apple.mamingze_1509a_1221.model.imodel.IShopModel;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;
import test.bwie.apple.mamingze_1509a_1221.view.iview.ShopView;

/**
 * Created by Apple on 2017/12/21.
 */

public class ShopPresenter {
    IShopModel iXqModel;
    ShopView xqView;

    public ShopPresenter(ShopView xqView) {
        this.xqView = xqView;
        iXqModel = new ShopModel();
    }
    public void doxq(){
        iXqModel.doxq(new OnNetListener<ShopQingBean>() {
            @Override
            public void onSuccess(ShopQingBean xiangQingBean) {
                xqView.sp(xiangQingBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
