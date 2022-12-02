package com.example.bada1.modelClass;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FDBUser {
    private DatabaseReference teambada;
    private DatabaseReference databaseReference;


     FDBUser() {
         FirebaseDatabase db=FirebaseDatabase.getInstance();
         teambada=db.getReference("teambada");
         databaseReference=teambada.child("userAccount");
    }

    public Task<Void> add(User user){return databaseReference.push().setValue(user);}
    public Query get(){return databaseReference;}
}
