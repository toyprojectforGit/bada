package com.example.bada1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoleSelectActivity extends AppCompatActivity {
Button btn_cap;
Button btn_sail;
    User user=new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_select);
        btn_cap=findViewById(R.id.btn_cap);
        String cap="팀장";
        btn_cap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setRole(cap);
                Intent ic=new Intent(RoleSelectActivity.this,RecruitActivity.class);
                startActivity(ic);

            }
        });
        btn_sail=findViewById(R.id.btn_sail);
        String sail="팀원";
        btn_sail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setRole(sail);
                Intent ss=new Intent(RoleSelectActivity.this,ProjectActivty.class);
                startActivity(ss);

            }
        });


    }
}