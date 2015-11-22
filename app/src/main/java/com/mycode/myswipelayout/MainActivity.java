package com.mycode.myswipelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    ImageView imageView;
    ImageView imageView12,ImageView;
    TextView imageView1;
    LinearLayout linearLayout;
    ViewGroup moveLayout;
    DisplayMetrics metrics;
    int mX;
    int mY;
    private SwipeLayout sample1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Log.d("Resolution", "resolution: " + metrics.widthPixels/2 + " x " + metrics.heightPixels);

//        sample1 = (SwipeLayout) findViewById(R.id.sample1);
//        sample1.setShowMode(SwipeLayout.ShowMode.PullOut);
//        View starBottView = sample1.findViewById(R.id.starbott);
//        sample1.addDrag(SwipeLayout.DragEdge.Left, sample1.findViewById(R.id.bottom_wrapper));
//        sample1.addDrag(SwipeLayout.DragEdge.Right, sample1.findViewById(R.id.bottom_wrapper_2));
//        sample1.addDrag(SwipeLayout.DragEdge.Right, starBottView);
//        sample1.addDrag(SwipeLayout.DragEdge.Bottom, starBottView);
//        sample1.addRevealListener(R.id.delete, new SwipeLayout.OnRevealListener() {
//            @Override
//            public void onReveal(View child, SwipeLayout.DragEdge edge, float fraction, int distance) {
//
//            }
//        });
//
//        sample1.getSurfaceView().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Click on surface", Toast.LENGTH_SHORT).show();
//                Log.d(MainActivity.class.getName(), "click on surface");
//            }
//        });
//        sample1.getSurfaceView().setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Toast.makeText(MainActivity.this, "longClick on surface", Toast.LENGTH_SHORT).show();
//                Log.d(MainActivity.class.getName(), "longClick on surface");
//                return true;
//            }
//        });
//        sample1.findViewById(R.id.star2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Star", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        sample1.findViewById(R.id.trash2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Trash Bin", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        sample1.findViewById(R.id.magnifier2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Magnifier", Toast.LENGTH_SHORT).show();
//            }
//        });

        moveLayout = (ViewGroup) findViewById(R.id.move);
//        imageView = (ImageView) findViewById(R.id.ImageView);
        imageView1 = (TextView) findViewById(R.id.ImageView1);
        imageView = (ImageView) findViewById(R.id.ImageView);

//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(100, 100);
        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


//        imageView.setLayoutParams(layoutParams);
        imageView1.setLayoutParams(layoutParams1);
//        imageView.setOnTouchListener(this);
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
                System.out.println("X= " + X + "mX= " + mX);
                if (X >= metrics.widthPixels/2) {
                    layoutParams.leftMargin = X - mX;
                }
                if (X >= 500) {
                    layoutParams.leftMargin = X - mX;
                }
//                layoutParams.topMargin = Y - mY;
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;
                v.setLayoutParams(layoutParams);
                break;
            case MotionEvent.ACTION_UP: //реакция на окончание нажатия на экран
            {
                RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) v.getLayoutParams();
                layoutParams1.leftMargin = X - mX;
                System.out.println("X= " + X + "mX= " + mX);
                if (X >= 1 || X <= 1) {
                    imageView1.setBackgroundColor(getResources().getColor(R.color.light));
                    imageView1.setTextColor(getResources().getColor(R.color.colorAccent));
                    layoutParams1.leftMargin = 0;
                    imageView1.setText("DA");
                    imageView.setLayoutParams(layoutParams1);
                }if(X >= metrics.widthPixels/4){
                imageView1.setText("DA");
                imageView1.setTextColor(getResources().getColor(R.color.light));
                imageView1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                imageView1.setText("DA!!!");
                layoutParams1.leftMargin = metrics.widthPixels/4 ;
            }
                if (X >= metrics.widthPixels/2) {
                    imageView1.setText("DA!!DA!!!");
                    imageView1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    layoutParams1.leftMargin = metrics.widthPixels - metrics.widthPixels/8 ;

                }
                if (X == 500) {
                    layoutParams1.leftMargin = X - mX;
                } else
//                layoutParams.topMargin = Y - mY;
                    layoutParams1.rightMargin = 0;
                layoutParams1.bottomMargin = 0;
                v.setLayoutParams(layoutParams1);
                //обработка событие отпускания
            }
            break;
        }
        return true;
    }
}
