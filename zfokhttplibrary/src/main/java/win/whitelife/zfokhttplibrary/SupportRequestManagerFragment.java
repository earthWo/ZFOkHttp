package win.whitelife.zfokhttplibrary;

import android.app.Fragment;
import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author wuzefeng
 * @date 2018/4/24
 */
public class SupportRequestManagerFragment extends Fragment {

    private LifeListener mLifeListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(mLifeListener!=null){
            mLifeListener.lifeCircleUpdate(Lifecycle.Event.ON_CREATE);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if(mLifeListener!=null){
            mLifeListener.lifeCircleUpdate(Lifecycle.Event.ON_START);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mLifeListener!=null){
            mLifeListener.lifeCircleUpdate(Lifecycle.Event.ON_RESUME);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mLifeListener!=null){
            mLifeListener.lifeCircleUpdate(Lifecycle.Event.ON_PAUSE);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mLifeListener!=null){
            mLifeListener.lifeCircleUpdate(Lifecycle.Event.ON_STOP);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mLifeListener!=null){
            mLifeListener.lifeCircleUpdate(Lifecycle.Event.ON_DESTROY);
        }
    }


    public void registerLifeListener(LifeListener lifeListener){
        this.mLifeListener=lifeListener;
    }
}
