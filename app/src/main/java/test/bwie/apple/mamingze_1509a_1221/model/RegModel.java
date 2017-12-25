package test.bwie.apple.mamingze_1509a_1221.model;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bwie.apple.mamingze_1509a_1221.bean.RegBean;
import test.bwie.apple.mamingze_1509a_1221.model.imodel.IRegModel;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;
import test.bwie.apple.mamingze_1509a_1221.utils.RetrofitHelper;
import test.bwie.apple.mamingze_1509a_1221.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/21.
 */

public class RegModel implements IRegModel{
    @Override
    public void doreg(String mobile, String password, final OnNetListener<RegBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        serviceApi.regbean(mobile,password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<RegBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(RegBean regBean) {
                onNetListener.onSuccess(regBean);
            }
        });
    }
}
