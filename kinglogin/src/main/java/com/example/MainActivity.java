package com.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_login, cancel;
    private CheckBox checkBox1, checkBox2, checkBox3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = (Button) findViewById(R.id.btn_login);
        cancel = (Button) findViewById(R.id.cancel);
        checkBox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkbox3);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checked = "";
                if (checkBox1.isChecked()) {
                    checked += checkBox1.getText().toString();
                }
                if (checkBox2.isChecked()) {
                    checked += checkBox2.getText().toString();
                }
                if (checkBox3.isChecked()) {
                    checked += checkBox3.getText().toString();
                }
                Toast.makeText(MainActivity.this, checked, Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "取消有用吗？ahhhhh....确定全部都勾选？？？", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
