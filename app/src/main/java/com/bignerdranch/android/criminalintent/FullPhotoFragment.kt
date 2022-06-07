package com.bignerdranch.android.criminalintent

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import java.io.File

private const val ARG_IMAGE = "image"

class FullPhotoFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.photo_dialog, null)
            builder.setView(view)

            val crimePicture = view.findViewById(R.id.crime_photo) as ImageView
            val photoFile = arguments?.getSerializable(ARG_IMAGE) as File
            val bitmap = getScaledBitmap(photoFile.path, requireActivity())
            crimePicture.setImageBitmap(bitmap)

            builder.apply {
                setTitle(R.string.crime_photo)
                setNegativeButton("Dismiss") { _, _->
                    dialog?.cancel()
                }
            }
            builder.create()
        } ?: throw  IllegalStateException("Activity cannot be null")
    }

    companion object{
        fun newInstance(photoFile: File) : FullPhotoFragment {
            val args = Bundle().apply {
                putSerializable(ARG_IMAGE, photoFile)
            }

            return FullPhotoFragment().apply { arguments = args }
        }
    }
}