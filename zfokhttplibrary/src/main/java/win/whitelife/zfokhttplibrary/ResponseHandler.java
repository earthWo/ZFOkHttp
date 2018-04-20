package win.whitelife.zfokhttplibrary;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.io.IOException;

import okhttp3.*;


/**
 * @author wuzefeng
 */
public class ResponseHandler extends Handler {

    public ResponseHandler(){
        super(Looper.getMainLooper());
    }

    @Override
    public void handleMessage(Message msg) {

        HttpResponse httpResponse= (HttpResponse) msg.obj;
        IHttpCallback callback=httpResponse.getIHttpCallback();
        okhttp3.Call call=httpResponse.getCall();
        String response=httpResponse.getResponse();
        IOException exception=httpResponse.getIOException();
        if(msg.what==ResponseType.SUCCRSS){
            try {
                callback.onResponse(call,response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(msg.what==ResponseType.FAILURE){
            callback.onFailure(call,exception);
        }
    }






}
