package com.example.jpt1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jpt1.ui.theme.JPT1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JPT1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val meown = Meown()

                    //meown.HeaderTextField2Buttons()

                    val comp = Components()
                    val labelValuePairs: List<LabelAndValue> = listOf(
                        LabelAndValue("Reps", "Val 12"),
                        LabelAndValue("Weight", "Val 42"),
                        LabelAndValue("Units", "Kg"),
                    )
                    //comp.Example1()
                    comp.aRowOfIconAndTextFields("barbell",labelValuePairs)
                    //comp.myTextField("label","value")

                }
            }
        }
    }
}


