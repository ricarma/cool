package test.bwie.apple.mamingze_1509a_1221.utils;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import test.bwie.apple.mamingze_1509a_1221.bean.AddBean;
import test.bwie.apple.mamingze_1509a_1221.bean.CarBean;
import test.bwie.apple.mamingze_1509a_1221.bean.DelBean;
import test.bwie.apple.mamingze_1509a_1221.bean.LoginBean;
import test.bwie.apple.mamingze_1509a_1221.bean.RegBean;
import test.bwie.apple.mamingze_1509a_1221.bean.ShopQingBean;
import test.bwie.apple.mamingze_1509a_1221.bean.XiangQingBean;

/**
 * Created by Apple on 2017/12/21.
 */

public interface ServiceApi {
    //登录
    @GET(Api.LOGIN)
    Observable<LoginBean> loginbean(@Query("mobile") String mobile,@Query("password")String password);
    //注册
    @GET(Api.REG)
    Observable<RegBean> regbean(@Query("mobile") String mobile,@Query("password")String password);
    //商品
    @GET(Api.SHOP)
    Observable<ShopQingBean> xqbean();
    //详情
    @GET(Api.XIANGQING)
    Observable<XiangQingBean> xiangqingbean(@Query("pid")String pid);
    //加入购物车
    @GET(Api.ADD)
    Observable<AddBean> addbean(@Query("pid") String pid);
    //查询购物车
    @GET(Api.FIND)
    Observable<CarBean> carbean();
    //删除购物车
    @GET(Api.DEL)
    Observable<DelBean> delbean();
    //更新购物车

}
