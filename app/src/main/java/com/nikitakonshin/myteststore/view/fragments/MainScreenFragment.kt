package com.nikitakonshin.myteststore.view.fragments

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.nikitakonshin.core.view.BaseFragment
import com.nikitakonshin.model.entities.local.main.Main
import com.nikitakonshin.myteststore.R
import com.nikitakonshin.myteststore.databinding.FragmentMainScreenBinding
import com.nikitakonshin.myteststore.view_model.MainScreenViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainScreenFragment :
    BaseFragment<
            FragmentMainScreenBinding,
            List<Main>,
            MainScreenViewModel
            >(R.layout.fragment_main_screen) {

    override val viewBinding: FragmentMainScreenBinding by viewBinding()
    override val viewModel: MainScreenViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.tvHeader.setOnClickListener {
            viewModel.getData()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJob()
    }

    override fun renderSuccess(data: List<Main>) {}
}