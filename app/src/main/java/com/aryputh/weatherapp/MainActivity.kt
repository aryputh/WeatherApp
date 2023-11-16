package com.aryputh.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aryputh.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
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
fun HeaderImage(modifier: Modifier = Modifier)
{
    Image(
        painter = painterResource(id = R.drawable.header_image),
        contentDescription = null,
        modifier
            .width(250.dp)
            .height(250.dp)
    )
}

@Composable
fun MainInfo(modifier: Modifier = Modifier)
{
    Column (
        modifier = modifier
            .padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "11°",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Pullman, WA",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = modifier
                .padding(top = 16.dp)
        )
        Text(
            text = "Rainy with a chance of rain.\nHigh winds ~10-15 mph.",
            color = Color.Gray,
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(vertical = 24.dp)
        )
    }
}

@Composable
fun ItemTable(modifier: Modifier = Modifier)
{
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(if (isSystemInDarkTheme()) Color.Black.copy(alpha = 0.2F) else Color.LightGray.copy(alpha = 0.2F))
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            InfoItem(
                iconRes = R.drawable.humidity,
                title = "Humidity",
                subtitle = "85%",
                modifier = modifier
            )
            InfoItem(
                iconRes = R.drawable.uv_index,
                title = "UV Index",
                subtitle = "2 of 10",
                modifier = modifier
            )
        }

        Divider(
            color = Color.LightGray,
            modifier = modifier
                .padding(horizontal = 20.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            InfoItem(
                iconRes = R.drawable.sunrise,
                title = "Sunrise",
                subtitle = "7:30 AM",
                modifier = modifier
            )
            InfoItem(
                iconRes = R.drawable.sunset,
                title = "Sunset",
                subtitle = "4:28 PM",
                modifier = modifier
            )
        }
    }
}

@Composable
fun InfoItem(@DrawableRes iconRes: Int, title: String, subtitle: String, modifier: Modifier)
{
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = modifier
                .padding(end = 16.dp)
                .width(40.dp)
        )
        Column {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = subtitle,
                color = Color.Gray,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun WeatherAppPreview() {
    WeatherAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            WeatherPage()
        }
    }
}