package com.example.dastpokht.detailPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dastpokht.databinding.RecyclerViewDetailBinding
import network.Hit
import network.TotalNutrients

class FoodDetailAdapter: ListAdapter<Hit,FoodDetailAdapter.FoodDetailViewHolder>( object : DiffUtil.ItemCallback<Hit>(){
    override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {

        return oldItem.recipe?.uri == newItem.recipe?.uri
    }

    override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {
        return oldItem.recipe?.uri == newItem.recipe?.uri
    }
}){


     class FoodDetailViewHolder(binding: RecyclerViewDetailBinding) : RecyclerView.ViewHolder (binding.root){

          val nutrientsName = binding.nutrients
          val nutrientsMg = binding.nutrientsMg

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodDetailViewHolder {

        val binding = RecyclerViewDetailBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return FoodDetailViewHolder(binding)

    }

    override fun onBindViewHolder(holder: FoodDetailViewHolder, position: Int) {

        val item = getItem(position)

        val data = listOf<TotalNutrients>()
        data.forEach{
            holder.nutrientsName.text = item.recipe?.totalNutrients?.CA?.label
        }
    }
}