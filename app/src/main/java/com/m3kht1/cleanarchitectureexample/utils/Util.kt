package com.m3kht1.cleanarchitectureexample.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.m3kht1.cleanarchitectureexample.R

fun getProgressDrawable(context: Context):CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImg(uri:String?,progressDrawable: CircularProgressDrawable){
    val options : RequestOptions = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)
    Glide.with(this.context)
        .applyDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}