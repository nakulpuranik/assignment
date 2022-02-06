package com.example.assignment.constants

import android.graphics.Color
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import android.text.style.RelativeSizeSpan

import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import com.example.assignment.R
import java.util.*


fun splitGenre(input:String?):Array<String>? {
    return input?.split(",")?.toTypedArray()
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    Glide.with(view.context).load(url).into(view)
}

@BindingAdapter("genreOne")
fun genreOne(view: Chip, value:String?){
    var genre = splitGenre(value)
    view.text = genre?.get(0) ?: ""
}

@BindingAdapter("genreTwo")
fun genreTwo(view: Chip, value:String?){
    var genre = splitGenre(value)
    view.text = genre?.get(1) ?: ""
}

@BindingAdapter("imdbRating")
fun imdbRating(view: TextView, value: String?){
    var spanabledRating = SpannableString("$value/10")
    spanabledRating.setSpan(RelativeSizeSpan(1.5f), 0, 3, 0) // set size
    spanabledRating.setSpan(ForegroundColorSpan(Color.WHITE), 0, 5, 0)
    view.text = spanabledRating
}

@BindingAdapter("parentRating")
fun parentRating(view: TextView, value: String?){
    value?.let {
        var ratingText = when(it.lowercase(Locale.getDefault())){
            "r"-> {
                view.context.getString(R.string.content_rating_r_text)
            }
            else -> ""
        }

        var spannableText = SpannableString(ratingText)
        spannableText.setSpan(ForegroundColorSpan(Color.WHITE), 0, 14, 0)
        view.text = spannableText
    }
}

@BindingAdapter("directorList")
fun directorList(view: TextView, value: String?){
    value?.let {
        var updatedString = "Directors \n$value"
        var spannableText = SpannableString(updatedString)
        spannableText.setSpan(ForegroundColorSpan(Color.WHITE), 0, 9, 0)
        view.text = spannableText
    }
}

@BindingAdapter("writersList")
fun writersList(view: TextView, value: String?){
    value?.let {
        var updatedString = "Writers \n$value"
        var spannableText = SpannableString(updatedString)
        spannableText.setSpan(ForegroundColorSpan(Color.WHITE), 0, 7, 0)
        view.text = spannableText
    }
}