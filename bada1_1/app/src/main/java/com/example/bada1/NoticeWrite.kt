package com.example.bada1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bada1.databinding.ActivityNoticeWriteBinding

//저장하기 버튼을 누르면 프로젝트명, 내용을 noticeboardactiviy로 보내주고 activity_notice_board 화면으로 전환되게끔 해줌
class NoticeWrite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewBinding = ActivityNoticeWriteBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnSave.setOnClickListener{
            var intent = Intent(this, NoticeBoardActivity::class.java).apply{
                putExtra("title", viewBinding.ntTitle.text.toString())
                putExtra("contents", viewBinding.ntContents.text.toString())
                putExtra("sv_people", viewBinding.svPeople.text.toString())
                putExtra("an_people", viewBinding.anPeople.text.toString())
                putExtra("ios_people", viewBinding.iosPeople.text.toString())
                putExtra("des_people", viewBinding.desPeople.text.toString())
            }
            startActivity(intent)
            if (!isFinishing) finish()
        }
    }
}