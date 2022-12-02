package com.example.bada1.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bada1.NBAdapter
import com.example.bada1.databinding.ActivityNoticeBoardBinding
import com.example.bada1.modelClass.NoticeModel
import com.example.bada1.util.util.TAG
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_notice_board.*

class NoticeBoardActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var mbinding:ActivityNoticeBoardBinding
    private lateinit var mDatabaseRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding = ActivityNoticeBoardBinding.inflate(layoutInflater)
        setContentView(mbinding.root)
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("teambada")

        //글쓰기 버튼을 누르면 글쓰는 noticewrite로 넘어가도록 하기
        mbinding.btnNoticewrite.setOnClickListener(this)

        val datalist = ArrayList<NoticeModel>()
        val dataNB = NBAdapter()  //리사이클러뷰 사용시 필요, 어댑터 생성
        val databaseReference=FirebaseDatabase.getInstance().getReference("teambada").child("notice")
        databaseReference.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for (snapshot in snapshot.getChildren()) {
                    val tmpdata = snapshot.getValue(NoticeModel::class.java) //만들어뒀던 user객체에 데이터를 담는다.
                    Log.d(TAG,"tmpdata - > ${tmpdata}")
                    tmpdata?.let { datalist.add(it)  }
                }
                dataNB.submitData(datalist)
                dataNB.notifyDataSetChanged()
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
           //생성한 어댑터를 xml에 있는 리사이클러뷰의 어댑터에 적용
        mbinding.rvNotice.adapter = dataNB
        mbinding.rvNotice.layoutManager = LinearLayoutManager(this)   //리사이클러뷰에 있는


//        if (intent.hasExtra("bundle")){    //putextra가 있는지 확인, 갖고 있으면 true, 없으면 false
//            var bundle = intent.getBundleExtra("bundle")
//            val writedata = bundle?.getSerializable("resultNoticeModel") as NoticeModel
//            dataNB.addData(writedata)
//            dataNB.notifyDataSetChanged()
//        }

    }



    override fun onClick(p0: View?) {
        when(p0){
            btn_noticewrite ->{
                val intent = Intent(this, NoticeWrite::class.java)
                finish()
                startActivity(intent)
            }
        }
    }
}