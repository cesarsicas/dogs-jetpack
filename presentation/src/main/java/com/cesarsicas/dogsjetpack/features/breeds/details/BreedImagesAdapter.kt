package com.cesarsicas.dogsjetpack.features.breeds.details

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.cesarsicas.dogsjetpack.features.breeds.model.BreedImage


internal class BreedImagesAdapter(fragmentManager: FragmentManager, private val images: List<BreedImage>) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    // 2
    override fun getItem(position: Int): Fragment {
        return BreedImageFragment.newInstance(images[position].url)
    }

    // 3
    override fun getCount(): Int {
        return images.size
    }

}