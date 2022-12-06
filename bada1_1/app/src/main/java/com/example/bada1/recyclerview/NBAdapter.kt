package com.example.bada1

import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bada1.modelClass.NoticeModel
import com.example.bada1.util.UserPrivateData
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.notice_item.view.*
import kotlinx.android.synthetic.main.notice_item.view.tv_andr
import kotlinx.android.synthetic.main.notice_item.view.tv_gui
import kotlinx.android.synthetic.main.notice_item.view.tv_ios
import kotlinx.android.synthetic.main.notice_item.view.tv_proj
import kotlinx.android.synthetic.main.notice_item.view.tv_serv
import kotlinx.android.synthetic.main.notice_list_item.view.*

class NBAdapter() : RecyclerView.Adapter<DataViewHolder>() {
    private var datalist = ArrayList<NoticeModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder { //생성
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.notice_item,parent,false))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {  //하나하나 만들어주는거
        holder.bind(datalist[position])
    }

    override fun getItemCount(): Int = datalist.size

    fun addData(bitmap: NoticeModel){
        this.datalist.add(bitmap)
    }
    fun submitData(data: ArrayList<NoticeModel>){
        this.datalist=data
    }
    fun remove(bitmap: NoticeModel){
        this.datalist.remove(bitmap)
    }
}
class DataViewHolder( itemView:View) : RecyclerView.ViewHolder(itemView), View.OnClickListener { //여기서 각각의 데이터 넣어주는 것
    val title = itemView.tv_proj
    val content = itemView.tv_details
    val sv_people = itemView.tv_serv
    val an_people = itemView.tv_andr
    val ios_people = itemView.tv_ios
    val des_people = itemView.tv_gui
    val heartbtn =itemView.notice_recylcer_btn
    var noheart = false
    val noticedatabase= FirebaseDatabase.getInstance().getReference("teambada").child("notice")
    var heartUsers = ArrayList<String>()
    init {
        heartbtn.setOnClickListener(this)
    }
    fun bind(k: NoticeModel){
        k.heartUsers?.let {
            if (it.isNotEmpty()){
                heartUsers= it
                it.forEach {
                    if (UserPrivateData.USERID == it){noheart= true
                        heartbtn.progress=0.5f
//                        val animator= ValueAnimator.ofFloat(0f,0.5f).setDuration(300)
//                        animator.addUpdateListener {
//                            heartbtn.progress =it.getAnimatedValue() as Float
//                        }
//                        animator.start()
                            //heartbtn.setBackgroundResource(R.drawable.ic_baseline_heart_full)
                    }
                }
            }
        }


        title.text = k.title
        content.text = k.contents
        sv_people.text="${sv_people.text} ${k.sv_people} 명"
        an_people.text = "${an_people.text} ${k.an_people} 명"
        ios_people.text = "${ios_people.text} ${k.ios_people} 명"
        des_people.text = "${des_people.text} ${k.des_people} 명"

    }

    override fun onClick(p0: View?) {
        when(p0){
            heartbtn ->{
                //하트가 되어있으면 데이터베이스 배열에 사용자 이메일 추가
                if (noheart==false){// heartbtn.setBackgroundResource(R.drawable.ic_baseline_heart_full)
                    noheart=true
                    val db = noticedatabase.child("${title.text}")
                    heartUsers.add(UserPrivateData.USERID)
                    val update = hashMapOf<String,ArrayList<String>>()
                    update.put("heartUsers",heartUsers)

                    db.updateChildren(update as Map<String, Any>)


                    val animator= ValueAnimator.ofFloat(0f,0.5f).setDuration(500)
                        animator.addUpdateListener {
                            heartbtn.progress =it.getAnimatedValue() as Float
                        }
                        animator.start()

                }else{
                    //하트취소하면 데이터베이스 배열에 사용자 이메일 제거
                  //  heartbtn.setBackgroundResource(R.drawable.ic_baseline_heart_broken_24)
                    val db = noticedatabase.child("${title.text}")
                    val update = hashMapOf<String,ArrayList<String>?>()
                    heartUsers.remove(UserPrivateData.USERID)
                    update.put("heartUsers",heartUsers)
                    db.updateChildren(update as Map<String, Any>)
                    noheart=false
                    val animator= ValueAnimator.ofFloat(0.5f,1f).setDuration(500)
                    animator.addUpdateListener {
                        heartbtn.progress =it.getAnimatedValue() as Float
                    }
                    animator.start()
                }
            }
        }
    }

}

