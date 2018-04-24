package win.whitelife.zfokhttplibrary;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.v4.app.FragmentActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuzefeng
 * @date 2018/4/24
 */
public class LifeCircleHelp {

    static final String FRAGMENT_TAG = "win.whitelife.zfohkttp.fragment.manager";


    private Map<FragmentManager,SupportRequestManagerFragment>pendingSupportRequestManagerFragments=new HashMap<>();


    private static volatile LifeCircleHelp sLifeCircleHelp;

    private LifeCircleHelp() {
    }

    public static LifeCircleHelp get(){
        if(sLifeCircleHelp==null){
            synchronized (LifeCircleHelp.class){
                if(sLifeCircleHelp==null){
                    sLifeCircleHelp=new LifeCircleHelp();
                }
            }
        }
        return sLifeCircleHelp;
    }




    public SupportRequestManagerFragment bindLifeCircle(Context context){
        SupportRequestManagerFragment supportRequestManagerFragment=null;
        if (context instanceof FragmentActivity) {
            supportRequestManagerFragment= bind((FragmentActivity) context);
        } else if (context instanceof Activity) {
            supportRequestManagerFragment= bind((Activity) context);
        } else if (context instanceof ContextWrapper) {
            supportRequestManagerFragment=bind(((ContextWrapper) context).getBaseContext());
        }
       return supportRequestManagerFragment;
    }

    private SupportRequestManagerFragment bind(Context baseContext) {
        return null;

    }

    private SupportRequestManagerFragment bind(Activity context) {
        FragmentManager fragmentManager= context.getFragmentManager();
        return bindFragment(fragmentManager);
    }

    private SupportRequestManagerFragment bind(FragmentActivity context) {
        FragmentManager fragmentManager=context.getFragmentManager();
        return bindFragment(fragmentManager);
    }

    private SupportRequestManagerFragment bindFragment(FragmentManager fm){
        SupportRequestManagerFragment current =
                (SupportRequestManagerFragment) fm.findFragmentByTag(FRAGMENT_TAG);
        if (current == null) {
            current = pendingSupportRequestManagerFragments.get(fm);
            if (current == null) {
                current = new SupportRequestManagerFragment();
                pendingSupportRequestManagerFragments.put(fm, current);
                fm.beginTransaction().add(current, FRAGMENT_TAG).commitAllowingStateLoss();
            }
        }
        return current;
    }



}
