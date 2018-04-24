package win.whitelife.zfokhttplibrary;

import android.arch.lifecycle.Lifecycle;

/**
 * @author wuzefeng
 * @date 2018/4/24
 */
public interface LifeListener {



    void lifeCircleUpdate(Lifecycle.Event event);
}
