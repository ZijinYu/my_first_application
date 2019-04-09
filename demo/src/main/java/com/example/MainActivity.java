package com.example;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Chronometer;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.R;

public class MainActivity extends AppCompatActivity {
    private int[] arrayPicture = new int[]{
            R.drawable.a1, R.drawable.a2, R.drawable.a3,
            R.drawable.a4, R.drawable.a5
    };
    private ImageSwitcher imageSwitcher;
    private int index;
    private float touchDownX;
    private float touchUpX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageswitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(arrayPicture[index]);
                return imageView;
            }
        });
        imageSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    touchDownX = event.getX();
                    return true;
                } else if(event.getAction()==MotionEvent.ACTION_UP) {
                    touchDownX = event.getX();
                    if(touchUpX - touchDownX > 100) {
                        index = index == 0?arrayPicture.length-1:index-1;
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.fade_in));
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.fade_out));
                        imageSwitcher.setImageResource(arrayPicture[index]);
                    } else if(touchDownX - touchUpX > 100){
                        index = index == arrayPicture.length-1?0:index+1;
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.fade_in));
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.fade_out));
                        imageSwitcher.setImageResource(arrayPicture[index]);//12
                    }

                    return true;
                }
                return false;
            }
        });
    }
}