package win.whitelife.zfokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import win.whitelife.zfokhttplibrary.HttpClient;

/**
 * @author wuzefeng
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpClient.getInstanse();
    }
}
