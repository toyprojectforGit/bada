package com.example.bada1.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bada1.databinding.ActivityNoticeWriteBinding
import com.example.bada1.modelClass.NoticeModel
import com.example.bada1.util.UserPrivateData.USERID
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

//저장하기 버튼을 누르면 프로젝트명, 내용을 noticeboardactiviy로 보내주고 activity_notice_board 화면으로 전환되게끔 해줌
class NoticeWrite : AppCompatActivity() {
    private lateinit var mDatabaseRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewBinding = ActivityNoticeWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("teambada")
        viewBinding.btnSave.setOnClickListener{
            var intent = Intent(this, NoticeBoardActivity::class.java)
            val title=viewBinding.ntTitle.text.toString()
            val contents = viewBinding.ntContents.text.toString()
            val sv_people = viewBinding.svPeople.text.toString().toInt()
            val an_people=viewBinding.anPeople.text.toString().toInt()
            val ios_people = viewBinding.iosPeople.text.toString().toInt()
            val desPeople=viewBinding.desPeople.text.toString().toInt()
            val resultNoticeModel = NoticeModel(title,contents,sv_people,an_people,ios_people,desPeople,USERID,ArrayList<String>())
            val bundle = Bundle()
            bundle.putSerializable("resultNoticeModel",resultNoticeModel)
            intent.putExtra("bundle",bundle)
            writeDB(resultNoticeModel)
            startActivity(intent)
            if (!isFinishing) finish()
        }
    }
    //파이어베이스 데이터베이스에 게시판 내용 저장
    fun writeDB(resultNoticeModel: NoticeModel){
        // setValue는 database에 insert하는 행위
        mDatabaseRef.child("notice").child(resultNoticeModel.title).setValue(resultNoticeModel)

    }
}