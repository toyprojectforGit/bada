package com.example.bada1.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.bada1.modelClass.chat
import kotlinx.android.synthetic.main.item_chat.view.*

class chatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val useremail =itemView.chat_id
    val content = itemView.chat_text
    val time = itemView.chat_day
    fun bind(data:chat){
        time.text=data.day
        content.text=data.content
        useremail .text=data.user
    }

}