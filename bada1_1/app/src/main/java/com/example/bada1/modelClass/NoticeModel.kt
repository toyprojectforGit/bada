package com.example.bada1.modelClass

import java.io.Serializable

data class NoticeModel(var title: String="", var contents: String="",
                  var sv_people: Int=0
                       , var an_people: Int=0,
                  var ios_people: Int=0, var des_people: Int=0,var useremail:String?="",var heartUsers:ArrayList<String>?=null) :Serializable{
}
