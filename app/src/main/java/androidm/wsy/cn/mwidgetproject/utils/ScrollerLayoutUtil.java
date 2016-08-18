package androidm.wsy.cn.mwidgetproject.utils;

import android.support.v4.widget.NestedScrollView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

/**
 * Created by wsy on 2016/8/17.
 */
public class ScrollerLayoutUtil {

    private NestedScrollView mNestedScroller;
    private ViewGroup mBottomLayout;

    private ScrollerLayoutUtil(NestedScrollView scroller, ViewGroup view) {
        this.mNestedScroller = scroller;
        this.mBottomLayout = view;
        init();
    }

    public static void delegate(NestedScrollView scroller, ViewGroup view) {
        new ScrollerLayoutUtil(scroller, view);
    }

    private void init() {

        //這裡處理滑動移動的位移
        mNestedScroller.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                Log.i("wusy"," "+scrollY + " "+oldScrollY);
                int moveY = scrollY - oldScrollY;
                int translationY = (int) (moveY + mBottomLayout.getTranslationY());
                if (moveY > 0) {//上滑
                    if (translationY > mBottomLayout.getHeight()) {//已经全部消失就不再偏移
                        mBottomLayout.setTranslationY(mBottomLayout.getHeight());
                    } else {
                        mBottomLayout.setTranslationY(translationY);
                    }
                } else {//下滑
                    Log.i("wusy", " " + translationY + " ");
                    if (translationY < 0) {//防止往上跑
                        mBottomLayout.setTranslationY(mBottomLayout.getTranslationY());
                    } else {
                        mBottomLayout.setTranslationY(translationY);
                    }
                }
            }
        });

        //這裡處理釋放的時候動畫 如果上滑超過一半自動隱藏 下滑超過一半自動顯示
        mNestedScroller.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:

                        Log.i("wusy",mNestedScroller.getScrollY() +" ");
                        if (mNestedScroller.getScrollY() >0){
                            if (mBottomLayout.getTranslationY() > mBottomLayout.getHeight() /2){
                                animateHide();
                            }else{
                                animateShow();
                            }
                        }
                        break;
                }
                return false;
            }
        });
    }


    //引用別人的位移動畫
    private void animateShow(){
        mBottomLayout.animate()
                .translationY(0)
                .setInterpolator(new LinearInterpolator())
                .setDuration(180);
    }

    private void animateHide(){
        mBottomLayout.animate()
                .translationY(mBottomLayout.getHeight())
                .setInterpolator(new LinearInterpolator())
                .setDuration(180);
    }

}
