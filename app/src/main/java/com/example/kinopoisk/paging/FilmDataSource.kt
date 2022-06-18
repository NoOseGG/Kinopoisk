package com.example.kinopoisk.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kinopoisk.model.Film
import com.example.kinopoisk.usecase.GetRemoteFilmsCountUseCase
import com.example.kinopoisk.usecase.GetRemoteFilmsUseCase
import java.lang.Exception

class FilmDataSource(
    private val getRemoteFilmsUseCase: GetRemoteFilmsUseCase,
    private val getRemoteFilmsCountUseCase: GetRemoteFilmsCountUseCase
) : PagingSource<Int, Film>() {
    override fun getRefreshKey(state: PagingState<Int, Film>): Int? {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Film> {
        return try {
            val nextPageNumber = params.key ?: 1
            val listFilms = getRemoteFilmsUseCase.invoke(nextPageNumber)
            val pageCount = getRemoteFilmsCountUseCase.invoke()
            LoadResult.Page(
                data = listFilms,
                prevKey = if(nextPageNumber > 0) nextPageNumber - 1 else null,
                nextKey = if(nextPageNumber < pageCount) nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}