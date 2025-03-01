package com.eddymy1304.rickandmortykmpapp.feature.home.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShieldMoon
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import coil3.compose.AsyncImage
import com.eddymy1304.rickandmortykmpapp.core.vertical
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier
) {

    val viewModel = koinViewModel<CharactersViewModel>()

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    CharactersScreen(
        modifier = modifier, state = state
    )

}

@Composable
fun CharactersScreen(
    modifier: Modifier = Modifier,
    state: CharactersState
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        state.characterOfTheDay?.let {
            CharactersCard(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                character = it
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