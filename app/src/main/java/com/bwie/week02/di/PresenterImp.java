package com.bwie.week02.di;

import java.lang.ref.WeakReference;

/**
 * Created by YangYueXiang
 * on 2018/9/8
 */
public class PresenterImp implements IContract.ipresenter<IContract.iview>{
    private IContract.iview iview;
    private ModuleImp moduleImp;
    private WeakReference<IContract.imoudle> weakReference;
    private WeakReference<IContract.iview> iviewWeakReference;

    @Override
    public void attachView(IContract.iview iview) {
        this.iview=iview;
        moduleImp = new ModuleImp();
        //创建弱引用
        iviewWeakReference = new WeakReference<>(iview);
        weakReference = new WeakReference<IContract.imoudle>(moduleImp);
       // WeakReference<IContract.imoudle> weakReference = new WeakReference<IContract.imoudle>(moduleImp);

    }

    @Override
    public void detachView(IContract.iview iview) {
        iviewWeakReference.clear();
        weakReference.clear();
    }

    @Override
    public void requestInfo(String registusername, String registpassword) {
        moduleImp.requestdata(registusername,registpassword,new IContract.imoudle.calllisten() {
            @Override
            public void responmsg(String message) {
                iview.showData(message);
            }


        });
    }

    @Override
    public void requestInfo1(String name, String password) {
        moduleImp.requestdata1(name, password,new IContract.imoudle.calllisten() {
            @Override
            public void responmsg(String message) {
                iview.showData(message);
            }
        });
    }
}
