package com.nikitakonshin.myteststore.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nikitakonshin.model.entities.local.cart.Basket
import com.nikitakonshin.myteststore.databinding.ItemRvMyCartBinding
import com.nikitakonshin.myteststore.view.adapters.dif_util.BasketDifUtil
import com.nikitakonshin.repositories.image_loader.ImageLoader
import com.nikitakonshin.utills.parseIntToPriceForItemMyCart

class CartAdapter(private val imageLoader: ImageLoader) :
    ListAdapter<Basket, CartAdapter.CartViewHolder>(BasketDifUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRvMyCartBinding.inflate(layoutInflater, parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class CartViewHolder(private val binding: ItemRvMyCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Basket) {
            with(binding) {
                item.images?.let { imageLoader.loadImage(it, ivPhonePhotoMyCart) }
                tvPhoneNameMyCart.text = item.title
                tvPhonePriceMyCart.text = parseIntToPriceForItemMyCart(item.price ?: 0)

                ivBasketMayCart.setOnClickListener {
                    deleteItem()
                }
            }
        }

        private fun deleteItem() {
            val newList: MutableList<Basket> = mutableListOf()
            newList.addAll(currentList)
            newList.removeAt(layoutPosition)
            submitList(newList.toList())
        }
    }
}