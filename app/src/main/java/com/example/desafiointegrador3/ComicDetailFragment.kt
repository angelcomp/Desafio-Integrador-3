package com.example.desafiointegrador3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.desafiointegrador3.utils.Comic
import com.example.desafiointegrador3.utils.Thumbnail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_comic_detail.*


class ComicDetailFragment : Fragment() {

    lateinit var thumb: Thumbnail
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

        Picasso.get().load(args.comic.thumbnail.path.replace("http://", "https://") +"."+ args.comic.thumbnail.extension).into(iv_detailImg)
        teste.text = args.comic.description

        iv_detailImg.setOnClickListener {
            val thumb = ComicDetailFragmentDirections.actionComicDetailFragmentToComicThumbnailFragment(thumb)
        }
    }
}