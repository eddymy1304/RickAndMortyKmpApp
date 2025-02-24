package com.eddymy1304.rickandmortykmpapp

import androidx.compose.ui.window.ComposeUIViewController
import com.eddymy1304.rickandmortykmpapp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }