package com.example.bada1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_notice_write.view.*
import kotlinx.android.synthetic.main.notice_item.view.*

class NBAdapter() : RecyclerView.Adapter<DataViewHolder>() {
    private var datalist = ArrayList<NoticeModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder { //생성
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.notice_item,parent,false))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {  //하나하나 만들어주는거
        holder.bind(datalist[position])
    }

    override fun getItemCount(): Int = datalist.size

    fun addBitmap(bitmap: NoticeModel){
        this.datalist.add(bitmap)
    }
    fun remove(bitmap: NoticeModel){
        this.datalist.remove(bitmap)
    }
}
class DataViewHolder( itemView:View) : RecyclerView.ViewHolder(itemView){ //여기서 각각의 데이터 넣어주는 것
    val title = itemView.tv_proj
    val content = itemView.tv_details
    val sv_people = itemView.sv_people
    val an_people = itemView.an_people
    val ios_people = itemView.ios_people
    val des_people = itemView.des_people
    fun bind(k:NoticeModel){
        title.text = k.title
        content.text = k.contents
        sv_people.text = k.sv_people
        an_people.text = k.an_people
        ios_people.text = k.ios_people
        des_people.text = k.des_people
    }

}

