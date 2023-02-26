package com.example.dastpokht.mainPage

import android.content.Context
import android.os.Build import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dastpokht.databinding.RecyclerViewFoodListBinding
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.withContext
import network.Hit

class FoodListAdapter(private val onItemClick: (Hit) -> Unit) : ListAdapter<Hit, FoodListAdapter.FoodListViewHolder>(HitDiffCalBack()) {



   inner class FoodListViewHolder(binding: RecyclerViewFoodListBinding) : RecyclerView.ViewHolder(binding.root) {


        val foodImage = binding.foodListImage
        val foodName = binding.foodListName
        val foodHealthLabel = binding.foodListHealthLabel
       val cardView = binding.root


    }

    private class HitDiffCalBack : DiffUtil.ItemCallback<Hit>() {
        override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {

            return oldItem.recipe?.uri == newItem.recipe?.uri
        }

        override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {

            return oldItem.recipe?.uri == newItem.recipe?.uri
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder {

        val binding =
            RecyclerViewFoodListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodListViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {

        val item = getItem(position)

        holder.foodName.text = item.recipe?.label.toString()

        holder.foodHealthLabel.text = item.recipe?.healthLabels.toString()

        Glide.with(holder.foodImage)
            .load(item.recipe?.image)
            .into(holder.foodImage)
        holder.cardView.setOnClickListener{

            onItemClick(item)
        }


    }
}


