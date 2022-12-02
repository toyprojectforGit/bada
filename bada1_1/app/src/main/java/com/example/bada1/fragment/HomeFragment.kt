package com.example.bada1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bada1.recyclerview.CustomAdapter
import com.example.bada1.modelClass.User
import com.example.bada1.databinding.FragmentHomeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.ArrayList


class HomeFragment : Fragment() {
    private lateinit var mbinding:FragmentHomeBinding
    private lateinit var arrayList: ArrayList<User>
    private lateinit var myadapter : CustomAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mbinding = FragmentHomeBinding.inflate(inflater,container,false)
        val databaseReference = FirebaseDatabase.getInstance().getReference("teambada").child("userAccount")
        arrayList =  ArrayList<User>()
        databaseReference.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                arrayList.clear()
                snapshot.children.forEach {
                    val tmp = it.getValue(User::class.java)
                    tmp?.let {arrayList.add(it)  }
                    myadapter = CustomAdapter(
                        arrayList,
                        requireContext()
                    )
                    mbinding.recyclerView.adapter=myadapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

        mbinding.recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)


        return mbinding?.root
    }
}