package com.example.bada1.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bada1.ProjectActivty
import com.example.bada1.RecruitActivity
import com.example.bada1.databinding.FragmentRoleSelectBinding


class RoleSelectFragment : Fragment(),View.OnClickListener {
    private lateinit var mbinding:FragmentRoleSelectBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mbinding = FragmentRoleSelectBinding.inflate(inflater,container,false)
        mbinding.btnCap.setOnClickListener(this)
        mbinding.btnSail.setOnClickListener(this)
        return mbinding.root
    }

    override fun onClick(p0: View?) {
        when(p0){
            mbinding.btnCap ->{
                val intent = Intent(requireContext(), RecruitActivity::class.java)
                startActivity(intent)
            }
            mbinding.btnSail -> {
                val intent = Intent(requireContext(), ProjectActivty::class.java)
                startActivity(intent)
            }
        }
    }

}