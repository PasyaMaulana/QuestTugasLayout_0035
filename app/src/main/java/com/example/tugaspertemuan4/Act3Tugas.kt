package com.example.tugaspertemuan4

import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.TextUnit

@Composable
fun fontSizeResource(@DimenRes id: Int): TextUnit {
    val ukuran = dimensionResource(id)
    return with(LocalDensity.current) { ukuran.toSp() }
}