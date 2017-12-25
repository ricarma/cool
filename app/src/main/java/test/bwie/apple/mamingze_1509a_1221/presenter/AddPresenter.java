package test.bwie.apple.mamingze_1509a_1221.presenter;

import rx.schedulers.Schedulers;
import test.bwie.apple.mamingze_1509a_1221.bean.AddBean;
import test.bwie.apple.mamingze_1509a_1221.model.AddModel;
import test.bwie.apple.mamingze_1509a_1221.model.imodel.IAddModel;
import test.bwie.apple.mamingze_1509a_1221.net.OnNetListener;
import test.bwie.apple.mamingze_1509a_1221.view.iview.AddView;

/**
 * Created by Apple on 2017/12/21.
 */

public class AddPresenter {
    IAddModel iAddModel;
    AddView addView;

    public AddPresenter(AddView addView) {
        this.addView = addView;
        iAddModel = new AddModel();
    }
    public void ap(String pid){
        iAddModel.doadd( pid, new OnNetListener<AddBean>() {
            @Override
            public void onSuccess(AddBean addBean) {
                addView.add(addBean);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
