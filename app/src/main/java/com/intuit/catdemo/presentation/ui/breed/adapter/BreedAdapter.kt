package com.intuit.catdemo.presentation.ui.breed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.intuit.catdemo.databinding.CustomCatBreedItemBinding
import com.intuit.catdemo.domain.model.CatBreed
import com.intuit.catdemo.presentation.ui.breed.listener.BreedItemClickListener

class BreedAdapter(
    var catBreeds: ArrayList<CatBreed>
)  : RecyclerView.Adapter<BreedAdapter.ViewHolder>()  {

    private lateinit var itemClickListener: BreedItemClickListener

    fun setListener(itemClickListener: BreedItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CustomCatBreedItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(catBreeds[position])
        holder.binding.root.setOnClickListener {
            itemClickListener.onItemClick(holder.adapterPosition)
        }
    }

    fun updateList(catBreeds : List<CatBreed>){
        val start = this.catBreeds.size
        this.catBreeds.addAll(catBreeds)
        notifyItemRangeChanged(start, start+10)
    }

    override fun getItemCount() = catBreeds.size;

    inner class ViewHolder(val binding: CustomCatBreedItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(catBreed: CatBreed){
            binding.catBreed = catBreed
        }
    }
}