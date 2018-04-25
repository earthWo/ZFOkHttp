package win.whitelife.zfokhttplibrary;

import okhttp3.OkHttpClient;

/**
 * @author wuzefeng
 */
public class HttpClient{

    private static volatile HttpClient sHttpClient;

    private OkHttpClient mOkHttpClient;


    private ResponseHandler mResponseHandler;

    private HttpClient() {

        mOkHttpClient=new OkHttpClient();

        mResponseHandler=new ResponseHandler();

    }

    public static HttpClient getInstanse(){
        if(sHttpClient==null){
            synchronized (HttpClient.class){
                if(sHttpClient==null){
                    sHttpClient=new HttpClient();
                }
            }
        }
        return sHttpClient;
    }


    public static void setHttpClient(HttpClient httpClient) {
        sHttpClient = httpClient;
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        mOkHttpClient = okHttpClient;
    }

    ResponseHandler getResponseHandler() {
        return mResponseHandler;
    }

    public Call newRequest(String url) {
        return  RealCall.newRequest(url,mOkHttpClient);
    }

}
