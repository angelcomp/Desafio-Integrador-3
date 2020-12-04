package com.example.desafiointegrador3

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.desafiointegrador3.utils.Comic
import com.example.desafiointegrador3.utils.Thumbnail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_comic_detail.*
import kotlin.math.log10


class ComicDetailFragment : Fragment() {

    val args: ComicDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comic_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val comicsArgs = args.comic

        if (args.comic.thumbnail.extension != null) {
            Picasso.get().load(args.comic.thumbnail.path.replace("http://", "https://") +"."+ args.comic.thumbnail.extension).into(iv_imgDetail)
        }

        if (args.comic.title != null) {
            tv_titleDetail.text = args.comic.title
        }

        if (comicsArgs.description != null) {
            tv_descriptionDetail.text = "Description:" + args.comic.description
        }

        if (comicsArgs.dates != null) {
            tv_publish.text = "Date: ${comicsArgs.dates[0].date}"
        }

        if (comicsArgs.prices != null) {
            tv_price.text = "Price: ${comicsArgs.prices[0].price}"
        }

        if (args.comic.pageCount != null) {
            tv_pages.text = "Pages: " + comicsArgs.pageCount
        }

        iv_imgDetail.setOnClickListener {
            val thumb = ComicDetailFragmentDirections.actionComicDetailFragmentToComicThumbnailFragment(args.comic.thumbnail)
            findNavController().navigate(thumb)
        }

        iv_backComic.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}