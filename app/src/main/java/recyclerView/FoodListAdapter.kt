package recyclerView

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dastpokht.databinding.RecyclerViewCardBinding
import network.Hit

class FoodListAdapter : ListAdapter<Hit, FoodListAdapter.FoodViewHolder>(HitDiffCalBack()) {


    class FoodViewHolder(binding: RecyclerViewCardBinding) : RecyclerView.ViewHolder(binding.root) {

        val foodImage = binding.foodListImage
        val foodName = binding.foodListName
        val foodHealthLabel = binding.foodListHealthLabel
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {

        val item = getItem(position)

        holder.foodName.text = item.recipe?.label.toString()

        holder.foodHealthLabel.text = item.recipe?.healthLabels.toString()

        Glide.with(holder.foodImage)
            .load(item.recipe?.image)
            .into(holder.foodImage)
    }
}


