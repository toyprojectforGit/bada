package com.example.bada1.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bada1.databinding.ActivityNoticeDetailBinding
import com.example.bada1.modelClass.NoticeModel
import com.example.bada1.modelClass.chat
import com.example.bada1.recyclerview.chatAdapter
import com.example.bada1.util.UserPrivateData
import com.example.bada1.util.parseTimeToHome
import com.example.bada1.util.util.TAG
import com.google.firebase.database.*

class NoticeDetailActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var mbinding:ActivityNoticeDetailBinding
    private lateinit var mDatabaseRef: DatabaseReference
    private var chatcount = 0
    private lateinit var title :String
    private lateinit var recyclerviewAdapter:chatAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding=ActivityNoticeDetailBinding.inflate(layoutInflater)
        setContentView(mbinding.root)
        mbinding.detailBackBtn.setOnClickListener(this)
        mbinding.detailNewBtn.setOnClickListener(this)
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("teambada").child("chat")
        if (intent.hasExtra("title")){
            val title = intent.getStringExtra("title")
            title?.let {getChat(title)
            this.title = it}

            val databaseReference= FirebaseDatabase.getInstance().getReference("teambada").child("notice").child("$title")
            databaseReference.get().addOnSuccessListener {
                val tmpdata = it.getValue(NoticeModel::class.java) //만들어뒀던 user객체에 데이터를 담는다.
                mbinding.detailContent.text = tmpdata?.contents
                mbinding.detailTitle.text = tmpdata?.title
                mbinding.detailEmail.text = tmpdata?.useremail
                tmpdata?.heartUsers?.let {
                        if (it.isEmpty()){mbinding.detailLikeText.text="0"}
                    else mbinding.detailLikeText.text="${tmpdata?.heartUsers?.count()}"
                    }
                //mbinding.detailLikeText.text="${tmpdata?.heartUsers?.count()}"
                mbinding.detailServer.text="서버 ${tmpdata?.sv_people}명"
                mbinding.detailAos.text="AOS ${tmpdata?.an_people}명"
                mbinding.detailDesign.text = "디자인 ${tmpdata?.des_people}명"
                mbinding.detailIos.text= "ios ${tmpdata?.ios_people}명"
                Log.d(TAG,"it- > $it")
            }


        }
        recyclerviewAdapter = chatAdapter()
        mbinding.detailRecylcerview.adapter = recyclerviewAdapter
        mbinding.detailRecylcerview.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }
    private fun getChat(title:String){
        val titlechat = mDatabaseRef.child(title)
        titlechat.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    Log.d(TAG,"있음")
                    Log.d(TAG,"snapshot : $snapshot")

                    chatcount = snapshot.childrenCount.toInt()
                    var chatlist=ArrayList<chat>()
                    for (snapshot in snapshot.getChildren()) {
                        val tmpdata = snapshot.getValue(chat::class.java) //만들어뒀던 user객체에 데이터를 담는다.
                        tmpdata?.let { chatlist.add(it) }
                    }
                    chatcount = chatlist.count()
                    mbinding.detailLiveText.text = "${chatcount}"
                    recyclerviewAdapter.getChatData(chatlist)
                    recyclerviewAdapter.notifyDataSetChanged()
                    Log.d(TAG,"chatlist - > $chatlist")
                }else{
                    Log.d(TAG,"없음")
                }


            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
    override fun onClick(p0: View?) {
        when(p0){
            mbinding.detailBackBtn ->{
                finish()
            }
            mbinding.detailNewBtn ->{
                if (mbinding.detailNewChat.text.toString().trim()!=""){
                    val content = mbinding.detailNewChat.text.toString().trim()
                    val user = UserPrivateData.USERID
                    val time = parseTimeToHome()
                    val result  = chat(user,time,content)
                    mDatabaseRef.child(title).child(chatcount.toString()).setValue(result)
                    chatcount+=1
                    this.recyclerviewAdapter.addchatData(result)
                    recyclerviewAdapter.notifyDataSetChanged()
                    mbinding.detailNewChat.setText("")
                }
            }
        }
    }
}