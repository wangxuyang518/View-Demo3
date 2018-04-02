package xinyi.com.viewstudy;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jiajun.wang on 2018/3/30.
 */

public class MyView extends View {
    private int lastX;
    private int lastY;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean onTouchEvent(MotionEvent event) {
        //获取到手指处的横坐标和纵坐标
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算移动的距离
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //调用layout方法来重新放置它的位置

                //方式1
               /* layout(getLeft() + offsetX, getTop() + offsetY,
                        getRight() + offsetX, getBottom() + offsetY);*/

               //方式2
               /* offsetLeftAndRight(offsetX);
                offsetTopAndBottom(offsetY);*/

               //方式3
              /*  LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);*/

              //方式4
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                break;
        }
        return true;
    }
}
