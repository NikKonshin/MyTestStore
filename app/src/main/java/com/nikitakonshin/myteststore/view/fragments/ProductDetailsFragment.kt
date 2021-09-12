package com.nikitakonshin.myteststore.view.fragments

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nikitakonshin.core.view.BaseFragment
import com.nikitakonshin.model.entities.responce.productdetails.ResponseProductDetails
import com.nikitakonshin.myteststore.R
import com.nikitakonshin.myteststore.databinding.FragmentProductDetailsBinding
import com.nikitakonshin.myteststore.view_model.ProductDetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ProductDetailsFragment :
    BaseFragment<FragmentProductDetailsBinding, List<ResponseProductDetails>, ProductDetailsViewModel>(
        R.layout.fragment_product_details
    ) {

    override val viewBinding: FragmentProductDetailsBinding by viewBinding()
    override val viewModel: ProductDetailsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData()
    }

    override fun renderSuccess(data: List<ResponseProductDetails>) {}
}