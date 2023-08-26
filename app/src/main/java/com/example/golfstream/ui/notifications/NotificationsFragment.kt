package com.example.golfstream.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.golfstream.databinding.FragmentNotificationsBinding
import com.example.golfstream.ui.dashboard.DashboardViewModel

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    private lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        videoView = binding.videoView
        val textView: TextView = binding.textNotifications

        // Observe the selectedVideoUri LiveData from DashboardViewModel
        val dashboardViewModel = ViewModelProvider(requireActivity()).get(DashboardViewModel::class.java)
        dashboardViewModel.selectedVideoUri.observe(viewLifecycleOwner) { uri ->
            videoView.setVideoURI(uri)
            videoView.start()
        }

        textView.text = "Notifications Fragment"
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}