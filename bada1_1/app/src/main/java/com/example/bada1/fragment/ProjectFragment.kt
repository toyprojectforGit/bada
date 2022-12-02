package com.example.bada1.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bada1.activity.MapActivity
import com.example.bada1.databinding.FragmentProjectBinding


class ProjectFragment : Fragment(),View.OnClickListener {

    private lateinit var mbinding: FragmentProjectBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mbinding= FragmentProjectBinding.inflate(inflater, container, false)

        clicklistener()



        return mbinding.root
    }

    override fun onClick(p0: View?) {
        when(p0){
            mbinding.projectComplteBtn ->{
                nextActivity(1)
            }
            mbinding.projectAppBtn ->nextActivity(2)
            mbinding.projectIappBtn ->nextActivity(3)
            mbinding.projectWebBtn ->nextActivity(4)
            mbinding.projectServerBtn ->nextActivity(5)
            mbinding.projectDesignBtn ->nextActivity(6)

        }
    }
    private fun nextActivity(clickitem:Int){
        val intent = Intent(requireContext(), MapActivity::class.java)
        when(clickitem){
            1 ->intent.putExtra("key", "projectComplteBtn")
            2 ->intent.putExtra("key", "projectAppBtn")
            3 -> intent.putExtra("key", "projectIappBtn")
            4 -> intent.putExtra("key", "projectWebBtn")
            5 -> intent.putExtra("key", "projectServerBtn")
            6 -> intent.putExtra("key", "projectDesignBtn")
         }
        startActivity(intent)

    }
    private fun clicklistener(){
        mbinding.projectComplteBtn.setOnClickListener(this)
        mbinding.projectAppBtn.setOnClickListener(this);
        mbinding.projectIappBtn.setOnClickListener(this);
        mbinding.projectWebBtn.setOnClickListener(this);
        mbinding.projectServerBtn.setOnClickListener(this);
        mbinding.projectDesignBtn.setOnClickListener(this);


    }


}