package com.example.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ContactAddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactAddFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameEditText: EditText = view.findViewById(R.id.name_edittext)
        val phoneNumberEditText: EditText = view.findViewById(R.id.phonenumber_edittext)
        val emailEditText: EditText = view.findViewById(R.id.email_edittext)
        val addressEditText: EditText = view.findViewById(R.id.address_edittext)




        val submitBtn: Button = view.findViewById(R.id.submit_btn)
        submitBtn.setOnClickListener {
            val name = nameEditText.text.toString()
            val phoneNumber = phoneNumberEditText.text.toString()
            val email = emailEditText.text.toString()
            val address = addressEditText.text.toString()
            val bundle = Bundle()
            bundle.putString("new_name", name)
        bundle.putString("new_phoneNumber", phoneNumber)
        bundle.putString("new_email", email)
        bundle.putString("new_address", address)
            findNavController().navigate(R.id.action_contactAddFragment_to_contactListFragment, bundle)
        }

    }
}