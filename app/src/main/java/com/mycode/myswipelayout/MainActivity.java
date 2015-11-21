package com.mycode.myswipelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    ImageView imageView;
    ImageView imageView1;
    ViewGroup moveLayout;
    int mX;
    int mY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveLayout = (ViewGroup) findViewById(R.id.move);
        imageView = (ImageView) findViewById(R.id.ImageView);
        imageView1 = (ImageView) findViewById(R.id.ImageView1);

//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(100, 100);
        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(200, 300);

//        imageView.setLayoutParams(layoutParams);
        imageView1.setLayoutParams(layoutParams1);
        imageView.setOnTouchListener(this);
        imageView1.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        final int X = (int) event.getRawX();
//        final int Y = (int)event.getRawY();

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            //ACTION_DOWN срабатывает при прикосновении к экрану,
            //здесь определяется начальное стартовое положение объекта:
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                mX = X - lParams.leftMargin;
//                mY = Y - lParams.topMargin;
                break;

            //ACTION_MOVE обрабатывает случившиеся в процессе прикосновения изменения, здесь
            //содержится информация о последней точке, где находится объект после окончания действия прикосновения ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                layoutParams.leftMargin = X - mX;
//                layoutParams.topMargin = Y - mY;
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;
                v.setLayoutParams(layoutParams);
                break;
        }
        return true;
    }
}
