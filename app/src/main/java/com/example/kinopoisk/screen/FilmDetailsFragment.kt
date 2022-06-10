package com.example.kinopoisk.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.kinopoisk.databinding.FragmentFilmDetailsBinding

class FilmDetailsFragment : Fragment() {

    private var _binding: FragmentFilmDetailsBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val args: FilmDetailsFragmentArgs by navArgs()

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

        binding.textView.text = args.filmName
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding
    }
}