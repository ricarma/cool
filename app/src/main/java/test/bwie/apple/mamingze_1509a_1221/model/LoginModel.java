package test.bwie.apple.mamingze_1509a_1221.model;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.bwie.apple.mamingze_1509a_1221.bean.LoginBean;
import test.bwie.apple.mamingze_1509a_1221.model.imodel.ILoginModel;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;
import test.bwie.apple.mamingze_1509a_1221.utils.RetrofitHelper;
import test.bwie.apple.mamingze_1509a_1221.utils.ServiceApi;

/**
 * Created by Apple on 2017/12/21.
 */

public class LoginModel implements ILoginModel{
    @Override
    public void dologin(String mobile, String password, final OnNetListener<LoginBean> onNetListener) {
        ServiceApi serviceApi = RetrofitHelper.getServiceApi();
        serviceApi.loginbean(mobile,password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<LoginBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LoginBean loginBean) {
                onNetListener.onSuccess(loginBean);
            }
        });
    }
}
