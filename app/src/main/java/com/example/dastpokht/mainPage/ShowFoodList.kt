package com.example.dastpokht.mainPage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.dastpokht.FoodViewModel
import com.example.dastpokht.R
import com.example.dastpokht.databinding.FragmentShowFoodListBinding

class ShowFoodList : Fragment() {

    private var _binding: FragmentShowFoodListBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentShowFoodListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]


        binding.searchButton.setOnClickListener {

            val food = binding.searchFood.editText?.text.toString()

            binding.loading.visibility = View.VISIBLE
            binding.errorTextView.visibility = View.GONE

            Log.i("testLog", "food -->$food")

            viewModel.getFoodApi(foodSearch = food)

        }

        viewModel.loading.observe(viewLifecycleOwner) {
            if (it == true) {
                binding.loading.visibility = View.GONE
            } else {

                binding.loading.visibility = View.GONE
                binding.errorTextView.visibility = View.VISIBLE
            }
        }


        val adapter = FoodListAdapter { hitsClicked ->

            Toast.makeText(
                requireContext(),
                "${hitsClicked.recipe?.label} clicked",
                Toast.LENGTH_SHORT
            ).show()
            Navigation.findNavController(view).navigate(R.id.action_showFoodList_to_foodDetails)
            viewModel.clickedUri(uri = hitsClicked.recipe?.uri)
        }
        binding.foodListRecycler.adapter = adapter

        viewModel.hits.observe(viewLifecycleOwner) {
            it?.let {
                adapter.submitList(it)
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

