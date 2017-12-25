package test.bwie.apple.mamingze_1509a_1221.model.imodel;

import test.bwie.apple.mamingze_1509a_1221.bean.AddBean;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;

/**
 * Created by Apple on 2017/12/21.
 */

public interface IAddModel {
    public void doadd(String pid, OnNetListener<AddBean> onNetListener);
}
