package com.example.bada1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bada1.activity.HomeActivity;
import com.example.bada1.modelClass.RecruitNotice;

public class RecruitActivity extends AppCompatActivity {

    EditText et_serv;
    EditText et_andr;
    EditText et_ios;
    EditText et_web;
    EditText et_gui;
    EditText et_setprj;
    EditText et_setloca;

    Button post;
    RecruitNotice RN=new RecruitNotice();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruit);
        et_setprj=findViewById(R.id.et_setprj);
        et_setloca=findViewById(R.id.et_setloca);
        et_serv=findViewById(R.id.et_serv);
        et_andr=findViewById(R.id.et_andr);
        et_ios=findViewById(R.id.et_ios);
        et_web=findViewById(R.id.et_web);
        et_gui=findViewById(R.id.et_gui);
        post=findViewById(R.id.btn_post);




        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prjtpc;
                String prjloca;
                String num_serv;
                String num_andr;
                String num_ios;
                String num_web;
                String num_gui;
                prjtpc=et_setprj.getText().toString();
                prjloca=et_setloca.getText().toString();
                num_serv=et_serv.getText().toString();
                num_andr=et_andr.getText().toString();
                num_ios=et_ios.getText().toString();
                num_web=et_web.getText().toString();
                num_gui=et_gui.getText().toString();
                RN.setProj(prjtpc);
                RN.setLoca(prjloca);
                RN.setServ(num_serv);
                RN.setAndr(num_andr);
                RN.setIos(num_ios);
                RN.setWeb(num_web);
                RN.setGui(num_gui);


                Intent rc = new Intent(RecruitActivity.this, HomeActivity.class);
                startActivity(rc);



            }
        });
    }
}