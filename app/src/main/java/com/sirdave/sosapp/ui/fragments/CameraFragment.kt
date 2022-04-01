package com.sirdave.sosapp.ui.fragments

import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.otaliastudios.cameraview.CameraListener
import com.otaliastudios.cameraview.CameraView
import com.otaliastudios.cameraview.PictureResult
import com.sirdave.sosapp.R
import com.sirdave.sosapp.network.Location
import com.sirdave.sosapp.network.Request
import com.sirdave.sosapp.ui.ContactViewModel
import java.util.stream.Collectors
import kotlin.streams.toList

class CameraFragment : Fragment() {
    private lateinit var cameraView: CameraView
    private val viewModel: ContactViewModel by activityViewModels()
    private var encodedImage: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_camera,
            container, false)

        cameraView = view.findViewById(R.id.cameraView)
        cameraView.setLifecycleOwner(viewLifecycleOwner)
        val button: ImageView = view.findViewById(R.id.captureImage)

        cameraView.addCameraListener(object : CameraListener(){
            override fun onPictureTaken(result: PictureResult) {
                val byteArrayImage = result.data
                encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT)
                Log.d("CameraFragment", "encodedImage is $encodedImage")

                //sendSOSRequest()
            }
        })

        button.setOnClickListener {
            cameraView.takePicture()
        }

        return view
    }

    private fun sendSOSRequest(){
        viewModel.contacts.observe(viewLifecycleOwner, { contacts ->
            val phoneNumbers = contacts.map { s -> s.phoneNumber!! }.toList()
            val location = getCurrentLocation()

            encodedImage?.let {
                val request = Request(phoneNumbers, it, location)
                viewModel.sendSOSRequest(request)
            }
        })
    }

    //TODO: Use Google API to get current location
    private fun getCurrentLocation(): Location{
        return Location("", "")
    }
}