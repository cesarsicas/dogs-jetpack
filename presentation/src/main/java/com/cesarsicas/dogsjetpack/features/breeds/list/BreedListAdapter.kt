package com.cesarsicas.dogsjetpack.features.breeds.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cesarsicas.dogsjetpack.R
import com.cesarsicas.dogsjetpack.features.breeds.model.Breed
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.breed_item.view.*


internal class BreedListAdapter(private val breedList:List<Breed>) : RecyclerView.Adapter<GenericViewHolder>() {

    val viewTypeLoading = 0
    val viewTypeBreed = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {

        var root: View?

        return if (viewType == viewTypeLoading) {
            root = LayoutInflater.from(parent.context).inflate(R.layout.loading_item, parent, false)
            ProgressViewHolder(root)
        } else {
            root = LayoutInflater.from(parent.context).inflate(R.layout.breed_item, parent, false)
            BreedViewHolder(root)
        }
    }

    override fun getItemCount(): Int {
        return breedList.size
    }


    override fun getItemViewType(position: Int): Int {
        return if (breedList[position] != null)
            viewTypeBreed
        else
            viewTypeLoading
    }


    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        if(holder is BreedViewHolder){
            val breed = breedList[position]
            holder.breedName?.text = breed.name
            Picasso.get().load(breed.thumb).into(holder.breedImage)
        }
    }

    internal class BreedViewHolder(itemView: View): GenericViewHolder(itemView) {
        val breedName:TextView? = itemView?.name
        val breedImage:ImageView? = itemView?.imageView
    }

    internal inner class ProgressViewHolder(itemView: View) : GenericViewHolder(itemView)
}