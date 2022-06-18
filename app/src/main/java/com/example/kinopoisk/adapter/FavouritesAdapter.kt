package com.example.kinopoisk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kinopoisk.databinding.FilmItemBinding
import com.example.kinopoisk.databinding.FragmentFavouritesBinding
import com.example.kinopoisk.model.Film
import com.example.kinopoisk.model.FilmDetails

class FavouritesAdapter(
    private val onClick: (FilmDetails) -> Unit
) : ListAdapter<FilmDetails, FilmDetailsViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmDetailsViewHolder {
        return FilmDetailsViewHolder(
            FilmItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick = onClick
        )
    }

    override fun onBindViewHolder(holder: FilmDetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<FilmDetails>() {
            override fun areItemsTheSame(oldItem: FilmDetails, newItem: FilmDetails): Boolean {
                return oldItem.kinopoiskId == newItem.kinopoiskId
            }

            override fun areContentsTheSame(oldItem: FilmDetails, newItem: FilmDetails): Boolean {
                return oldItem == newItem
            }
        }
    }
}

class FilmDetailsViewHolder(
    private val binding: FilmItemBinding,
    private val onClick: (FilmDetails) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: FilmDetails) {
        binding.filmPoster.load(item.posterUrl)
        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}
