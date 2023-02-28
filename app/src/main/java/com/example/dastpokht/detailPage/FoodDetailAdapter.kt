package com.example.dastpokht.detailPage

/*
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dastpokht.databinding.RecyclerViewDetailBinding
import network.TotalNutrients


class FoodDetailAdapter(var data: TotalNutrients) :
    ListAdapter<TotalNutrients, FoodDetailAdapter.FoodDetailViewHolder>(object :
        DiffUtil.ItemCallback<TotalNutrients>() {
        override fun areItemsTheSame(oldItem: TotalNutrients, newItem: TotalNutrients): Boolean {

            return oldItem.CA?.quantity == newItem.CA?.quantity
        }

        override fun areContentsTheSame(oldItem: TotalNutrients, newItem: TotalNutrients): Boolean {
            return oldItem.CA?.label == newItem.CA?.label
        }
    }) {


    inner class FoodDetailViewHolder(binding: RecyclerViewDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val nutrientsName = binding.nutrients
        val nutrientsMg = binding.nutrientsMg

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodDetailViewHolder {

        val binding =
            RecyclerViewDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodDetailViewHolder(binding)

    }

    override fun onBindViewHolder(holder: FoodDetailViewHolder, position: Int) {

        data = getItem(position)

        holder.nutrientsName.text = data.CHOLE?.label.toString()
        holder.nutrientsMg.text = data.CHOLE?.quantity?.toInt().toString()
    }
}*/
