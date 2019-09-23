package com.cesarsicas.dogsjetpack.breeds


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.cesarsicas.dogsjetpack.R
import com.cesarsicas.dogsjetpack.breeds.model.Breed
import kotlinx.android.synthetic.main.fragment_breed_list.*


internal class BreedListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breed_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        breedsList.layoutManager = layoutManager

        val adapter = BreedListAdapter(context, getBreeds())
        breedsList.adapter = adapter

    }

    private fun getBreeds(): List<Breed> {
       return  listOf(
           Breed("Affenpinscher", "", "", "", "", "https://cdn2.thedogapi.com/images/hd1iiHXjK.jpg" ),
           Breed("Afghan Hound", "", "", "", "", "https://cdn2.thedogapi.com/images/hd1iiHXjK.jpg" ),
           Breed("Affenpinscher", "", "", "", "", "https://cdn2.thedogapi.com/images/rkiByec47_150x150.jpg" ),
           Breed("Afghan Hound", "", "", "", "", "https://cdn2.thedogapi.com/images/rkiByec47_150x150.jpg" ),
           Breed("Affenpinscher", "", "", "", "", "https://cdn2.thedogapi.com/images/GYC8Oeux6.jpg" ),
           Breed("Afghan Hound", "", "", "", "", "https://cdn2.thedogapi.com/images/S1_8kx5Nm_150x150.jpg" ))
    }


}
