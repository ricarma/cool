package test.bwie.apple.mamingze_1509a_1221.model;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bwie.apple.mamingze_1509a_1221.bean.ShopQingBean;
import test.bwie.apple.mamingze_1509a_1221.model.imodel.IShopModel;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;
import test.bwie.apple.mamingze_1509a_1221.utils.RetrofitHelper;
import test.bwie.apple.mamingze_1509a_1221.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/21.
 */

public class ShopModel implements IShopModel {
    @Override
    public void doxq(final OnNetListener<ShopQingBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        serviceApi.xqbean().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<ShopQingBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ShopQingBean xiangQingBean) {
                onNetListener.onSuccess(xiangQingBean);
            }
        });
    }
}
