package com.example.taskmanager.ui.Photo


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.taskmanager.data.local.Pref
import com.example.taskmanager.databinding.FragmentPhotoBinding


class PhotoFragment : Fragment() {

    private  lateinit var binding: FragmentPhotoBinding
    private lateinit var pref: Pref
   private  val GALLERY_REQUEST_CODE = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPhotoBinding.inflate(inflater, container, false)


        val preferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val imageUriString = preferences.getString("photo_image_uri",null)
        if (imageUriString != null){
            val imageUri = Uri.parse(imageUriString)

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgPhotoImage.setOnClickListener{
            openPhoto()
        }

        pref = Pref(requireContext())
        saveName()


    }

    private fun saveName() {
        binding.edEditText.setText(pref.getName())

        binding.edEditText.addTextChangedListener {
            pref.setName(binding.edEditText.text.toString())
        }
    }

    fun openPhoto() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == Activity.RESULT_OK ){
            val imageUri = data?.data

            val preferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
            preferences.edit().putString("photo_image_uri",imageUri.toString()).apply()

            binding.imgPhotoImage.setImageURI(imageUri)
        }
    }

}