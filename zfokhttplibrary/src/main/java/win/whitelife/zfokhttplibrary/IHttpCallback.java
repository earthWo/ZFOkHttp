package win.whitelife.zfokhttplibrary;

import java.io.IOException;

import okhttp3.*;

/**
 * @author wuzefeng
 * @date 2018/4/18
 */
public interface IHttpCallback {

    void onFailure(okhttp3.Call call, IOException e);

    void onResponse(okhttp3.Call call, String response) throws IOException;

}
