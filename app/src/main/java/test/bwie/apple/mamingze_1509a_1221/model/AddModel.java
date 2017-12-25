package test.bwie.apple.mamingze_1509a_1221.model;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bwie.apple.mamingze_1509a_1221.bean.AddBean;
import test.bwie.apple.mamingze_1509a_1221.model.imodel.IAddModel;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;
import test.bwie.apple.mamingze_1509a_1221.utils.RetrofitHelper;
import test.bwie.apple.mamingze_1509a_1221.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/21.
 */

public class AddModel implements IAddModel{
    @Override
    public void doadd(String pid, final OnNetListener<AddBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        serviceApi.addbean(pid).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<AddBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(AddBean addBean) {
                onNetListener.onSuccess(addBean);
            }
        });
    }
}
