package com.cesarsicas.dogsjetpack.features.breeds.details


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cesarsicas.dogsjetpack.R

/**
 * A simple [Fragment] subclass.
 */
class BreedDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breed_details, container, false)
    }


}
