package com.example.y3033127kadai2;

//tools:layout_editor_absoluteX="-7dp"
  //      tools:layout_editor_absoluteY="4dp"

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyView myview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myview = (MyView) findViewById(R.id.myView);
    }

    public void onClear(View view) {
        myview.clearCanvas();//　初期化
    }

    // 色について
    public void RED(View view){
        myview.ColorRED();
    }
    public void GREEN(View view){
        myview.ColorGREEN();
    }
    public void BLUE(View view){
        myview.ColorBLUE();
    }

    // 線について
    public void Fill(View view){
        myview.StyleFill();
    }
    public void FS(View view){
        myview.StyleFS();
    }
    public void Stroke(View view){
        myview.StyleStroke();
    }

    // 幅について
    public void Set5(View view){
        myview.set5();
    }
    public void Set10(View view){
        myview.set10();
    }
    public void Set15(View view){
        myview.set15();
    }
    /*public void Set20(View view){
        myview.set20();
    }
    <Button
    android:id="@+id/button13"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:onClick="Set20"
    android:text="20"
    tools:layout_editor_absoluteX="323dp"
    tools:layout_editor_absoluteY="635dp" />
    */

}

