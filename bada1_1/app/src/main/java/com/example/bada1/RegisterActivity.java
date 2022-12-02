package com.example.bada1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;     //파이어베이스 인증
    private DatabaseReference mDatabaseRef; //실시간 데이터베이스
    private EditText mEtEmail, mEtPwd, mEtLocation, mEtTopic;      //회원가입 입력필드
    private Button mBtnRegister;            // 회원가입 버튼
    private FirebaseAuth mAuth;
    private static final String TAG = "로그";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("teambada");

        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pwd);
        mEtLocation = findViewById(R.id.et_location);
        mEtTopic = findViewById(R.id.et_topic);
        mBtnRegister = findViewById(R.id.btn_register);

        mAuth = FirebaseAuth.getInstance();

      //  mBtnRegister.setOnClickListener(this);

        mBtnRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                //회원가입 처리 시작(회원가입 버튼 눌린 경우)
                String strEmail = mEtEmail.getText().toString();
                String strPwd = mEtPwd.getText().toString();
                String strLocation = mEtLocation.getText().toString();
                String strTopic = mEtTopic.getText().toString();

                //Firebase Auth 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {

                        //회원가입이 성공이 되었을 때
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid());  //UID
                            account.setEmailId(firebaseUser.getEmail());
                            account.setPassword(strPwd);
                            account.setLocation(strLocation);
                            account.setTopic(strTopic);

                           // setValue는 database에 insert하는 행위
                            mDatabaseRef.child("userAccount").child(account.getIdToken()).setValue(account);

                            Toast.makeText(RegisterActivity.this, "회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(RegisterActivity.this, "이메일 형식이 아니거나 다른 아이디와 중복됩니다", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });
    }

//    @Override
//    public void onClick(View view) {
//        Log.d(TAG, "onClick");
//        String strEmail = mEtEmail.getText().toString();
//        String strPwd = mEtPwd.getText().toString();
//        Log.d(TAG, strEmail);
//        Log.d(TAG, strPwd);
//        mAuth.createUserWithEmailAndPassword(strEmail, strPwd)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d("로그", "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                        //    updateUI(user);
//                            Toast.makeText(RegisterActivity.this, "Authentication isSuccessful.",
//                                    Toast.LENGTH_SHORT).show();
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w("로그", "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                          //  updateUI(null);
//                        }
//                    }
//                });
//    }
}