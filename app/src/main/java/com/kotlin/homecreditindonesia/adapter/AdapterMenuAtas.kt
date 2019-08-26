package com.kotlin.homecreditindonesia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlin.homecreditindonesia.R
import com.kotlin.homecreditindonesia.entity.ItemsItemProduct
import kotlinx.android.synthetic.main.item_menu_atas.view.*

class AdapterMenuAtas(
    private val list: List<ItemsItemProduct?>,
    private var context: Context,
    private val listener: (ItemsItemProduct) -> Unit
) : RecyclerView.Adapter<AdapterMenuAtas.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_menu_atas,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindItem(list[position]!!, listener)
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(itemsItemProduct: ItemsItemProduct, listener: (ItemsItemProduct) -> Unit) {
            itemView.setOnClickListener { listener(itemsItemProduct) }
            itemView.txt_item_menu_atas.text = "${itemsItemProduct.productName}"
            Glide.with(context).load(itemsItemProduct.productImage)
                .into(itemView.img_item_menu_atas)
        }
    }
}