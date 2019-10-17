package com.cesarsicas.dogsjetpack.features.breeds.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_breed_list.*
import androidx.recyclerview.widget.GridLayoutManager
import com.cesarsicas.dogsjetpack.R


internal class BreedListFragment : Fragment() {
    lateinit var viewModel: BreedListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breed_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this)[BreedListFragmentViewModel::class.java]

        val layoutManager = GridLayoutManager(activity, 2)
        breedsList.layoutManager = layoutManager

        viewModel.getBreedsLiveData().observe(this, Observer {
            val adapter = BreedListAdapter(it)
            breedsList.adapter = adapter
        })

    }


}
