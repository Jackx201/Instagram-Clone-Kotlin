package com.example.instagram.model

import android.provider.ContactsContract.DisplayPhoto
import androidx.annotation.DrawableRes

data class Friends(
    var friendName: String,
    var nickName: String,
    var age: Int,
    @DrawableRes var photo: Int
)