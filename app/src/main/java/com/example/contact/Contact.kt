package com.example.contact

import java.io.Serializable

data class Contact (
    val id : Int,
    val avatar: String,
    val name: String,
    val phoneNumber: String,
    val email: String,
    val address: String,
) : Serializable