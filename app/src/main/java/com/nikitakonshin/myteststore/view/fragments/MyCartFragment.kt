package com.nikitakonshin.myteststore.view.fragments

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nikitakonshin.core.view.BaseFragment
import com.nikitakonshin.model.entities.cart.Cart
import com.nikitakonshin.myteststore.R
import com.nikitakonshin.myteststore.databinding.FragmentMyCartBinding
import com.nikitakonshin.myteststore.view_model.MyCartViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MyCartFragment :
    BaseFragment<FragmentMyCartBinding, List<Cart>, MyCartViewModel>(R.layout.fragment_my_cart) {
    override val viewBinding: FragmentMyCartBinding by viewBinding()
    override val viewModel: MyCartViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData()
    }

    override fun renderSuccess(data: List<Cart>) {}

}