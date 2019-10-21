package com.cesarsicas.dogsjetpack.features.breeds.details


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.cesarsicas.dogsjetpack.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_breed_details.*
import kotlinx.android.synthetic.main.information_view.view.*

/**
 * A simple [Fragment] subclass.
 */
internal class BreedDetailsFragment : Fragment() {
    private val args: BreedDetailsFragmentArgs by navArgs()
    private lateinit var viewModel: BreedDetailsFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this)[BreedDetailsFragmentViewModel::class.java]

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breed_details, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBreed(args.breedId).observe(this, Observer {
            //Picasso.get().load(it.thumb).into(breedImage)
            breedName.text = it.name
            temperament.informationViewContent.text = it.name
            height.informationViewContent.text = it.height
            weight.informationViewContent.text = it.weight
            country.informationViewContent.text = if(it.originCountry.isNullOrEmpty()) "-" else  it.originCountry
        })

        viewModel.getImagesLiveData().observe(this, Observer { images ->
            //Picasso.get().load(it.thumb).into(breedImage)
            breedImages.adapter = BreedImagesAdapter(fragmentManager!!,  images)
        })

        viewModel.refreshImages(args.breedId)

    }


}
