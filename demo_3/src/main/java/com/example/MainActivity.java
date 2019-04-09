package com.example;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.R.*;

public class MainActivity extends AppCompatActivity {
    private int[] picture = new int[]{
            drawable.benghuai_1, drawable.benghuai_2,
            drawable.benghuai_3, drawable.benghuai_4,
            drawable.benghuai_1, drawable.benghuai_2,
            drawable.benghuai_3, drawable.benghuai_4,
            drawable.benghuai_5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        GridView gridView = (GridView) findViewById(id.gridview);
        gridView.setAdapter(new ImageAdapter(this));
    }
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        public ImageAdapter(Context c) {
            mContext = c;
        }
        @Override
        public int getCount() {

            return picture.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if(convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(100,90));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(picture[position]);
            return imageView;
        }
    }

}
