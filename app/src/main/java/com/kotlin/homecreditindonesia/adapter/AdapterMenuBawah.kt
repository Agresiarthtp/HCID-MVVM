package com.kotlin.homecreditindonesia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kotlin.homecreditindonesia.R
import com.kotlin.homecreditindonesia.entity.ItemsItemArticle
import kotlinx.android.synthetic.main.item_menu_bawah.view.*

class AdapterMenuBawah(
    private val list: List<ItemsItemArticle?>,
    private var context: Context,
    private val listener: (ItemsItemArticle) -> Unit
) : RecyclerView.Adapter<AdapterMenuBawah.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_menu_bawah,
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

        fun bindItem(itemsItemArticle: ItemsItemArticle, listener: (ItemsItemArticle) -> Unit) {
            itemView.txt_item_menu_bawah.text = "${itemsItemArticle.articleTitle}"
            itemView.setOnClickListener { listener(itemsItemArticle) }
            Glide.with(context).load(itemsItemArticle.articleImage)
                .into(itemView.img_item_menu_bawah)
        }
    }
}