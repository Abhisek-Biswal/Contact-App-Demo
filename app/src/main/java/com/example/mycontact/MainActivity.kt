package com.example.mycontact

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {



    private lateinit var fab: FloatingActionButton
    private lateinit var recyleView: RecyclerView
    private lateinit var contactList:ArrayList<Contact>
    private lateinit var adapter: ContactAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contactList = ArrayList()

        fab=findViewById(R.id.floatingActionButton)
        recyleView=findViewById(R.id.recyclerView)


        adapter = ContactAdapter(this, contactList)


        var newlaunch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result ->

            if(result.resultCode == Activity.RESULT_OK){
                val data : Intent? = result.data
                contactList.add(Contact(data?.getStringExtra("firstName").toString()
                    ,data?.getStringExtra("lastName").toString()
                    ,data?.getStringExtra("phoneNumber").toString()))
                adapter.notifyDataSetChanged()
            }
        }

        recyleView.layoutManager= LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        adapter = ContactAdapter(this, contactList)
        recyleView.adapter = adapter
        recyleView.layoutManager=LinearLayoutManager(this)

        adapter.onClickedListner = {
            val intent = Intent(this,View_Contact_Detail::class.java)
            intent.putExtra("newList",it)
            startActivity(intent)
            Toast.makeText(this, "Showing Details", Toast.LENGTH_LONG).show()
        }

        fab.setOnClickListener{
            val intent = Intent(this,SaveContactActivity::class.java)
            newlaunch.launch(intent)
        }
    }
}








