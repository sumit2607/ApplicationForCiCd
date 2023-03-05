package com.example.applicationforcicd

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.contextaware.ContextAware
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.applicationforcicd.ui.theme.ApplicationForCiCdTheme
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class MainActivity : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApplicationForCiCdTheme {
                // A surface container using the 'background' color from the theme
                MyButton();
            }
        }


        AppCenter.start(
            application, "274ea1cf-cd00-40b0-8105-e2f553a84ed3",
            Analytics::class.java, Crashes::class.java
        )


    }

    private fun MyButton() {
        TODO("Not yet implemented")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApplicationForCiCdTheme {
        // we are passing our composable
        // function to display its preview.
        MyButton();
    }
}

@Composable
fun MyButton() {

    Column(
        // we are using column to align our
        // imageview to center of the screen.
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),

        // below line is used for specifying
        // vertical arrangement.
        verticalArrangement = Arrangement.Center,

        // below line is used for specifying
        // horizontal arrangement.
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // below line is use to get
        // the context for our app.


        // below line is use to create a button.
        Button(
            // below line is use to add onclick
            // parameter for our button onclick
            onClick = {
                // when user is clicking the button
                // we are displaying a toast message.
                Analytics.trackEvent("My custom event");
               Crashes.generateTestCrash()
               // Toast.makeText(Context,  "Welcome to Geeks for Geeks", Toast.LENGTH_LONG).show()
            },
            // in below line we are using modifier
            // which is use to add padding to our button
            modifier = Modifier.padding(all = Dp(10F)),

            // below line is use to set or
            // button as enable or disable.
            enabled = true,

            // below line is use to
            // add border to our button.
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),

            // below line is use to add shape for our button.
            shape = MaterialTheme.shapes.medium,
        )
        // below line is use to
        // add text on our button
        {
            Text(text = "Click Here", color = Color.White)
        }
    }
}