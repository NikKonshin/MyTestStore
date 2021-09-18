package com.nikitakonshin.myteststore.view.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nikitakonshin.core.adapter.BaseAdapter
import com.nikitakonshin.core.adapter.BaseItemListener
import com.nikitakonshin.core.adapter.HorizontalItemDecoration
import com.nikitakonshin.core.view.BaseFragment
import com.nikitakonshin.model.entities.local.main.BestSeller
import com.nikitakonshin.model.entities.local.main.HomeStore
import com.nikitakonshin.model.entities.local.main.Main
import com.nikitakonshin.myteststore.R
import com.nikitakonshin.myteststore.databinding.FragmentMainScreenBinding
import com.nikitakonshin.myteststore.view.CategoriesRVAdapter
import com.nikitakonshin.myteststore.view.binds.bindBestSeller
import com.nikitakonshin.myteststore.view.binds.bindHotSales
import com.nikitakonshin.myteststore.view_model.MainScreenViewModel
import com.nikitakonshin.repositories.image_loader.ImageLoader
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainScreenFragment :
    BaseFragment<
            FragmentMainScreenBinding,
            Main,
            MainScreenViewModel
            >(R.layout.fragment_main_screen), ItemStateListener {

    override val viewBinding: FragmentMainScreenBinding by viewBinding()
    override val viewModel: MainScreenViewModel by viewModel()

    private var adapterHotSales: BaseAdapter<HomeStore, BaseItemListener>? = null
    private var adapterBestSeller: BaseAdapter<BestSeller, BaseItemListener>? = null
    private val imageLoader: ImageLoader by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun renderSuccess(data: Main) {
        data.homeStore?.let { adapterHotSales?.setData(it) }
        data.bestSeller?.let { adapterBestSeller?.setData(it) }
        showProducts()
    }

    override fun getActiveItem(categoryId: Int) {
        when (categoryId) {
            0 -> {
                viewModel.getData()
            }
            else -> {
                with(viewBinding) {
                    adapterHotSales?.setData(listOf())
                    adapterBestSeller?.setData(listOf())
                    hideProducts()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJob()
    }

    private fun init() {
        initRVCategory()
        initRVBestSeller()
        initRVHotSales()
    }

    private fun initRVHotSales() {
        adapterHotSales = BaseAdapter<HomeStore, BaseItemListener>(
            R.layout.item_hot_sales,
            listener
        ) { view, data, listener ->
            bindHotSales(view, data, listener, imageLoader)
        }

        with(viewBinding.rvHotSales) {
            adapterHotSales?.let {
                adapter = it
            }
            addItemDecoration(HorizontalItemDecoration(30, 25))
        }
    }

    private fun initRVBestSeller() {
        viewBinding.rvBestSeller.layoutManager = GridLayoutManager(this.context, 2)
        adapterBestSeller = BaseAdapter<BestSeller, BaseItemListener>(
            R.layout.item_best_seller,
            listener
        ) { view, data, listener ->
            bindBestSeller(view, data, listener, imageLoader)
        }
        adapterBestSeller?.let {
            viewBinding.rvBestSeller.adapter = it
        }
    }

    private fun initRVCategory() {
        with(viewBinding.rvCategory) {
            adapter = CategoriesRVAdapter(this@MainScreenFragment)
            addItemDecoration(HorizontalItemDecoration(23, 27))
        }
    }

    private fun hideProducts() {
        with(viewBinding) {
            listsProducts.visibility = View.INVISIBLE
            tvEmpty.visibility = View.VISIBLE
        }
    }

    private fun showProducts() {
        with(viewBinding) {
            listsProducts.visibility = View.VISIBLE
            tvEmpty.visibility = View.GONE
            loadingIndicator.visibility = View.GONE
        }
    }

    override fun showLoading() {
        with(viewBinding) {
            tvEmpty.visibility = View.GONE
            listsProducts.visibility = View.INVISIBLE
            loadingIndicator.visibility = View.VISIBLE
        }
    }

    private val listener = object : BaseItemListener {}
}