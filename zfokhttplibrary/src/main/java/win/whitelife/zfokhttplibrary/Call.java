package win.whitelife.zfokhttplibrary;

import android.arch.lifecycle.Lifecycle;
import android.content.Context;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * @author wuzefeng
 */
public interface Call {

    Response get();

    Response post(String json);

    void getEnqueue(IHttpCallback httpCallback);

    void postEnqueue(String json,IHttpCallback httpCallback);

    Call addHeader(String name,String value);


    Call bindLifeCircle(Context context, Lifecycle.Event event);

}
