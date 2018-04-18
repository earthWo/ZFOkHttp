package win.whitelife.zfokhttplibrary;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * @author wuzefeng
 * @date 2018/4/18
 */
public class ResponseHandler extends Handler {


    private Handler mHandler;

    public ResponseHandler(){
        super(Looper.getMainLooper());
    }


    @Override
    public void handleMessage(Message msg) {



    }



}
