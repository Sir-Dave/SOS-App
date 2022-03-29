package com.sirdave.sosapp.ui

import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.otaliastudios.cameraview.CameraListener
import com.otaliastudios.cameraview.CameraView
import com.otaliastudios.cameraview.PictureResult
import com.sirdave.sosapp.R

class CameraFragment : Fragment() {
    private lateinit var cameraView: CameraView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_camera,
            container, false)

        cameraView = view.findViewById(R.id.cameraView)
        cameraView.setLifecycleOwner(viewLifecycleOwner)

        cameraView.addCameraListener(object : CameraListener(){
            override fun onPictureTaken(result: PictureResult) {
                // Access the raw data if needed.
                val byteArrayImage = result.data
                val encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT)

            }
        })


        return view
    }

}