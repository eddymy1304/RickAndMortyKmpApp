package com.eddymy1304.rickandmortykmpapp.ui.preview

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eddymy1304.rickandmortykmpapp.domain.model.CharacterModel
import com.eddymy1304.rickandmortykmpapp.feature.home.characters.CharactersScreen
import com.eddymy1304.rickandmortykmpapp.feature.home.characters.CharactersState
import com.eddymy1304.rickandmortykmpapp.ui.components.LoadingDialog
import com.eddymy1304.rickandmortykmpapp.ui.theme.RickAndMortyKmpAppTheme

/*
@Preview
@Composable
fun LoadingDialogPreview() {
    RickAndMortyKmpAppTheme {
        LoadingDialog(onDismiss = {})
    }
}
*/


@Preview(
    showBackground = true, uiMode = UI_MODE_NIGHT_NO,
    device = "id:API 26"
)
@Composable
fun CharactersScreenPreview() {
    RickAndMortyKmpAppTheme {

        CharactersScreen(
            state = CharactersState(
                isLoading = false,
                characterOfTheDay = CharacterModel(
                    id = 1,
                    name = "Rick Sanchez Lopez Lopez Lopez Lopez",
                    isAlive = true,
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"
                )
            )
        )

    }
}