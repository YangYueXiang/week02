package com.bwie.week02.di;

/**
 * Created by YangYueXiang
 * on 2018/9/8
 */
public interface IContract {
    /**
     * iview
     */
    public interface iview{
        //更新ui
        void showData(String message);
    }
    /**
     * ipresenter
     */
    public interface ipresenter<iview>{
        //关联视图
        void attachView(iview iview);
        //取消
        void detachView(iview iview);
        //逻辑
        void requestInfo(String registusername, String registpassword);
        //登陆
        void requestInfo1(String name, String password);
    }
    public  interface imoudle {
        //接口回调
    interface calllisten{
        //接收消息
            void responmsg(String message);
        }
        //代码操作的方法
        void requestdata(String registusername, String registpassword, calllisten calllisten);
        void requestdata1(String name, String password, calllisten calllisten);

    }

}

