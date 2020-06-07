package com.martins.milton.catlovers.util

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

class ImageUtil {
   companion object {
       fun getProgressDrawable(context: Context?): CircularProgressDrawable? {
           val circularProgressDrawable = CircularProgressDrawable(context!!)
           circularProgressDrawable.strokeWidth = 15f
           circularProgressDrawable.centerRadius = 50f
           circularProgressDrawable.start()
           return circularProgressDrawable
       }
   }
}