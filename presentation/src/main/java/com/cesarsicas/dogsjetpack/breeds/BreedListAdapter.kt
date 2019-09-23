package com.cesarsicas.dogsjetpack.breeds

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cesarsicas.dogsjetpack.R
import com.cesarsicas.dogsjetpack.breeds.model.Breed
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.breed_item.view.*

internal class BreedListAdapter(private val context: Context?, private val breedList:List<Breed>) : RecyclerView.Adapter<BreedListAdapter.BreedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.breed_item, parent, false)

        return BreedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return breedList.size
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val breed = breedList[position]
        holder.breedName.text = breed.name

        Picasso.get().load(breed.thumb).into(holder.breedImage)

    }

    class BreedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val breedName:TextView = itemView.name
        val breedImage:ImageView = itemView.imageView
    }
}