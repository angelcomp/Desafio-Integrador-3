package com.example.desafiointegrador3.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiointegrador3.R
import com.example.desafiointegrador3.utils.Comic
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hq.view.*

class MainAdapter(val listaHQ: Comic, val listener: onComicClickListener):
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    inner class MainViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        val numeroHQ: TextView = view.tv_numero
        val imgHQ: ImageView = view.iv_imgHQ

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition

            if (RecyclerView.NO_POSITION != position) {
                listener.comicClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hq, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val valor = listaHQ.data.results[position]
        holder.numeroHQ.text = valor.title
        Picasso.get().load(valor.thumbnail.path.replace("http://", "https://") +"."+ valor.thumbnail.extension).into(holder.imgHQ)
    }

    override fun getItemCount() = listaHQ.data.results.size

    interface onComicClickListener {
        fun comicClick( position: Int )
    }


}