package win.whitelife.zfokhttplibrary;

import android.os.Message;

import java.io.IOException;

import okhttp3.Callback;
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
        return callRequest(request);
    }

    @Override
    public Response post(String json) {
        RequestBody requestBody=RequestBody.create(MediaTypes.JSON,json);
        Request request=mBuilder.post(requestBody).build();
        return callRequest(request);
    }


    private Response callRequest(Request request){
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

    private void callRequest(final Request request, final IHttpCallback iHttpCallback){
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                HttpResponse response=new HttpResponse(call,e,null,iHttpCallback);
                Message message=Message.obtain();
                message.what=ResponseType.FAILURE;
                message.obj=response;
                HttpClient.getInstanse().getResponseHandler().sendMessage(message);
            }

            @Override
            public void onResponse(okhttp3.Call call, Response res) throws IOException {
                HttpResponse response=new HttpResponse(call,null,res.body().string(),iHttpCallback);
                Message message=Message.obtain();
                message.what=ResponseType.SUCCRSS;
                message.obj=response;
                HttpClient.getInstanse().getResponseHandler().sendMessage(message);
            }
        });
    }

    @Override
    public void getEnqueue(IHttpCallback httpCallback) {
        Request request=mBuilder.build();
        callRequest(request,httpCallback);
    }

    @Override
    public void postEnqueue(String json, IHttpCallback httpCallback) {
        RequestBody requestBody=RequestBody.create(MediaTypes.JSON,json);
        Request request=mBuilder.post(requestBody).build();
        callRequest(request,httpCallback);
    }


    @Override
    public Call addHeader(String name, String value) {
        mBuilder.addHeader(name,value);
        return this;
    }

}
