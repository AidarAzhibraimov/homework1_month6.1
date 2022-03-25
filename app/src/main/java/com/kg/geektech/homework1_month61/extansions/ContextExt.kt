package com.kg.geektech.homework1_month61.extansions

import android.content.Context
import android.widget.Toast

fun Context.showToast(massage: String){
    Toast.makeText(this,massage,Toast.LENGTH_SHORT).show()
}
