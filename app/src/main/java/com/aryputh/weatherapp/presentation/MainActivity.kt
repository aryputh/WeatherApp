package com.aryputh.weatherapp.presentation

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aryputh.weatherapp.R
import com.aryputh.weatherapp.domain.weather.WeatherData
import com.aryputh.weatherapp.presentation.ui.theme.DarkBackground
import com.aryputh.weatherapp.presentation.ui.theme.DarkSecondary
import com.aryputh.weatherapp.presentation.ui.theme.Humidity
import com.aryputh.weatherapp.presentation.ui.theme.LightBackground
import com.aryputh.weatherapp.presentation.ui.theme.LightPrimary
import com.aryputh.weatherapp.presentation.ui.theme.LightSecondary
import com.aryputh.weatherapp.presentation.ui.theme.Sunrise
import com.aryputh.weatherapp.presentation.ui.theme.Sunset
import com.aryputh.weatherapp.presentation.ui.theme.UVIndex
import com.aryputh.weatherapp.presentation.ui.theme.WeatherAppTheme
import com.aryputh.weatherapp.presentation.ui.theme.roboto_mono_family
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ))
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    GradientBackground()
                    WeatherPage(viewModel.state)

                    if(viewModel.state.isLoading) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(64.dp),
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "Loading...",
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 15.sp,
                                fontFamily = roboto_mono_family,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(top = 16.dp)
                            )
                        }
                    }
                    viewModel.state.error?.let { error ->
                        Text(
                            text = error,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 15.sp,
                            fontFamily = roboto_mono_family,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .padding(all = 32.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun WeatherPage(state: WeatherState, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(top = 64.dp, bottom = 64.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
        state.weatherInfo?.currentWeatherData?.let { data ->
            HeaderImage(data)
            MainInfo(data)
            ItemTable(data)
        }
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
fun HeaderImage (data: WeatherData, modifier: Modifier = Modifier)
{
    Image(
        painter = painterResource(id = data.weatherType.iconRes),
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
        contentDescription = null,
        modifier = modifier
            .width(200.dp)
            .height(200.dp)
    )
}

@Composable
fun MainInfo(data: WeatherData, modifier: Modifier = Modifier)
{
    Column (
        modifier = modifier
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row {
            Text(
                text = "${(data.temperatureCelsius * 9 / 5 + 32).toInt()}",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 90.sp,
                fontFamily = roboto_mono_family,
                fontWeight = FontWeight.Normal
            )
        }
        Text(
            text = "~ ${data.weatherType.weatherDesc} ~",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 15.sp,
            fontFamily = roboto_mono_family,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(bottom = 32.dp)
        )
    }
}

@Composable
fun ItemTable(data: WeatherData, modifier: Modifier = Modifier)
{
    Column(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .clip(RoundedCornerShape(8.dp))
            .background(
//                if (isSystemInDarkTheme()) DarkPrimary.copy(alpha = 0.3F) else LightPrimary.copy(alpha = 0.3F)
                Color.Transparent
            )
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(vertical = 8.dp, horizontal = 32.dp)
                .fillMaxWidth()
        ){
            InfoItem(
                iconRes = R.drawable.humidity,
                title = "Humidity",
                subtitle = "${data.humidity.roundToInt()}%",
                color = Humidity,
                modifier = modifier
            )
            InfoItem(
                iconRes = R.drawable.cloud_cover,
                title = "Clouds",
                subtitle = "${data.cloudCover.roundToInt()}%",
                color = UVIndex,
                modifier = modifier
            )
        }

        Divider(
//            color = if (isSystemInDarkTheme()) DarkPrimary.copy(alpha = 0.5F) else LightPrimary.copy(alpha = 0.5F),
            color = LightPrimary.copy(alpha = 0.5F),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .alpha(0.5F)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(vertical = 8.dp, horizontal = 32.dp)
                .fillMaxWidth()
        ){
            InfoItem(
                iconRes = R.drawable.sunrise,
                title = "Sunrise",
                subtitle = data.sunrise,
                color = Sunrise,
                modifier = modifier
            )
            InfoItem(
                iconRes = R.drawable.sunset,
                title = "Sunset",
                subtitle = data.sunset,
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
                fontSize = 13.sp,
                fontFamily = roboto_mono_family,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(top = 8.dp)
            )
            Text(
                text = subtitle,
                color =
                    if (isSystemInDarkTheme()) DarkSecondary else LightSecondary,
                fontSize = 13.sp,
                fontFamily = roboto_mono_family,
                fontWeight = FontWeight.Normal,
                modifier = modifier
                    .padding(bottom = 8.dp)
            )
        }
    }
}