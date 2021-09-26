package com.nikitakonshin.myteststore.view.adapters.listeners

import com.nikitakonshin.core.adapter.BaseItemListener

interface BestSellerItemListener: BaseItemListener {
    fun itemListener(id: String)
}