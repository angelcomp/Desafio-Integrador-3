package com.example.desafiointegrador3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiointegrador3.ui.MainFragmentDirections
import com.example.desafiointegrador3.R
import com.example.desafiointegrador3.services.service
import com.example.desafiointegrador3.utils.Comic
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), MainAdapter.onComicClickListener {

    lateinit var adapter: MainAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var listaComics: Comic

    //val viewModel: MainViewModel by viewModels()
    val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(service) as T
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = GridLayoutManager(context, 3)

        rv_hq.layoutManager = layoutManager

        viewModel.lista.observe(viewLifecycleOwner) {
            adapter = MainAdapter(it, this)
            listaComics = it
            rv_hq.adapter = adapter
        }

        viewModel.popList()
    }

    override fun comicClick(position: Int) {
        val comic = MainFragmentDirections.actionMainFragmentToComicDetailFragment(listaComics.data.results[position])
        findNavController().navigate(comic)
    }

}