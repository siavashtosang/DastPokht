package recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dastpokht.databinding.RecyclerViewCardBinding
import network.Hit

class FoodListAdapter : ListAdapter<Hit, FoodListAdapter.FoodViewHolder>(HitDiffCalBack()) {

    class FoodViewHolder(binding: RecyclerViewCardBinding) : RecyclerView.ViewHolder(binding.root) {

        val foodName = binding.foodListName
    }


    private class HitDiffCalBack : DiffUtil.ItemCallback<Hit>() {
        override fun areItemsTheSame(oldItem: Hit, newItem: Hit): Boolean {

            return oldItem.recipe?.uri == newItem.recipe?.uri
        }

        override fun areContentsTheSame(oldItem: Hit, newItem: Hit): Boolean {

            return oldItem.recipe?.uri == newItem.recipe?.uri
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {

        val binding =
            RecyclerViewCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {

        val item  = getItem(position)
        holder.foodName.text = item.recipe?.label


    }
}


