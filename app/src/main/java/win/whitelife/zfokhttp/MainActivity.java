package win.whitelife.zfokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;
import win.whitelife.zfokhttplibrary.HttpClient;
import win.whitelife.zfokhttplibrary.IHttpCallback;

/**
 * @author wuzefeng
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpClient.getInstanse().newRequest("Http://www.baidu.com").getEnqueue(new IHttpCallback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, String response) throws IOException {
                Log.e(TAG,response) ;
            }
        });

    }

    String TAG="测试打印";
}
