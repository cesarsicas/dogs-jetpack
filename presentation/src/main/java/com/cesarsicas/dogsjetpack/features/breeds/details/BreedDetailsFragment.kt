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
import com.cesarsicas.dogsjetpack.features.breeds.list.BreedListFragmentViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_breed_details.*
import kotlinx.android.synthetic.main.information_view.view.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
internal class BreedDetailsFragment : Fragment() {
    private val viewModel by viewModel<BreedDetailsFragmentViewModel>()

    private val args: BreedDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breed_details, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoading()

        viewModel.getBreed(args.breedId).observe(this, Observer {
            breedName.text = it.name
            temperament.informationViewContent.text = it.name
            height.informationViewContent.text = it.height
            weight.informationViewContent.text = it.weight
            country.informationViewContent.text = if(it.originCountry.isEmpty()) "-" else  it.originCountry
        })

        viewModel.images?.observe(this, Observer { images ->
            breedImages.adapter = BreedImagesAdapter(fragmentManager!!,  images)
            hideLoading()
        })

        viewModel.refreshImages(args.breedId)

    }

    private fun showLoading(){
        loading.visibility = View.VISIBLE
    }

    private fun hideLoading(){
        loading.visibility = View.GONE
    }

}
