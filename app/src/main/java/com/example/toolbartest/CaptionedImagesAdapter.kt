package com.example.toolbartest

import android.graphics.drawable.Drawable
import android.net.sip.SipSession
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class CaptionedImagesAdapter(val captions: Array<String>, val imageIds: Array<Int>) : RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>() {

    interface Listener{
        fun onClick(position: Int)
    }

    private lateinit var listener: Listener

    fun setListener(listener: Listener){
        this.listener = listener
    }

    inner class ViewHolder: RecyclerView.ViewHolder{

        val cardView: CardView

        constructor(v: CardView): super(v){
            cardView = v
        }

    }

    override fun getItemCount(): Int {
        return captions.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.card_captioned_image, parent, false) as CardView
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView: CardView = holder.cardView
        val imageView = cardView.findViewById<ImageView>(R.id.info_image)
        val drawable: Drawable? = ContextCompat.getDrawable(cardView.context, imageIds[position])
        imageView.setImageDrawable(drawable)
        imageView.setContentDescription(captions[position])
        val textView = cardView.findViewById<TextView>(R.id.info_text)
        textView.setText(captions[position])
        cardView.setOnClickListener(View.OnClickListener {
            if (listener != null){
                listener.onClick(position)
            }
        })
    }

}