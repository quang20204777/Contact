package com.example.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ContactDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameContact = arguments?.getString("name")
        val phoneNumberContact = arguments?.getString("phoneNumber")
        val emailContact = arguments?.getString("email")
        val addressContact = arguments?.getString("address")
        val avatarContact = arguments?.getString("avatar")


        val nameTextView: TextView = view.findViewById(R.id.name)
        val phoneNumberTextView: TextView = view.findViewById(R.id.phonenumber)
        val emailTextView: TextView = view.findViewById(R.id.email)
        val addressTextView: TextView = view.findViewById(R.id.address)
        val avatarTextView: TextView = view.findViewById(R.id.avatar)

        nameTextView.text = nameContact
        phoneNumberTextView.text= phoneNumberContact
        emailTextView.text = emailContact
        addressTextView.text = addressContact
        avatarTextView.text = avatarContact


    }

}