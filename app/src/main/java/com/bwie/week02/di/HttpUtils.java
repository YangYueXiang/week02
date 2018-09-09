package com.bwie.week02.di;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by YangYueXiang
 * on 2018/9/8
 */
public class HttpUtils {
    //成员变量
    private  static HttpUtils httpUtils;
    public static HttpUtils getinstance(){
        if (httpUtils==null){
            synchronized (HttpUtils.class){
                if (httpUtils==null){
                    httpUtils=new HttpUtils();
                }
            }
        }
        return httpUtils;
    }
    private OkHttpClient okHttpClient;
    //有参
    private  HttpUtils(){
        okHttpClient=new OkHttpClient();
    }


    //post请求
    public void postData(String path, FormBody formBody, Callback callback){
        Request request = new Request
                .Builder()
                .method("POST",formBody)
                .url(path)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    //get请求
    public void getData(String path1,Callback callback){
        Request request = new Request.Builder()
                .url(path1)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
