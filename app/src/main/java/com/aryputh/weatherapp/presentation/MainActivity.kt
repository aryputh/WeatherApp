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
import com.aryputh.weatherapp.presentation.ui.theme.Humidity
import com.aryputh.weatherapp.presentation.ui.theme.LightBackground
import com.aryputh.weatherapp.presentation.ui.theme.Primary
import com.aryputh.weatherapp.presentation.ui.theme.Secondary
import com.aryputh.weatherapp.presentation.ui.theme.Sunrise
import com.aryputh.weatherapp.presentation.ui.theme.Sunset
import com.aryputh.weatherapp.presentation.ui.theme.UVIndex
import com.aryputh.weatherapp.presentation.ui.theme.WeatherAppTheme
import com.aryputh.weatherapp.presentation.ui.theme.roboto_mono_family
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

// Entry point of the app
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // Create a weather model and permission launcher variable
    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Request permissions like location for the app to run
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ))

        // Main content of the app
        setContent {
            WeatherAppTheme {
                // A surface container
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    // Show day background by default
                    GradientBackground()

                    // Detect if the data is loading and show screen accordingly
                    if(viewModel.state.isLoading) {
                        // Show loading text and circular loading animation
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            // Circular loading animation
                            CircularProgressIndicator(
                                modifier = Modifier.size(64.dp),
                                color = Primary
                            )

                            // Loading text
                            Text(
                                text = "Loading...",
                                color = Primary,
                                fontSize = 15.sp,
                                fontFamily = roboto_mono_family,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(top = 16.dp)
                            )
                        }
                    }
                    viewModel.state.error?.let { error ->
                        // If there is an error, show the error text and the error
                        Text(
                            text = error,
                            color = Primary,
                            fontSize = 15.sp,
                            fontFamily = roboto_mono_family,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .padding(all = 32.dp)
                        )
                    }

                    // Make background gradient change based on if it's day or night
                    viewModel.state.weatherInfo?.currentWeatherData?.let { data ->
                        GradientBackgroundDynamic(data)
                    }

                    // Show the weather page, containing the rest of the UI
                    WeatherPage(viewModel.state)
                }
            }
        }
    }
}

// Contains the main components of the app's UI
@Composable
fun WeatherPage(state: WeatherState, modifier: Modifier = Modifier) {
    // Organize everything into a column
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(top = 64.dp, bottom = 64.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
        // Using data, display different UI aspects
        state.weatherInfo?.currentWeatherData?.let { data ->
            WeatherIcon(data)
            MainInfo(data)
            ItemTable(data)
        }
    }
}

// Displays a default gradient background
@Composable
fun GradientBackground(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(LightBackground)
    )
}

// Displays a gradient background, the color depending on day/night status
@Composable
fun GradientBackgroundDynamic(data: WeatherData, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                // Set it to light background if it's day
                if (data.isDay == 1) LightBackground else DarkBackground
            )
    )
}

// Show the weather icon, depending on current weather
@Composable
fun WeatherIcon(data: WeatherData, modifier: Modifier = Modifier)
{
    Image(
        // Get icon depending on weather type
        painter = painterResource(id = data.weatherType.iconRes),
        colorFilter = ColorFilter.tint(Primary),
        contentDescription = null,
        modifier = modifier
            .width(200.dp)
            .height(200.dp)
    )
}

// Contains all the main information in the app
@Composable
fun MainInfo(data: WeatherData, modifier: Modifier = Modifier)
{
    // Make everything into a column layout
    Column (
        modifier = modifier
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row {
            // Displays the current temperature
            Text(
                text = "${(data.temperatureCelsius * 9 / 5 + 32).toInt()}",
                color = Primary,
                fontSize = 90.sp,
                fontFamily = roboto_mono_family,
                fontWeight = FontWeight.Normal
            )
        }

        // Displays the current weather
        Text(
            text = "~ ${data.weatherType.weatherDesc} ~",
            color = Primary,
            fontSize = 15.sp,
            fontFamily = roboto_mono_family,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(bottom = 32.dp)
        )
    }
}

// Contains logic for the humidity, sunset/sunrise, and cloud cover
@Composable
fun ItemTable(data: WeatherData, modifier: Modifier = Modifier)
{
    Column(
        modifier = modifier
            .fillMaxWidth(0.9f)
            .clip(RoundedCornerShape(8.dp))
            .background(
                Color.Transparent
            )
    ){
        // Row that shows the humidity and cloud cover
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(vertical = 8.dp, horizontal = 32.dp)
                .fillMaxWidth()
        ){
            // Create an InfoItem to show humidity
            InfoItem(
                iconRes = R.drawable.humidity,
                title = "Humidity",
                subtitle = "${data.humidity.roundToInt()}%",
                color = Humidity,
                modifier = modifier
            )

            // Create an InfoItem to show cloud cover
            InfoItem(
                iconRes = R.drawable.cloud_cover,
                title = "Clouds",
                subtitle = "${data.cloudCover.roundToInt()}%",
                color = UVIndex,
                modifier = modifier
            )
        }

        // Create a divider between top and bottom row
        Divider(
            color = Primary.copy(alpha = 0.5F),
            modifier = modifier
                .padding(horizontal = 16.dp)
                .alpha(0.5F)
        )

        // Row that shows the sunrise and sunset times
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .padding(vertical = 8.dp, horizontal = 32.dp)
                .fillMaxWidth()
        ){
            // Create an InfoItem to show sunrise time
            InfoItem(
                iconRes = R.drawable.sunrise,
                title = "Sunrise",
                subtitle = data.sunrise,
                color = Sunrise,
                modifier = modifier
            )

            // Create an InfoItem to show sunset time
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

// The function to make an InfoItem
@Composable
fun InfoItem(@DrawableRes iconRes: Int, title: String, subtitle: String, color: Color, modifier: Modifier)
{
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        // Creates an icon for the current InfoItem
        Image(
            painter = painterResource(id = iconRes),
            colorFilter = ColorFilter.tint(color),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = modifier
                .padding(horizontal = 8.dp)
                .width(40.dp)
        )

        // Creates a title and subtitle for the current InfoItem
        Column {
            Text(
                text = title,
                color = Primary,
                fontSize = 13.sp,
                fontFamily = roboto_mono_family,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(top = 8.dp)
            )

            Text(
                text = subtitle,
                color = Secondary,
                fontSize = 13.sp,
                fontFamily = roboto_mono_family,
                fontWeight = FontWeight.Normal,
                modifier = modifier
                    .padding(bottom = 8.dp)
            )
        }
    }
}