package com.intuit.catdemo.common

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.widget.NestedScrollView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior

object BindingUtils {

    @JvmStatic
    @BindingAdapter("imageUrl", "placeHolder", requireAll = true)
    fun ImageView.loadImage(url: String?, error: Drawable) {
        if(url==null ){
            setImageDrawable(error)
        }
        Glide.with(this.context).load(url).error(error).apply(
            RequestOptions.diskCacheStrategyOf(
            DiskCacheStrategy.AUTOMATIC)).into(this);
    }

}