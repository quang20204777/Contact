package com.example.contact

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class ContactListFragment : Fragment(), MenuProvider {
    val contacts = mutableListOf<Contact>()
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_contact_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contacts.add(Contact(1,"avatar1", "Aario", "091092019","Aario@gmail.com", "Ha Nam"))
        contacts.add(Contact(2,"avatar2", "Bario", "091092019","Bario@gmail.com", "Ninh Binh"))
        contacts.add(Contact(3,"avatar3", "Cario", "091092019","Cario@gmail.com", "Thai Nguyen"))
        contacts.add(Contact(4,"avatar4", "Dario", "091092019","Dario@gmail.com", "Hai Phong"))
        contacts.add(Contact(5,"avatar5", "Eario", "091092019","Eario@gmail.com", "Ha Noi"))
        contacts.add(Contact(6,"avatar6", "Fario", "091092019","Fario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(7,"avatar7", "Gario", "091092019","Gario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(8,"avatar8", "Hario", "091092019","Hario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(9,"avatar9", "Iario", "091092019","Iario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(10,"avatar10","Jario", "091092019","Jario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(11,"avatar26", "Kario", "091092019","Kario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(12,"avatar11", "Lario", "091092019","Lario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(13,"avatar12", "Mario", "091092019","Mario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(14,"avatar13", "Nario", "091092019","Nario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(15,"avatar14", "Oario", "091092019","Oario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(16,"avatar15", "Pario", "091092019","Pario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(17,"avatar16", "Qario", "091092019","Qario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(18,"avatar17", "Rario", "091092019","Rario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(19,"avatar18", "Sario", "091092019","Sario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(20,"avatar19", "Tario", "091092019","Tario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(21,"avatar20","Uario", "091092019","Uario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(22,"avatar21","Vario", "091092019","Vario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(23,"avatar22","Wario", "091092019","Wario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(24,"avatar23","Xario", "091092019","Xario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(25,"avatar24","Yario", "091092019","Yario@gmail.com", "Nam Dinh"))
        contacts.add(Contact(26,"avatar25","Zario", "091092019","Zario@gmail.com", "Nam Dinh"))

        val newName = arguments?.getString("new_name")
        val newPhoneNumber = arguments?.getString("new_phoneNumber")
        val newEmail = arguments?.getString("new_email")
        val newAddress = arguments?.getString("new_address")
        if (newName != null && newPhoneNumber != null && newEmail != null && newAddress != null) {
            contacts.add(Contact(contacts.size +1 , "avatar", newName, newPhoneNumber, newEmail, newAddress))

        }

        val recyclerView: RecyclerView = view.findViewById(R.id.list_contact_rv)
        val contactAdapter = ContactAdapter(this, contacts)
        recyclerView.adapter = contactAdapter
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
            )
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }


    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
       // TODO("Not yet implemented")
        menuInflater.inflate(R.menu.action_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
      //  TODO("Not yet implemented")
        when(menuItem.itemId) {
            R.id.action_add -> {
                findNavController().navigate(R.id.action_contactListFragment_to_contactAddFragment)
            }
        else -> {
            //todo...
        }
        }
        return false
    }
}


