package test.bwie.apple.mamingze_1509a_1221.model.imodel;

import test.bwie.apple.mamingze_1509a_1221.bean.LoginBean;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;

/**
 * Created by Apple on 2017/12/21.
 */

public interface ILoginModel {
    public void dologin(String mobile, String password, OnNetListener<LoginBean> onNetListener);
}
