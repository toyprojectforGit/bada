package com.example.bada1.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bada1.ProjectActivty
import com.example.bada1.RecruitActivity
import com.example.bada1.databinding.FragmentRoleSelectBinding
import com.example.bada1.modelClass.NoticeModel
import com.example.bada1.modelClass.UserAccount
import com.example.bada1.util.UserPrivateData.USERTOKEN
import com.example.bada1.util.util.TAG
import com.google.firebase.database.FirebaseDatabase


class RoleSelectFragment : Fragment(),View.OnClickListener {
    private lateinit var mbinding:FragmentRoleSelectBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mbinding = FragmentRoleSelectBinding.inflate(inflater,container,false)
        val databaseReference= FirebaseDatabase.getInstance().getReference("teambada")
            .child("userAccount").child("${USERTOKEN}").get().addOnSuccessListener {
                Log.d(TAG,"it -> $it")
                val tmpdata = it.getValue(UserAccount::class.java) //만들어뒀던 user객체에 데이터를 담는다.
                mbinding.userTopic.text=tmpdata?.topic
                mbinding.userLocation.text=tmpdata?.location
            }



        return mbinding.root
    }

    override fun onClick(p0: View?) {
        when(p0){

        }
    }

}