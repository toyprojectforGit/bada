package com.example.bada1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bada1.databinding.ActivityNoticeBoardBinding
import kotlinx.android.synthetic.main.activity_notice_board.*
import kotlinx.android.synthetic.main.activity_notice_write.*

class NoticeBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //글쓰기 버튼을 누르면 글쓰는 noticewrite로 넘어가도록 하기
        btn_noticewrite.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, NoticeWrite::class.java)
            startActivity(intent)
        })

        var viewBinding = ActivityNoticeBoardBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val datalist = ArrayList<NoticeModel>()
        val dataNB = NBAdapter()  //리사이클러뷰 사용시 필요, 어댑터 생성

        viewBinding.rvNotice.adapter = dataNB    //생성한 어댑터를 xml에 있는 리사이클러뷰의 어댑터에 적용
        viewBinding.rvNotice.layoutManager = LinearLayoutManager(this)   //리사이클러뷰에 있는

        var title = ""
        var contents = ""
        var sv_people = ""

        if (intent.hasExtra("title")){    //putextra가 있는지 확인, 갖고 있으면 true, 없으면 false
            title = intent.getStringExtra("title").toString()
            contents = intent.getStringExtra("contents").toString()
            dataNB.addBitmap(NoticeModel(title, contents, sv_people))
            dataNB.notifyDataSetChanged()
        }

    }
}