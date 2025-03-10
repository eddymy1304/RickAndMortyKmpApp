package com.eddymy1304.rickandmortykmpapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems

sealed class PagingType(
    open val modifier: Modifier = Modifier,
    open val contentPadding: PaddingValues = PaddingValues(0.dp),
    open val reverseLayout: Boolean = false,
    open val userScrollEnabled: Boolean = true,
    open val verticalArrangement: Arrangement.Vertical = if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
    open val horizontalArrangement: Arrangement.Horizontal = if (!reverseLayout) Arrangement.Start else Arrangement.End
) {
    data class Row(
        override val modifier: Modifier = Modifier,
        override val contentPadding: PaddingValues = PaddingValues(0.dp),
        override val reverseLayout: Boolean = false,
        override val userScrollEnabled: Boolean = true,
        override val horizontalArrangement: Arrangement.Horizontal = if (!reverseLayout) Arrangement.Start else Arrangement.End,
        val verticalAlignment: Alignment.Vertical = Alignment.Top,
    ) : PagingType()

    data class Column(
        override val modifier: Modifier = Modifier,
        override val contentPadding: PaddingValues = PaddingValues(0.dp),
        override val reverseLayout: Boolean = false,
        override val userScrollEnabled: Boolean = true,
        override val verticalArrangement: Arrangement.Vertical = if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
        val horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    ) : PagingType()

    data class VerticalGrid(
        override val modifier: Modifier = Modifier,
        override val contentPadding: PaddingValues = PaddingValues(0.dp),
        override val reverseLayout: Boolean = false,
        override val userScrollEnabled: Boolean = true,
        override val verticalArrangement: Arrangement.Vertical = if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
        override val horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
        val columns: GridCells = GridCells.Fixed(2)
    ) : PagingType()
}

@Composable
fun <T : Any> PagingWrapper(
    pagingType: PagingType,
    items: LazyPagingItems<T>,
    initialView: @Composable () -> Unit = {},
    emptyView: @Composable () -> Unit = {},
    loadingView: @Composable () -> Unit = {},
    extraItemsView: @Composable () -> Unit = {},
    itemView: @Composable (T) -> Unit
) {


    when {

        items.loadState.refresh is LoadState.Loading && items.itemCount == 0 -> {
            // initial loading
            initialView()
        }

        items.loadState.refresh is LoadState.NotLoading && items.itemCount == 0 -> {
            // no data
            emptyView()
        }


        else -> {

            when (pagingType) {
                is PagingType.Column -> {
                    LazyColumn(
                        modifier = pagingType.modifier,
                        contentPadding = pagingType.contentPadding,
                        reverseLayout = pagingType.reverseLayout,
                        verticalArrangement = pagingType.verticalArrangement,
                        horizontalAlignment = pagingType.horizontalAlignment,
                        userScrollEnabled = pagingType.userScrollEnabled
                    ) {
                        items(items.itemCount) { index ->
                            items[index]?.let { item ->
                                itemView(item)
                            }
                        }
                    }
                }

                is PagingType.Row -> {
                    LazyRow(
                        modifier = pagingType.modifier,
                        contentPadding = pagingType.contentPadding,
                        reverseLayout = pagingType.reverseLayout,
                        verticalAlignment = pagingType.verticalAlignment,
                        horizontalArrangement = pagingType.horizontalArrangement,
                        userScrollEnabled = pagingType.userScrollEnabled
                    ) {
                        items(items.itemCount) { index ->
                            items[index]?.let { item ->
                                itemView(item)
                            }
                        }
                    }
                }

                is PagingType.VerticalGrid -> {
                    LazyVerticalGrid(
                        columns = pagingType.columns,
                        modifier = pagingType.modifier,
                        contentPadding = pagingType.contentPadding,
                        reverseLayout = pagingType.reverseLayout,
                        verticalArrangement = pagingType.verticalArrangement,
                        horizontalArrangement = pagingType.horizontalArrangement,
                        userScrollEnabled = pagingType.userScrollEnabled
                    ) {
                        items(items.itemCount) { index ->
                            items[index]?.let { item ->
                                itemView(item)
                            }
                        }
                    }
                }
            }

            if (items.loadState.append is LoadState.Loading) loadingView()
        }
    }
}