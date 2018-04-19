package win.whitelife.zfokhttplibrary;

import java.io.IOException;

import okhttp3.*;
import okhttp3.Call;

/**
 * @author wuzefeng
 * @date 2018/4/19
 */
public class HttpResponse {

    private okhttp3.Call mCall;

    private IOException mIOException;

    private String mResponse;

    private IHttpCallback mIHttpCallback;

    public HttpResponse(Call call, IOException IOException, String response,IHttpCallback iHttpCallback) {
        mCall = call;
        mIOException = IOException;
        mResponse = response;
        mIHttpCallback = iHttpCallback;
    }

    public okhttp3.Call getCall() {
        return mCall;
    }

    public void setCall(Call call) {
        mCall = call;
    }

    public IOException getIOException() {
        return mIOException;
    }

    public void setIOException(IOException IOException) {
        mIOException = IOException;
    }

    public String getResponse() {
        return mResponse;
    }

    public void setResponse(String response) {
        mResponse = response;
    }

    public IHttpCallback getIHttpCallback() {
        return mIHttpCallback;
    }

    public void setIHttpCallback(IHttpCallback IHttpCallback) {
        mIHttpCallback = IHttpCallback;
    }
}
