package com.example.mycontact

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//class ContactAdapter(private var contactlist: contactData): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
//
//    var onItemClick : ((Contact) -> Unit)? = null
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list, parent, false)
//
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = contactlist[position]
//        holder.firstNameText.text = item.fName + " " + item.lname
//        holder.MobileNumberText.text = item.phone
//        holder.itemView.setOnClickListener {
//            contactlist.get(position).lname
//            val intent = Intent(holder.itemView.context,View_Contact_Detail::class.java)
//            intent.putExtra("firstName",contactlist.get(position).fName)
//            intent.putExtra("lastName",contactlist.get(position).lname)
//            intent.putExtra("phoneNumber",contactlist.get(position).phone)
//            holder.itemView.context.startActivity(intent)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return contactlist.size
//    }
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        val firstNameText:TextView = itemView.findViewById(R.id.textView)
//        val MobileNumberText:TextView = itemView.findViewById(R.id.textView2)
//    }
//
//}



internal class ContactAdapter(
    val context: Context,
    private var contactList: List<Contact>
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    var onClickedListner : ((Contact) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_list,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Contact = contactList[position]
        holder.frstName.text = Contact.fName +" "+Contact.lname
        holder.mobNumber.text = Contact.phone

        holder.itemView.setOnClickListener {
           onClickedListner?.invoke(Contact)
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
       var frstName: TextView = view.findViewById(R.id.NameTextView)
       var mobNumber: TextView = view.findViewById(R.id.MobileNumberTextView)
    }
}




