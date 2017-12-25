package test.bwie.apple.mamingze_1509a_1221.utils;

/**
 * Created by Apple on 2017/12/21.
 */

public class Api {
    //公共
    public static final String HOST = "http://120.27.23.105/";
    //登录接口
    public static final String LOGIN = "user/login";
    //注册接口
    public static final String REG = "user/reg";
    //商品接口
    public static final String SHOP = "product/getProducts?pscid=40&page=1";
    //详情接口
    public static final String XIANGQING = "product/getProductDetail?source=android";
    //加入购物车
    public static final String ADD = "product/addCart?source=android&uid=4682";
    //查询购物车
    public static final String FIND = "product/getCarts?uid=4682&source=android";
    //删除购物车
    public static final String DEL = "product/deleteCart?uid=4682&pid=1";
    //更新购物车
    public static final String FRESH = "product/updateCarts?uid=4682&sellerid=1&pid=1&selected=0&num=10";
}
