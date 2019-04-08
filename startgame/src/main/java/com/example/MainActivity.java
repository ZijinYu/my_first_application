package com.example;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     private ProgressBar progressBar;
    private int mProgress;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);  //设置全屏显示
        progressBar= (ProgressBar) findViewById(R.id.progerssBar);
        mHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==0x111) {
                    progressBar.setProgress(mProgress);
                }else {
                    Toast.makeText(MainActivity.this, "耗时操作已完成", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    mProgress=doWork();
                    Message m=new Message();
                    if(mProgress<100) {
                        m.what=0x111;
                        mHandler.sendMessage(m);
                    }else{
                        m.what=0x110;
                        mHandler.sendMessage(m);
                        break;
                    }
                }
            }
            private int doWork () {
                mProgress += Math.random()*10;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return mProgress;
            }
        }).start();
    }
}
