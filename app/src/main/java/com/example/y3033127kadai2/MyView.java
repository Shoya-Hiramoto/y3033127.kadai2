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

import java.util.ArrayList;
import java.util.List;

public class MyView extends View {

    // 履歴
    private List<DrawLine> lines;

    private Path path;
    private Paint paint;
    @Nullable
    private AttributeSet attrs;

    // 線の履歴(座標＋色)
    class DrawLine {
        private Paint paint;
        private Path path;

        DrawLine(Path path, Paint paint) {
            this.paint = new Paint(paint);
            this.path = new Path(path);
        }

        void draw(Canvas canvas) {
            canvas.drawPath(path, paint);
        }
    }


    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        path = new Path();//コンストラクタ、グラフィック
        paint  = new Paint();//筆の種類
        paint.setColor(Color.BLUE);//色の種類
        paint.setStyle(Paint.Style.STROKE);//線を引く
        paint.setStrokeWidth(10);//幅

        lines = new ArrayList<DrawLine>();//線の保存

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);// 現在、描いている線を描画
        canvas.drawPath(path, paint);// キャンバスをクリア
        canvas.drawColor(Color.WHITE);

        // 履歴から線を描画
        for(DrawLine line : this.lines) {
            line.draw(canvas);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();//x座標
        float y = event.getY();//y座標

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:// タッチパネルが押されたとき
                path.moveTo(x,y);
                invalidate();// 画面を強制的に再描画
                break;
            case MotionEvent.ACTION_MOVE:// タッチパネルを押しながら動いている時
                path.lineTo(x,y);
                invalidate();// 画面を強制的に再描画
                break;
            case MotionEvent.ACTION_UP:// タッチパネルから離れた時
                path.lineTo(x, y);
                // 指を離したので、履歴に追加する
                this.lines.add(new DrawLine(path, paint));
                // パスをリセットする
                // これを忘れると、全ての線の色が変わってしまう
                path.reset();
                break;

        }

        //return super.onTouchEvent(event);　falseのため削除
        invalidate();
        return true;
    }

    public void clearCanvas() {

        lines.clear();// 履歴をクリア
        path.reset();// 現在の線をクリア
        invalidate();// 画面を強制的に再描画
    }

    //　色について
    public void ColorRED(){
        paint.setColor(Color.RED);// 赤色
    }
    public void ColorGREEN(){
        paint.setColor(Color.GREEN);// 緑色
    }
    public void ColorBLUE(){
        paint.setColor(Color.BLUE);// 青色
    }

    //　線について
    public void StyleFill(){
        paint.setStyle(Paint.Style.FILL);//塗りつぶし
    }
    public void StyleFS(){
        paint.setStyle(Paint.Style.FILL_AND_STROKE);//塗りつぶし＋線を引く
    }
    public void StyleStroke(){
        paint.setStyle(Paint.Style.STROKE);//線を引く
    }

    // 太さについて
    public void set5(){
        paint.setStrokeWidth(5);//幅
    }
    public void set10(){
        paint.setStrokeWidth(10);//幅
    }
    public void set15(){
        paint.setStrokeWidth(15);//幅
    }

}


