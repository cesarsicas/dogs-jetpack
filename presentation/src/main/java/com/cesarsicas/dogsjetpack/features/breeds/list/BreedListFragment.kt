package com.cesarsicas.dogsjetpack.features.breeds.list


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_breed_list.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cesarsicas.dogsjetpack.R
import com.cesarsicas.dogsjetpack.features.breeds.details.BreedDetailsFragmentViewModel
import com.cesarsicas.dogsjetpack.features.breeds.model.Breed
import org.koin.android.viewmodel.ext.android.viewModel


internal class BreedListFragment : Fragment() {
    private val viewModel by viewModel<BreedListFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_breed_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        breedsList.layoutManager = layoutManager

        val adapter = BreedListAdapter(arrayListOf()){ breed:Breed ->
            onBreedClicked(breed) }

        breedsList.adapter = adapter

        viewModel.getBreedsLiveData().observe(this, Observer {
            adapter.addItens( it as ArrayList<Breed>)
        })

    }


    private fun onBreedClicked(breed:Breed){
        val action = BreedListFragmentDirections.actionBreedListFragmentToBreedDetailsFragment(breed.id)
        findNavController().navigate(action)
    }

}
