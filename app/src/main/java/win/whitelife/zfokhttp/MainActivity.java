package win.whitelife.zfokhttp;

import android.arch.lifecycle.Lifecycle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;
import win.whitelife.zfokhttplibrary.HttpClient;
import win.whitelife.zfokhttplibrary.IHttpCallback;

/**
 * @author wuzefeng
 */
public class MainActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=findViewById(R.id.tv);
        HttpClient.getInstanse().newRequest("https://www.zhibo8.cc/").bindLifeCircle(this, Lifecycle.Event.ON_STOP).getEnqueue(new IHttpCallback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, String response)  {
                mTextView.setText(response);
            }
        });

    }

    String TAG="测试打印";
}
