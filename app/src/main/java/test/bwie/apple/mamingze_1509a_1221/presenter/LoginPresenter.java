package test.bwie.apple.mamingze_1509a_1221.presenter;

import test.bwie.apple.mamingze_1509a_1221.bean.LoginBean;
import test.bwie.apple.mamingze_1509a_1221.model.LoginModel;
import test.bwie.apple.mamingze_1509a_1221.model.imodel.ILoginModel;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;
import test.bwie.apple.mamingze_1509a_1221.view.iview.LoginView;

/**
 * Created by Apple on 2017/12/21.
 */

public class LoginPresenter {
    ILoginModel iLoginModel;
    LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        iLoginModel = new LoginModel();
    }
    public void dolp(String mobile,String password){
        iLoginModel.dologin(mobile, password, new OnNetListener<LoginBean>() {
            @Override
            public void onSuccess(LoginBean loginBean) {
                loginView.login(loginBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
