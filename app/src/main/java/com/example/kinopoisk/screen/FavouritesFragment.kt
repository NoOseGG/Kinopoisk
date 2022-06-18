package com.example.kinopoisk.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kinopoisk.FavouritesAdapter
import com.example.kinopoisk.databinding.FragmentFavouritesBinding
import com.example.kinopoisk.viewmodel.FavouritesViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouritesFragment : Fragment() {

    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: FavouritesViewModel by viewModel()
    private val adapter by lazy {
        FavouritesAdapter() { filmDetails ->
            val action = FavouritesFragmentDirections.actionFavouritesFragmentToFilmDetailsFragment2(
                filmDetails.kinopoiskId,
                filmDetails.nameRu
            )
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFavouritesBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridlayout = GridLayoutManager(requireContext(), 2)
        with(binding) {
            recycleView.layoutManager = gridlayout
            recycleView.adapter = adapter
            recycleView.setHasFixedSize(true)
        }

        viewModel.filmsFlow.onEach {
            adapter.submitList(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}