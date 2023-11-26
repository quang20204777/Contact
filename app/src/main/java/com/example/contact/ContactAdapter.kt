package com.example.contact

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.compose.foundation.layout.Box

import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController

class ContactAdapter (private val contactListFragment: ContactListFragment, private val contacts: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){
    inner class ContactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val avatar: TextView
        val name: TextView

        init {
            avatar = itemView.findViewById(R.id.avatar)
            name = itemView.findViewById(R.id.name)
        }
    }

    //Create new view (invoked by the layout manager
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)

        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
    // Replace the contents of a view (involed by the layout manager)
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.name.text = contact.name

        val firstLetter = contact.name.first().uppercaseChar().toString()
        holder.avatar.text = firstLetter

        val popupMenu = PopupMenu(holder.itemView.context, holder.itemView)
        popupMenu.menuInflater.inflate(R.menu.context_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_call -> {
                    // Gọi điện
                    true
                }
                R.id.action_send_message -> {
                    // Gửi tin nhắn SMS
                    true
                }
                R.id.action_send_email -> {
                    // Gửi Email
                    true
                }
                else -> false
            }
        }

        holder.itemView.setOnLongClickListener {
            popupMenu.show()
            true
        }

        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", contact.name)
            bundle.putString("phoneNumber", contact.phoneNumber)
            bundle.putString("email", contact.email)
            bundle.putString("address", contact.address)
            bundle.putString("avatar", firstLetter)

            contactListFragment.findNavController().navigate(R.id.action_contactListFragment_to_contactDetailFragment, bundle)
        }
    }

}




