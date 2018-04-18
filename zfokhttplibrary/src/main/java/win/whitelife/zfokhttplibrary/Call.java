package win.whitelife.zfokhttplibrary;

import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * @author wuzefeng
 * @date 2018/4/18
 */
public interface Call {

    Response get();

    Response post(String json);

    void getEnqueue(IHttpCallback httpCallback);

    void postEnqueue(String json,IHttpCallback httpCallback);

    Call addHeader(String name,String value);

}
