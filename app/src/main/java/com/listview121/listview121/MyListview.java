package com.listview121.listview121;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/12/1.
 */

public class MyListview extends ListView {
    public MyListview(Context context) {
        super(context);
    }

    public MyListview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //重写listvie的自制方法.可以正确嵌套scrollview
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //自己写规则，注意此时的高是自己现在定的规则
        //Integer.MAX_VALUE >> 2,往后移两位
        int measureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, measureSpec);
    }
}
