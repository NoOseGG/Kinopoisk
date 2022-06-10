package com.example.kinopoisk.paging

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.kinopoisk.databinding.FilmItemBinding
import com.example.kinopoisk.model.Film

class FilmDataAdapter(
    context: Context
) : PagingDataAdapter<Film, FilmViewHolder>(DIFF_UTIL) {
    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(item) }
    }

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(
            binding = FilmItemBinding.inflate(layoutInflater)
        )
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Film>() {
            override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
                return oldItem.filmId == newItem.filmId
            }

            override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
                return oldItem == newItem
            }

        }
    }

}

class FilmViewHolder(
    private val binding: FilmItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Film) {
        binding.filmPoster.load(item.posterUrlPreview)
    }
}
