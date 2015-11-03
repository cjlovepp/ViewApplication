package com.example.cj.MyCustomView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.jar.Attributes;


/**
 * 自定义View组件
 */
public class CustomView extends View {

    //定义初始化视图坐标
    public float currentX = 40;
    public float currentY = 50;
    //定义画笔
    Paint p = new Paint();

    /**
     * 构造方法一
     * 在Code中实例化时使用
     * @param context
     */
    public CustomView(Context context){
        super(context);
    }

    /**
     *构造方法二
     * 在XML中实例化时使用
     * @param context
     * @param set
     */
    public CustomView(Context context, AttributeSet set){
        super(context, set);
    }

    /**
     * 构造方法三
     * 系统不会自动调用该构造方法（需显示调用）
     * @param context
     * @param set
     * @param defStyle  //(R.attr.CustomizeStyle)指它在当前Application或Activity所用的Theme中的默认Style
     */
    public  CustomView(Context context, AttributeSet set, int defStyle){
        super(context, set, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔颜色
        p.setColor(Color.GREEN);
        canvas.drawCircle(currentX, currentY, 15, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = event.getX();
        currentY = event.getY();
        //通知当前组件重绘
        invalidate();
        //true表示返回该事件已处理
        return true;
    }
}
