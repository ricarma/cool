package test.bwie.apple.mamingze_1509a_1221.net;

/**
 * Created by Apple on 2017/12/21.
 */

public interface OnNetListener<T> {
    public void onSuccess(T t);
    public void onError(Exception e);
}
