package com.martins.milton.catlovers.ui.cats

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.martins.milton.catlovers.data.models.Cat
import com.martins.milton.catlovers.util.ImageUtil

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Cat>) {
    (listView.adapter as CatsAdapter).submitList(items)
}

@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, url: String?) {
    Glide.with(view.context).load(url)
        .thumbnail()
        .override(500)
        .centerCrop()
        .placeholder(ImageUtil.getProgressDrawable(view.context))
        .into(view)
}