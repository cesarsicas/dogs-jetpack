package com.cesarsicas.dogsjetpack.features.breeds.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.cesarsicas.dogsjetpack.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_breed_image.*

internal class BreedImageFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val inflatedView = inflater.inflate(R.layout.fragment_breed_image, container, false)

        val image = arguments!!.getString(IMAGE_ARGUMENT)

        val imageView = inflatedView.findViewById<ImageView>(R.id.breedImage)

        if(image.isNullOrEmpty().not()){
            Picasso.get().load(image).into(imageView)
        }
        else{
            breedImage.setImageResource(R.drawable.ic_pets_black)
        }

        return inflatedView
    }


    companion object {
        private const val IMAGE_ARGUMENT = "image_argument"

        fun newInstance(imageUrl:String?): BreedImageFragment {
            val bundle = Bundle()
            bundle.putString(IMAGE_ARGUMENT, imageUrl)
            val fragment = BreedImageFragment()
            fragment.arguments = bundle
            return fragment

        }
    }


}
