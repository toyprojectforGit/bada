package com.example.bada1.activity;


import static com.example.bada1.util.UserPrivateData.USERTOKEN;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bada1.R;
import com.example.bada1.util.UserPrivateData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private static final Object TAG ="로그" ;
    private FirebaseAuth mAuth;
    private Button mBtnLogin;            // 회원가입 버튼
    private EditText emailEdit ;
    private EditText passwordEdit ;

    private static final String TG = "로그";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //회원가입 화면으로 이동 ,엑티비티 이동할때 intent 사용용
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        emailEdit= findViewById(R.id.et_email);

        passwordEdit = findViewById(R.id.et_pwd);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String email = emailEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                signIn(email,password);

            }
        });



    }
    private void signIn(String email, String password) {
        // [START sign_in_with_email]

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Log.d("로그",mAuth.getUid());
                            USERTOKEN = mAuth.getUid();
                            Log.d("로그","email -> 성공email");
                            Toast.makeText(LoginActivity.this, "로그인 성공",
                                    Toast.LENGTH_SHORT).show();
                            UserPrivateData.USERID = email;
                            Intent d = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(d);
                        }

                        else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // [END sign_in_with_email]
    }
}