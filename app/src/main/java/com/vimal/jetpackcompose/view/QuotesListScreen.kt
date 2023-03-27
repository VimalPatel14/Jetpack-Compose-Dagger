package com.vimal.jetpackcompose.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.glide.rememberGlidePainter
import com.vimal.jetpackcompose.R
import com.vimal.jetpackcompose.model.Quotes

@Composable
fun QuotesListItem(quotes: Quotes) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, quotes.text, Toast.LENGTH_SHORT)
                    .show()
            }
            .clip(RoundedCornerShape(10.dp)),
        elevation = 10.dp
    ) {

        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberGlidePainter("https://picsum.photos/300/300"),
                contentDescription = stringResource(R.string.app_name)
            )
        }
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = quotes.text,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif
            )

            quotes.author?.let {
                Spacer(modifier = Modifier.padding(5.dp))

                Text(
                    text = quotes.author,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }
}


















