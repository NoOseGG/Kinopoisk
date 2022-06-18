package com.example.kinopoisk.screen

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kinopoisk.databinding.FragmentListBinding
import com.example.kinopoisk.paging.FilmDataAdapter
import com.example.kinopoisk.viewmodel.ListViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: ListViewModel by viewModel()
    private val adapter by lazy {
        FilmDataAdapter(requireContext()) { film ->
            val action = ListFragmentDirections.actionListFragmentToFilmDetailsFragment(
                filmId = film.filmId,
                filmName = film.nameRu
            )
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentListBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            if (requireContext().resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                recyclerView.layoutManager = GridLayoutManager(
                    requireContext(),
                    2,
                )
                setupRecyclerView()
            }

            if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                recyclerView.layoutManager = GridLayoutManager(
                    requireContext(),
                    1,
                    GridLayoutManager.HORIZONTAL,
                    false
                )
                setupRecyclerView()
            }
        }
        println("11111111111111111111111111111111111")
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.films.collectLatest {
                adapter.submitData(it)
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        with(binding) {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }
    }

}



