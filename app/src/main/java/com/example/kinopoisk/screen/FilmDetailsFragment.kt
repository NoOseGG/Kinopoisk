package com.example.kinopoisk.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.kinopoisk.R
import com.example.kinopoisk.databinding.FragmentFilmDetailsBinding
import com.example.kinopoisk.model.FilmDetails
import com.example.kinopoisk.viewmodel.FilmDetailsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import kotlin.properties.Delegates


class FilmDetailsFragment : Fragment() {

    private var _binding: FragmentFilmDetailsBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val args: FilmDetailsFragmentArgs by navArgs()
    private val viewModel: FilmDetailsViewModel by viewModel {
        parametersOf(args.filmId)
    }
    private var filmDetails: FilmDetails by Delegates.notNull()

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
                filmDetails = film
                imageLogo.load(film.coverUrl)
                filmName.text = film.nameRu

                var genre = "Жанр: "
                /*film.genres.forEach {
                    genre += "${it.genre}, "
                }*/
                binding.listGenres.text = genre

                imdbRating.text = film.ratingImdb.toString()
                kinopoiskRating.text = film.ratingKinopoisk.toString()

                /*country.text = film.countries.first().country*/
                description.text = film.description

                if (film.favorites) {
                    imgFavorites.setImageResource(R.drawable.ic_favorites_true)
                } else {
                    imgFavorites.setImageResource(R.drawable.ic_favorites_false)
                }
            }

        }.launchIn(viewLifecycleOwner.lifecycleScope)

        binding.country.setOnClickListener {
            val action = FilmDetailsFragmentDirections.actionFilmDetailsFragmentToGoogleMapFragment(
                binding.country.text.toString()
            )
            findNavController().navigate(action)
        }

        with(binding) {
            imgFavorites.setOnClickListener {
                if(filmDetails.favorites) {
                    imgFavorites.setImageResource(R.drawable.ic_favorites_false)
                    filmDetails.favorites = false
                    viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                        viewModel.deleteFilm(filmDetails)
                    }
                } else {
                    imgFavorites.setImageResource(R.drawable.ic_favorites_true)
                    filmDetails.favorites = true
                    viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                        viewModel.insertFilm(filmDetails)
                    }
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding
    }
}