package com.example.bada1.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bada1.R
import com.example.bada1.modelClass.chat

class chatAdapter :RecyclerView.Adapter<chatViewHolder>(){
    private var chatdata = ArrayList<chat>()
    fun getChatData(data: ArrayList<chat>){
        chatdata=data
    }
    fun addchatData(data:chat){
        chatdata.add(data)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): chatViewHolder {
        val d = chatViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chat,parent,false))
        return d
    }

    override fun onBindViewHolder(holder: chatViewHolder, position: Int) {
        holder.bind(chatdata[position])
    }

    override fun getItemCount(): Int {
        return  chatdata.size
    }
}