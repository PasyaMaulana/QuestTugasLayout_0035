package com.example.tugaspertemuan4

import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.TextUnit
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height

@Composable
fun fontSizeResource(@DimenRes id: Int): TextUnit {
    val ukuran = dimensionResource(id)
    return with(LocalDensity.current) { ukuran.toSp() }
}

@Composable
fun InfoCard(
    @StringRes nama: Int,
    @StringRes alamat: Int,
    @ColorRes warnaCard: Int,
    @ColorRes warnaAlamat: Int,
    @DrawableRes gambar: Int,
    modifier: Modifier = Modifier,
    @StringRes telepon: Int? = null,
    namaFontFamily: FontFamily = FontFamily.Default,
    namaFontWeight: FontWeight = FontWeight.Bold
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(R.dimen.card_margin_horizontal),
                vertical = dimensionResource(R.dimen.card_margin_vertical)
            ),
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner)),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(warnaCard)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.card_padding)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(gambar),
                contentDescription = stringResource(R.string.desc_logo),
                modifier = Modifier.size(dimensionResource(R.dimen.logo_size))
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = dimensionResource(R.dimen.text_margin_horizontal))
            ) {
                Text(
                    text = stringResource(nama),
                    fontSize = fontSizeResource(R.dimen.font_nama),
                    fontFamily = namaFontFamily,
                    fontWeight = namaFontWeight,
                    color = colorResource(R.color.text_white)
                )
                if (telepon != null) {
                    Text(
                        text = stringResource(telepon),
                        fontSize = fontSizeResource(R.dimen.font_detail),
                        color = colorResource(R.color.text_cyan),
                        modifier = Modifier.padding(top = dimensionResource(R.dimen.text_gap))
                    )
                }
                Text(
                    text = stringResource(alamat),
                    fontSize = fontSizeResource(R.dimen.font_detail),
                    color = colorResource(warnaAlamat),
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.text_gap))
                )
            }
            Image(
                painter = painterResource(gambar),
                contentDescription = stringResource(R.string.desc_logo),
                modifier = Modifier.size(dimensionResource(R.dimen.logo_size))
            )
        }
    }
}

@Composable
fun AktivitasPertama(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = dimensionResource(R.dimen.padding_top)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.prodi),
            fontSize = fontSizeResource(R.dimen.font_title),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.univ),
            fontSize = fontSizeResource(R.dimen.font_subtitle),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.space_header)))

        InfoCard(
            nama = R.string.nama_1,
            alamat = R.string.alamat_1,
            telepon = R.string.telp_1,
            warnaCard = R.color.card_1_bg,
            warnaAlamat = R.color.text_yellow,
            gambar = R.drawable.logo_umy,
            namaFontFamily = FontFamily.Cursive,
            namaFontWeight = FontWeight.Normal
        )
        InfoCard(
            nama = R.string.nama_2,
            telepon = R.string.telp_2,
            alamat = R.string.alamat_2,
            warnaCard = R.color.card_2_bg,
            warnaAlamat = R.color.text_yellow,
            gambar = R.drawable.logo_umy
        )
        InfoCard(
            nama = R.string.nama_3,
            telepon = R.string.telp_3,
            alamat = R.string.alamat_3,
            warnaCard = R.color.card_3_bg,
            warnaAlamat = R.color.text_white,
            gambar = R.drawable.logo_umy
        )
        InfoCard(
            nama = R.string.nama_4,
            telepon = R.string.telp_4,
            alamat = R.string.alamat_4,
            warnaCard = R.color.card_4_bg,
            warnaAlamat = R.color.text_white,
            gambar = R.drawable.logo_umy
        )

        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = stringResource(R.string.copy),
                fontSize = fontSizeResource(R.dimen.font_copy),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = dimensionResource(R.dimen.padding_bottom))
            )
        }
    }
}