package com.example.dastpokht.mainPage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
    ): View? {

        _binding = FragmentShowFoodListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[FoodViewModel::class.java]


        binding.searchButton.setOnClickListener{

            val food = binding.searchFood.editText?.text.toString()

            Log.i("testLog","food -->$food")

            viewModel.getFoodApi(foodSearch = food)
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

        viewModel.hits.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

