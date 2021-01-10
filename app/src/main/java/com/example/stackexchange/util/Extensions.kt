package com.example.stackexchange.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>

fun View.setVisibility(visible: Boolean) { visibility = if (visible) View.VISIBLE else View.GONE }

fun ViewGroup.inflate(@LayoutRes layout: Int, attached: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layout, this, attached)
}