package com.example.golfstream.ui.dashboard

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.golfstream.R
import com.example.golfstream.ui.dashboard.DashboardFragment.Companion.REQUEST_PICK_VIDEO
import com.example.golfstream.ui.notifications.NotificationsFragment

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
    }
    val text: LiveData<String> = _text
    private val _selectedVideoUri = MutableLiveData<Uri>()
    val selectedVideoUri: LiveData<Uri> = _selectedVideoUri

    fun setSelectedVideoUri(uri: Uri) {
        _selectedVideoUri.value = uri
    }

}