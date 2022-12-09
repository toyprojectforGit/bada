package com.example.bada1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.bada1.databinding.ActivityNoticeDetailBinding
import com.example.bada1.modelClass.NoticeModel
import com.example.bada1.util.util.TAG
import com.google.firebase.database.FirebaseDatabase

class NoticeDetailActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var mbinding:ActivityNoticeDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding=ActivityNoticeDetailBinding.inflate(layoutInflater)
        setContentView(mbinding.root)
        mbinding.detailBackBtn.setOnClickListener(this)

        if (intent.hasExtra("title")){
            val title = intent.getStringExtra("title")
            val databaseReference= FirebaseDatabase.getInstance().getReference("teambada").child("notice").child("$title")
            databaseReference.get().addOnSuccessListener {
                val tmpdata = it.getValue(NoticeModel::class.java) //만들어뒀던 user객체에 데이터를 담는다.
                mbinding.detailContent.text = tmpdata?.contents
                mbinding.detailTitle.text = tmpdata?.title
                mbinding.detailEmail.text = tmpdata?.useremail
                mbinding.detailLikeText.text="${tmpdata?.heartUsers?.count()}"
                mbinding.detailServer.text="서버 ${tmpdata?.sv_people}명"
                mbinding.detailAos.text="AOS ${tmpdata?.an_people}명"
                mbinding.detailDesign.text = "디자인 ${tmpdata?.des_people}명"
                mbinding.detailIos.text= "ios ${tmpdata?.ios_people}명"
                Log.d(TAG,"it- > $it")
            }


        }


    }

    override fun onClick(p0: View?) {
        when(p0){
            mbinding.detailBackBtn ->{
                finish()
            }
        }
    }
}