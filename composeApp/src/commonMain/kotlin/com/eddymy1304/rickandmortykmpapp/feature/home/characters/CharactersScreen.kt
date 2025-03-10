package com.eddymy1304.rickandmortykmpapp.feature.home.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.eddymy1304.rickandmortykmpapp.core.vertical
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier
) {

    val viewModel = koinViewModel<CharactersViewModel>()

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    CharactersScreen(
        modifier = modifier,
        state = state
    )

}

@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    state: CharactersState
) {

    val characters = state.characters.collectAsLazyPagingItems()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        CharactersGrid(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            characterOfTheDay = state.characterOfTheDay,
            characters = characters
        )
    }
}

@Composable
fun CharactersGrid(
    modifier: Modifier = Modifier,
    characterOfTheDay: CharacterModel? = null,
    characters: LazyPagingItems<CharacterModel>
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        characterOfTheDay?.let { character ->
            item(span = { GridItemSpan(2) }) {
                Column {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Character of the day",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                    CharactersCard(character = character)
                }
            }
        }

        when {

            characters.loadState.refresh is LoadState.Loading &&
                    characters.itemCount == 0 -> {
                // initial loading
                item(span = { GridItemSpan(2) }) {
                    Box(
                        modifier = modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }

            characters.loadState.refresh is LoadState.NotLoading &&
                    characters.itemCount == 0 -> {
                // no data
                item(span = { GridItemSpan(2) }) {
                    Box(
                        modifier = modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "No data")
                    }
                }
            }

            else -> {

                items(characters.itemCount) { index ->
                    characters[index]?.let { character ->
                        CharacterItem(character = character)
                    }
                }


                if (characters.loadState.append is LoadState.Loading) {
                    item(span = { GridItemSpan(2) }) {
                        Box(
                            modifier = modifier
                                .height(120.dp)
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(color = Color.Green)
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun CharacterItem(
    modifier: Modifier = Modifier,
    character: CharacterModel
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24))
            .border(
                width = 2.dp,
                color = Color.Green,
                shape = RoundedCornerShape(
                    0,
                    24,
                    0,
                    24
                )
            )
            .clickable { },
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            model = character.image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize(),
            //placeholder = image preview
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Black.copy(alpha = 0f),
                            Color.Black.copy(alpha = 0.6f),
                            Color.Black.copy(alpha = 0.9f)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = character.name,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }

}

@Composable
fun CharactersCard(
    modifier: Modifier = Modifier,
    character: CharacterModel
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(400.dp),
        shape = RoundedCornerShape(12),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart
        ) {

            AsyncImage(
                model = character.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            0f to Color.Black.copy(alpha = 0.9f),
                            0.4f to Color.White.copy(alpha = 0f),
                        )
                    )
            )

            Text(
                color = MaterialTheme.colorScheme.surface,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                overflow = TextOverflow.Ellipsis,
                text = character.name,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .vertical()
                    .rotate(-90f)
            )

        }
    }
}