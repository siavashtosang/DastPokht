package com.example.dastpokht.detailPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.dastpokht.FoodViewModel
import com.example.dastpokht.R
import com.example.dastpokht.databinding.FragmentFoodDetailsBinding
import com.example.dastpokht.databinding.FragmentShowFoodListBinding
import network.Hit


class FoodDetails : Fragment() {


    private var _binding: FragmentFoodDetailsBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFoodDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]
        val item = viewModel.findFood
        implementFoodDetail(item)

    }

    private fun implementFoodDetail(item:Hit?){

        Glide.with(this)
            .load(item?.recipe?.image)
            .into(binding.foodImageDetail)

        binding.foodNameDetail.text = item?.recipe?.label
        binding.cuisineType.text = item?.recipe?.cuisineType.toString()
        binding.total.text = item?.recipe?.totalNutrients?.ENERC_KCAL?.quantity?.toInt().toString()
        binding.proteinG.text = item?.recipe?.totalNutrients?.PROCNT?.quantity?.toInt().toString()
        binding.fatG.text = item?.recipe?.totalNutrients?.FAT?.quantity?.toInt().toString()
        binding.carbG.text = item?.recipe?.totalNutrients?.CHOCDF?.quantity?.toInt().toString()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}