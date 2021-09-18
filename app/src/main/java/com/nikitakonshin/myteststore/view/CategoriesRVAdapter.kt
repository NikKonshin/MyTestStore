package com.nikitakonshin.myteststore.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nikitakonshin.model.entities.categories.Category
import com.nikitakonshin.myteststore.R
import com.nikitakonshin.myteststore.databinding.ItemCategoriesMainScreenBinding
import com.nikitakonshin.myteststore.view.fragments.ItemStateListener

class CategoriesRVAdapter(private val itemStateListener: ItemStateListener) :
    RecyclerView.Adapter<CategoriesRVAdapter.ViewHolder>() {

    private val categories = listOf(
        Category(
            PHONES_ID,
            R.drawable.category_phones_image,
            "Phones",
            true
        ),
        Category(
            COMPUTER_ID,
            R.drawable.category_computer_image,
            "Computer"
        ),
        Category(
            HEALTH_ID,
            R.drawable.category_health_image,
            "Health"
        ),
        Category(
            BOOKS_ID,
            R.drawable.category_books_image,
            "Books"
        ),
        Category(
            PHONES_ID,
            R.drawable.category_phones_image,
            "Phones"
        ),
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesRVAdapter.ViewHolder {
        val binding = ItemCategoriesMainScreenBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size

    inner class ViewHolder(private val binding: ItemCategoriesMainScreenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val context = itemView.context
        private val resources = context.resources
        private val theme = context.theme
        fun bind(category: Category) {
            initView(category)
            chekStateView(category)
            setStateSelected(category)
            onClickItem(category)
        }

        private fun onClickItem(category: Category) {
            itemView.setOnClickListener {
                if (category.isSelected) {
                    return@setOnClickListener
                } else {
                    category.isSelected = true
                    notifyDataSetChanged()
                }
            }
        }

        private fun setStateSelected(category: Category) {
            if (category.isSelected) {
                category.isSelected = !category.isSelected
            }
        }

        private fun chekStateView(category: Category) {
            with(binding) {
                if (category.isSelected) {
                    ivCircleCategories.setColorFilter(
                        resources.getColor(
                            R.color.orange, theme
                        )
                    )
                    descriptionItemCategory.setTextColor(
                        resources.getColor(R.color.orange, theme)
                    )

                    setImageIcon(category.id)
                    itemStateListener.getActiveItem(category.id)
                } else {
                    ivCircleCategories.setColorFilter(
                        resources.getColor(
                            R.color.white, theme
                        )
                    )
                    descriptionItemCategory.setTextColor(
                        resources.getColor(R.color.blue, theme)
                    )
                }
            }
        }

        private fun initView(category: Category) {
            with(binding) {
                ivIconCategories.setImageResource(category.imageRes)
                descriptionItemCategory.text = category.description
            }
        }

        private fun setImageIcon(id: Int) {
            when (id) {
                PHONES_ID -> {
                    binding.ivIconCategories.setImageResource(R.drawable.category_phones_image_selected)
                }
                COMPUTER_ID -> {
                    binding.ivIconCategories.setImageResource(R.drawable.category_computer_image_selected)
                }
                HEALTH_ID -> {
                    binding.ivIconCategories.setImageResource(R.drawable.category_health_image_selected)
                }
                BOOKS_ID -> {
                    binding.ivIconCategories.setImageResource(R.drawable.category_books_image_selected)
                }
            }
        }
    }

    companion object {
        private const val PHONES_ID = 0
        private const val COMPUTER_ID = 1
        private const val HEALTH_ID = 2
        private const val BOOKS_ID = 3
    }
}