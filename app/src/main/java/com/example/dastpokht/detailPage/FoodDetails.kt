package com.example.dastpokht.detailPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.dastpokht.FoodViewModel
import com.example.dastpokht.databinding.FragmentFoodDetailsBinding
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
        if (item != null) {
            implementFoodDetail(item)
        }

    }

    private fun implementFoodDetail(item: Hit) {

        Glide.with(this)
            .load(item.recipe?.image)
            .into(binding.foodImageDetail)

        binding.foodNameDetail.text = item.recipe?.label
        binding.cuisineType.text = item.recipe?.cuisineType.toString()
        binding.total.text = item.recipe?.totalNutrients?.ENERC_KCAL?.quantity?.toInt().toString()
        binding.proteinG.text =
            item.recipe?.totalNutrients?.PROCNT?.quantity?.toInt().toString()
        binding.fatG.text = item.recipe?.totalNutrients?.FAT?.quantity?.toInt().toString()
        binding.carbG.text = item.recipe?.totalNutrients?.CHOCDF?.quantity?.toInt().toString()

        binding.fiber.text = item.recipe?.totalNutrients?.FIBTG?.label
        binding.fiberMg.text = item.recipe?.totalNutrients?.FIBTG?.quantity?.toInt().toString()
        binding.sugars.text = item.recipe?.totalNutrients?.SUGAR?.label
        binding.sugarsMg.text = item.recipe?.totalNutrients?.SUGAR?.quantity?.toInt().toString()
        binding.cholesterol.text = item.recipe?.totalNutrients?.CHOLE?.label
        binding.cholesterolMg.text =
            item.recipe?.totalNutrients?.CHOLE?.quantity?.toInt().toString()
        binding.sodium.text = item.recipe?.totalNutrients?.NA?.label
        binding.sodiumMg.text = item.recipe?.totalNutrients?.NA?.quantity?.toInt().toString()
        binding.calcium.text = item.recipe?.totalNutrients?.CA?.label
        binding.calciumMg.text = item.recipe?.totalNutrients?.CA?.quantity?.toInt().toString()
        binding.magnesium.text = item.recipe?.totalNutrients?.MG?.label
        binding.magnesiumMg.text = item.recipe?.totalNutrients?.MG?.quantity?.toInt().toString()
        binding.potassium.text = item.recipe?.totalNutrients?.K?.label
        binding.potassiumMg.text = item.recipe?.totalNutrients?.K?.quantity?.toInt().toString()
        binding.iron.text = item.recipe?.totalNutrients?.FE?.label
        binding.ironMg.text = item.recipe?.totalNutrients?.FE?.quantity?.toInt().toString()
        binding.zinc.text = item.recipe?.totalNutrients?.ZN?.label
        binding.zincMg.text = item.recipe?.totalNutrients?.ZN?.quantity?.toInt().toString()
        binding.vitaminA.text = item.recipe?.totalNutrients?.VITA_RAE?.label
        binding.vitaminAMg.text =
            item.recipe?.totalNutrients?.VITA_RAE?.quantity?.toInt().toString()
        binding.vitaminC.text = item.recipe?.totalNutrients?.VITC?.label
        binding.vitaminCMg.text = item.recipe?.totalNutrients?.VITC?.quantity?.toInt().toString()
        binding.vitaminB12.text = item.recipe?.totalNutrients?.VITB12?.label
        binding.vitaminB12Mg.text =
            item.recipe?.totalNutrients?.VITB12?.quantity?.toInt().toString()
        binding.vitaminD.text = item.recipe?.totalNutrients?.VITD?.label
        binding.vitaminDMg.text = item.recipe?.totalNutrients?.VITD?.quantity?.toInt().toString()
        binding.vitaminK.text = item.recipe?.totalNutrients?.VITK1?.label
        binding.vitaminKMg.text = item.recipe?.totalNutrients?.VITK1?.quantity?.toInt().toString()
        binding.vitaminE.text = item.recipe?.totalNutrients?.TOCPHA?.label
        binding.vitaminEMg.text = item.recipe?.totalNutrients?.TOCPHA?.quantity?.toInt().toString()
        binding.vitaminBSix.text = item.recipe?.totalNutrients?.VITB6A?.label
        binding.vitaminBSixMg.text = item.recipe?.totalNutrients?.VITB6A?.quantity?.toInt().toString()
        binding.folicAcid.text = item.recipe?.totalNutrients?.FOLAC?.label
        binding.folicAcidMg.text = item.recipe?.totalNutrients?.FOLAC?.quantity?.toInt().toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}