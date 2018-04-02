package xinyi.com.viewstudy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jiajun.wang on 2018/3/30.
 */

public class MyGroup extends ViewGroup {

    private int allX=0;
    private int allY=0;
    public MyGroup(Context context) {
        super(context);
    }

    public MyGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        View childView = null;
        int width=MeasureSpec.getSize(widthMeasureSpec);
        int wMode=MeasureSpec.getMode(widthMeasureSpec);
        int height=MeasureSpec.getSize(heightMeasureSpec);
        int hMode=MeasureSpec.getMode(heightMeasureSpec);
        for (int i = 0; i < childCount; i++) {
            childView = getChildAt(i);
            LayoutParams params=childView.getLayoutParams();
            int h=params.height;
            int w=params.width;
            int w1=childView.getMeasuredWidth();
            if (width-allX>=w){
                allX=allX+w;

            }else {
                allX=0;
            }
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


}
