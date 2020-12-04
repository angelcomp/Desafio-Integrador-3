package com.example.desafiointegrador3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_comic_detail.*
import kotlinx.android.synthetic.main.fragment_comic_thumbnail.*

class ComicThumbnailFragment : Fragment() {

    val args: ComicThumbnailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comic_thumbnail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get().load(args.thumb.path.replace("http://", "https://") +"."+ args.thumb.extension).into(iv_imgFullscreen)

        iv_backFullscreen.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}