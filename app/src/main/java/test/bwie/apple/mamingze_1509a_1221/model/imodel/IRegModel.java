package test.bwie.apple.mamingze_1509a_1221.model.imodel;

import test.bwie.apple.mamingze_1509a_1221.bean.RegBean;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;

/**
 * Created by Apple on 2017/12/21.
 */

public interface IRegModel {
    public void doreg(String mobile, String password, OnNetListener<RegBean> onNetListener);
}
