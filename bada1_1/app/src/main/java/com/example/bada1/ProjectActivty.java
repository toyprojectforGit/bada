package com.example.bada1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.bada1.databinding.ActivityProjectActivtyBinding;

public class ProjectActivty extends AppCompatActivity implements View.OnClickListener {
    private ActivityProjectActivtyBinding mbinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mbinding = ActivityProjectActivtyBinding.inflate(getLayoutInflater());
        setContentView(mbinding.getRoot());
        mbinding.projectComplteBtn.setOnClickListener(this);

        mbinding.projectAppBtn.setOnClickListener(this);
        mbinding.projectIappBtn.setOnClickListener(this);
        mbinding.projectWebBtn.setOnClickListener(this);
        mbinding.projectServerBtn.setOnClickListener(this);
        mbinding.projectDesignBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(view == mbinding.projectComplteBtn) {
            Log.d("태그", "컴플리트 버튼을 눌렀습니다");
            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            intent.putExtra("key", "projectComplteBtn");
            startActivity(intent);
        }else if (view == mbinding.projectAppBtn){
            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            intent.putExtra("key", "projectAppBtn");
            startActivity(intent);
        }else if (view == mbinding.projectIappBtn){
            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            intent.putExtra("key", "projectIappBtn");
            startActivity(intent);
        }else if (view == mbinding.projectWebBtn){
            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            intent.putExtra("key", "projectWebBtn");
            startActivity(intent);
        }else if (view == mbinding.projectServerBtn) {
            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            intent.putExtra("key", "projectServerBtn");
            startActivity(intent);
        }else if (view == mbinding.projectDesignBtn) {
            Intent intent = new Intent(getApplicationContext(), MapActivity.class);
            intent.putExtra("key", "projectDesignBtn");
            startActivity(intent);
        }
    }
}