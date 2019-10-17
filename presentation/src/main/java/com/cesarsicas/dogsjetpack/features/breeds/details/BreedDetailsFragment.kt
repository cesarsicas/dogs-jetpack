package com.cesarsicas.dogsjetpack.features.breeds.details


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.cesarsicas.dogsjetpack.R
import kotlinx.android.synthetic.main.fragment_breed_details.*

/**
 * A simple [Fragment] subclass.
 */
class BreedDetailsFragment : Fragment() {
    val args: BreedDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breed_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        someTextToReplace.text = "Capim Cidreira: ${args.breedId}"
    }


}
