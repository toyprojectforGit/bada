package com.example.bada1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bada1.R;
import com.example.bada1.modelClass.User;

public class MapActivity extends AppCompatActivity {

    Button btn_seoul;
    Button btn_gyenggi;
    Button btn_gangwon;
    Button btn_chungbuk;
    Button btn_chungnam;
    Button btn_gyengbuk;
    Button btn_jeonbuk;
    Button btn_jeonnam;
    Button btn_gyengnam;
    Button btn_jeju;
    User sail;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        sail=new User();

        btn_seoul=findViewById(R.id.seoul);
        btn_seoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sail.setLocation("서울");
                Intent s=new Intent(MapActivity.this, NoticeBoardActivity.class);
                startActivity(s);

            }
        });
        btn_seoul=findViewById(R.id.seoul);
        btn_seoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sail.setLocation("서울");
                Intent s=new Intent(MapActivity.this,NoticeBoardActivity.class);
                startActivity(s);

            }
        });
        btn_gyenggi=findViewById(R.id.gyeonggi);
        btn_gyenggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sail.setLocation("경기");
                Intent gg=new Intent(MapActivity.this,NoticeBoardActivity.class);
                startActivity(gg);

            }
        });
        btn_gangwon=findViewById(R.id.kangwon);
        btn_gangwon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sail.setLocation("강원");
                Intent kw=new Intent(MapActivity.this,NoticeBoardActivity.class);
                startActivity(kw);

            }
        });
        btn_chungbuk=findViewById(R.id.chungbuk);
        btn_chungbuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sail.setLocation("충북");
                Intent cb=new Intent(MapActivity.this,NoticeBoardActivity.class);
                startActivity(cb);

            }
        });
        btn_chungnam=findViewById(R.id.chungnam);
        btn_chungnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sail.setLocation("충남");
                Intent cn=new Intent(MapActivity.this,NoticeBoardActivity.class);
                startActivity(cn);

            }
        });
        btn_gyengbuk=findViewById(R.id.gyeongbuk);
        btn_gyengbuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sail.setLocation("경북");
                Intent gb=new Intent(MapActivity.this,NoticeBoardActivity.class);
                startActivity(gb);

            }
        });
        btn_jeonbuk=findViewById(R.id.jeonbuk);
        btn_jeonbuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sail.setLocation("전북");
                Intent jb=new Intent(MapActivity.this,NoticeBoardActivity.class);
                startActivity(jb);

            }
        });
        btn_gyengnam=findViewById(R.id.gyeongnam);
        btn_gyengnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sail.setLocation("경남");
                Intent gn=new Intent(MapActivity.this,NoticeBoardActivity.class);
                startActivity(gn);

            }
        });
        btn_jeonnam=findViewById(R.id.jeonnam);
        btn_jeonnam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sail.setLocation("전남");
                Intent jn=new Intent(MapActivity.this,NoticeBoardActivity.class);
                startActivity(jn);

            }
        });
        btn_jeju=findViewById(R.id.jeju);
        btn_jeju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sail.setLocation("제주");
                Intent jj=new Intent(MapActivity.this,NoticeBoardActivity.class);
                startActivity(jj);

            }
        });


    }
}