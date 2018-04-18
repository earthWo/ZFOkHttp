package win.whitelife.zfokhttplibrary;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author wuzefeng
 * @date 2018/4/18
 */
public class RealCall implements Call {

    private OkHttpClient mOkHttpClient;

    private String url;

    private Request.Builder mBuilder;


    private RealCall(String url,OkHttpClient okHttpClient){
        this.url=url;
        this.mOkHttpClient=okHttpClient;
        mBuilder=new Request.Builder().url(url).get();

    }

    public static Call newRequest(String url,OkHttpClient okHttpClient) {
        return new RealCall(url,okHttpClient);
    }

    @Override
    public Response get() {
        Request request=mBuilder.build();
        return callRequst(request);
    }

    @Override
    public Response post(String json) {
        RequestBody requestBody=RequestBody.create(MediaTypes.JSON,json);
        Request request=mBuilder.post(requestBody).build();
        return callRequst(request);
    }


    private Response callRequst(Request request){
        Response response=null;
        try {
            response=mOkHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response==null){
            response=new Response.Builder().message("请求失败").build();
        }
        return response;
    }

    @Override
    public void getEnqueue(IHttpCallback httpCallback) {

    }

    @Override
    public void postEnqueue(String json, IHttpCallback httpCallback) {

    }


    @Override
    public Call addHeader(String name, String value) {
        mBuilder.addHeader(name,value);
        return this;
    }

}
