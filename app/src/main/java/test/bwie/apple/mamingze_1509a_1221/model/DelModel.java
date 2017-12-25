package test.bwie.apple.mamingze_1509a_1221.model;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bwie.apple.mamingze_1509a_1221.bean.DelBean;
import test.bwie.apple.mamingze_1509a_1221.model.imodel.IDelModel;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;
import test.bwie.apple.mamingze_1509a_1221.utils.RetrofitHelper;
import test.bwie.apple.mamingze_1509a_1221.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/21.
 */

public class DelModel implements IDelModel{
    @Override
    public void dodel(final OnNetListener<DelBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        serviceApi.delbean().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<DelBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(DelBean delBean) {
                onNetListener.onSuccess(delBean);
            }
        });
    }
}
