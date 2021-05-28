package com.example.y3033127kadai2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;

public class MyView extends View {

    private Path path;
    private Paint paint;
    @Nullable
    private AttributeSet attrs;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        path = new Path();//コンストラクタ、グラフィック

        paint  = new Paint();//筆の種類
        paint.setColor(Color.BLUE);//色の種類
        paint.setStyle(Paint.Style.STROKE);//線を引く
        paint.setStrokeWidth(10);//幅

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();//x座標
        float y = event.getY();//y座標

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x,y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        //return super.onTouchEvent(event);
        return true;
    }

    public void clearCanvas() {
        path.reset();
        invalidate();
    }

}


