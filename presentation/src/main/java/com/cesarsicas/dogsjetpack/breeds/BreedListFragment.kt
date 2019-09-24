package com.cesarsicas.dogsjetpack.breeds


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cesarsicas.dogsjetpack.R
import kotlinx.android.synthetic.main.fragment_breed_list.*


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

        val layoutManager = LinearLayoutManager(context)
        breedsList.layoutManager = layoutManager

        val breeds= viewModel.getBreedsLiveData()

        breeds.observe(this, Observer {
            val adapter = BreedListAdapter(context, it)
            breedsList.adapter = adapter
        })

        viewModel.refreshBreeds()
    }


}
