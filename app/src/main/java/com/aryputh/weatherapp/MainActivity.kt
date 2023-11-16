package com.aryputh.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aryputh.weatherapp.ui.theme.DarkBackground
import com.aryputh.weatherapp.ui.theme.DarkSecondary
import com.aryputh.weatherapp.ui.theme.Humidity
import com.aryputh.weatherapp.ui.theme.LightBackground
import com.aryputh.weatherapp.ui.theme.LightSecondary
import com.aryputh.weatherapp.ui.theme.Sunrise
import com.aryputh.weatherapp.ui.theme.Sunset
import com.aryputh.weatherapp.ui.theme.UVIndex
import com.aryputh.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    GradientBackground()
                    WeatherPage()
                }
            }
        }
    }
}

@Composable
fun WeatherPage(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(top = 64.dp, bottom = 64.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        HeaderImage()
        MainInfo()
        ItemTable()
    }
}

@Composable
fun GradientBackground(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                if (isSystemInDarkTheme()) DarkBackground else LightBackground
            )
    )
}

@Composable
fun HeaderImage(modifier: Modifier = Modifier)
{
    Image(
        painter = painterResource(id = R.drawable.header_image),
        contentDescription = null,
        modifier = modifier
            .width(250.dp)
            .height(250.dp)
    )
}

@Composable
fun MainInfo(modifier: Modifier = Modifier)
{
    Column (
        modifier = modifier
            .padding(vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "11°",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 60.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Pullman, WA",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = modifier
                .padding(vertical = 16.dp)
        )
        Text(
            text = "Rainy with a chance of rain.\nHigh winds ~10-15 mph.",
            color =
                if (isSystemInDarkTheme()) DarkSecondary else LightSecondary,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ItemTable(modifier: Modifier = Modifier)
{
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (isSystemInDarkTheme()) Color.Black.copy(alpha = 0.2F) else Color.LightGray.copy(
                    alpha = 0.2F
                )
            )
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            InfoItem(
                iconRes = R.drawable.humidity,
                title = "Humidity",
                subtitle = "85%",
                color = Humidity,
                modifier = modifier
            )
            InfoItem(
                iconRes = R.drawable.uv_index,
                title = "UV Index",
                subtitle = "2 of 10",
                color = UVIndex,
                modifier = modifier
            )
        }

        Divider(
            color = MaterialTheme.colorScheme.secondary,
            modifier = modifier
                .padding(horizontal = 16.dp)
                .alpha(0.5F)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            InfoItem(
                iconRes = R.drawable.sunrise,
                title = "Sunrise ",
                subtitle = "7:30 AM",
                color = Sunrise,
                modifier = modifier
            )
            InfoItem(
                iconRes = R.drawable.sunset,
                title = "Sunset  ",
                subtitle = "4:28 PM",
                color = Sunset,
                modifier = modifier
            )
        }
    }
}

@Composable
fun InfoItem(@DrawableRes iconRes: Int, title: String, subtitle: String, color: Color, modifier: Modifier)
{
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = iconRes),
            colorFilter = ColorFilter.tint(color),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = modifier
                .padding(horizontal = 8.dp)
                .width(40.dp)
        )
        Column {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = modifier
                    .padding(horizontal = 8.dp)
            )
            Text(
                text = subtitle,
                color =
                    if (isSystemInDarkTheme()) DarkSecondary else LightSecondary,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                modifier = modifier
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun WeatherAppPreview() {
    WeatherAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            GradientBackground()
            WeatherPage()
        }
    }
}