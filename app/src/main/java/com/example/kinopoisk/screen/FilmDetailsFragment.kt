package com.example.kinopoisk.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.kinopoisk.databinding.FragmentFilmDetailsBinding
import com.example.kinopoisk.viewmodel.FilmDetailsViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class FilmDetailsFragment : Fragment() {

    private var _binding: FragmentFilmDetailsBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val args: FilmDetailsFragmentArgs by navArgs()
    private val viewModel: FilmDetailsViewModel by viewModel {
        parametersOf(args.filmId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentFilmDetailsBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.filmDetailsFlow.onEach { film ->
            with(binding) {
                imageLogo.load(film.coverUrl)
                filmName.text = film.nameRu

                var genre = "Жанр: "
                film.genres.forEach{
                    genre += "${it.genre}, "
                }
                binding.listGenres.text = genre

                imdbRating.text = film.ratingImdb.toString()
                kinopoiskRating.text = film.ratingKinopoisk.toString()

                country.text = film.countries.first().country
                description.text = film.description
            }

        }.launchIn(viewLifecycleOwner.lifecycleScope)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding
    }
}