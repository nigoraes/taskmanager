package com.example.taskmanager.ui.OnBoarding.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager.databinding.ItemOnboardingBinding
import com.example.taskmanager.model.OnBoard
import com.example.taskmanager.utils.loadImage


class OnBoardingAdapter(private val onStartClick:()->Unit): Adapter<OnBoardingAdapter.OnBoardingViewHolder> (){

    val data = arrayListOf<OnBoard>(
        OnBoard("Test 1", "Description","https://miro.medium.com/max/1400/1*8ygFKYb0Yo6Hc-vnScGA9A.png"),
        OnBoard("Test 1", "Description","https://img.freepik.com/premium-vector/content-manager-work-hand-drawn-worker-busy-with-marketing-analysis-illustraton_183665-84.jpg?w=2000"),
        OnBoard("Test 1", "Description","https://d57439wlqx3vo.cloudfront.net/iblock/09d/09d5f5dd6afa66f271dc31b2bfa7e69c/b07a492ab78550e31df066577f2a204c.jpg")
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount() = data.size

    inner class OnBoardingViewHolder(private val binding:ItemOnboardingBinding) : ViewHolder(binding.root){
        fun bind(onBoard: OnBoard) {


            binding.btnStart.setOnClickListener {
                onStartClick()
            }
            binding.btnSkip.setOnClickListener {
                onStartClick()
            }
            binding.btnStart.isVisible = adapterPosition == 2
            binding.btnSkip.isVisible = adapterPosition != 2

            binding.title.text=onBoard.title
            binding.description.text=onBoard.desc
            binding.imgBoard.loadImage(onBoard.image.toString())
        }

    }

}