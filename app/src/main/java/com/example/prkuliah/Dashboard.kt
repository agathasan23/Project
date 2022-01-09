package com.example.prkuliah

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prkuliah.databinding.ActivityDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class Dashboard : Fragment(R.layout.activity_dashboard) {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var dbref : DatabaseReference
    private lateinit var eventRecyclerView: RecyclerView
    private lateinit var eventArrayList: ArrayList<EventData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ActivityDashboardBinding.bind(view)


        binding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(context,Login::class.java))
            activity?.finish()
        }
        binding.imgAddEvent.setOnClickListener(View.OnClickListener {
            val intent = Intent(context,AddEvent::class.java)
            startActivity(intent)
        })

        binding.cView1.setOnClickListener(View.OnClickListener {
            val intent = Intent(context,Category::class.java)
            intent.putExtra("categoryId",1)
            startActivity(intent)
        })

        binding.cView2.setOnClickListener(View.OnClickListener {
            val intent = Intent(context,Category::class.java)
            intent.putExtra("categoryId",2)
            startActivity(intent)
        })

        binding.cView3.setOnClickListener(View.OnClickListener {
            val intent = Intent(context,Category::class.java)
            intent.putExtra("categoryId",3)
            startActivity(intent)
        })

        binding.cView4.setOnClickListener(View.OnClickListener {
            val intent = Intent(context,Category::class.java)
            intent.putExtra("categoryId",4)
            startActivity(intent)
        })

        binding.cView5.setOnClickListener(View.OnClickListener {
            val intent = Intent(context,Category::class.java)
            intent.putExtra("categoryId",5)
            startActivity(intent)
        })

        binding.cView6.setOnClickListener(View.OnClickListener {
            val intent = Intent(context,Category::class.java)
            intent.putExtra("categoryId",6)
            startActivity(intent)
        })

        //recyclerview
        binding.rvListEvent.layoutManager = LinearLayoutManager(activity)
        binding.rvListEvent.setHasFixedSize(true)

        eventArrayList = arrayListOf<EventData>()
        getEventData()
    }

    private fun getEventData() {
        dbref = FirebaseDatabase.getInstance().getReference("Event")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (eventSnaphot in snapshot.children){
                        val event = eventSnaphot.getValue((EventData::class.java))
                        eventArrayList.add(event!!)
                    }
                    binding.rvListEvent.adapter = AdapterEvent(eventArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
            }

        })
    }


}


