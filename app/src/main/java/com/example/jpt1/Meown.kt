package com.example.jpt1

import android.graphics.drawable.shapes.OvalShape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.reflect.Field

class Meown {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HeaderTextField2Buttons() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Me Header",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.weights),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(16.dp))
            var text1 by remember { mutableStateOf(TextFieldValue("b4")) }
            var text2 by remember { mutableStateOf(TextFieldValue("after")) }

            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                TextField(
                    value = text1,
                    onValueChange = { newText -> text1 = newText },
                    label = { androidx.compose.material3.Text("label 1") },
                    modifier = Modifier.fillMaxWidth()
                )

                TextField(
                    value = text2,
                    onValueChange = { newText -> text2 = newText },
                    label = { androidx.compose.material3.Text("label 2") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(60.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly)
            {
                Button(
                    onClick = { /* Handle button click action */ },)
                {
                    Text("1")
                }
                Button(
                    onClick = { /* Handle button click action */ },)
                {
                    Text("2")
                }
            }
        }
    }

    @Composable
    fun twoButtonsWithTextAndImage() {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* Handle button click action */ },
                modifier = Modifier
                    .size(100.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.filledTonalButtonColors(),
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.glutes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .background(Color.LightGray)
                    )
                }
            }
            Button(
                onClick = { /* Handle button click action */ },
                modifier = Modifier
                    .size(100.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.breast),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }
    }


@Composable
    fun multiIconTest() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Me Header",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.weights),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(16.dp))
            IconButtonWithImageResourceAndBorder("glutes")
            Spacer(modifier = Modifier.height(16.dp))
            IconButtonWithImageResourceAndBorder("breast")
        }
    }

    @Composable
    fun IconButtonWithImageResourceAndBorder(which: String) {
        val resourceId = getResourceIdFromName(which)

        if (resourceId != 0) {
            Box(
                modifier = Modifier
                    .border(2.dp, Color.Blue)
                ) {
                IconButton(
                    onClick = {
                        // Handle button click action
                    }
                ) {
                    Image(
                        painter = painterResource(id = resourceId),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(6.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun iconTest(which: String) {
        val resourceId = getResourceIdFromName(which)

        if (resourceId != 0) {
            Image(
                painter = painterResource(id = resourceId),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        }
    }
    @Composable
    // helper for dynamic resource
    private fun getResourceIdFromName(name: String): Int {
        val resourcesClass = R.drawable::class.java
        val fields: Array<Field> = resourcesClass.declaredFields
        val fieldName = name.lowercase()

        for (field in fields) {
            if (field.name.lowercase() == fieldName) {
                try {
                    return field.getInt(null)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        return 0 // Return 0 if the resource doesn't exist
    }

    @Composable
    fun iconTest() {
        Image(
            // figma draw and export svg
            // use new vector asset to make an xml
            painter = painterResource(id = R.drawable.glutes),
            contentDescription = null, // Content description can be null for decorative images
            modifier = Modifier.size(24.dp) // Set the desired size of the icon
        )
    }

    @Composable
    fun headerPictureFields() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Me Header",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.weights),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(16.dp))
            someTf()
            Spacer(modifier = Modifier.height(16.dp))
            someTf()
        }
    }
        @Composable
    fun theLast() {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Add the image as a background

            Image(
                painter = painterResource(id = R.drawable.weights), // Replace with your image resource
                contentDescription = null, // Content description can be null for background images
                modifier = Modifier.fillMaxSize()
            )
            headAndBody()
        }
    }

        @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun headAndBody(modifier: Modifier = Modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Me Header",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Magenta
            )
            Spacer(modifier = Modifier.height(16.dp))
            someTf()
            Spacer(modifier = Modifier.height(16.dp))
            someTf()
        }
    }

    @Composable
    fun someBox() {
        Box(
            modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            someTf(modifier = Modifier.align(Alignment.TopCenter),"top")
            someTf(modifier = Modifier.align(Alignment.BottomCenter), "bottom")
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun someTf(modifier: Modifier = Modifier, init: String = "b4") {
        var text by remember { mutableStateOf(TextFieldValue(init)) }

        Column (
            modifier = modifier
        ){
            TextField(
                value = text,
                onValueChange = { newText -> text = newText},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun someTextFields(modifier: Modifier = Modifier) {
        var text1 by remember { mutableStateOf(TextFieldValue("b4")) }
        var text2 by remember { mutableStateOf(TextFieldValue("after")) }

        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TextField(
                value = text1,
                onValueChange = { newText -> text1 = newText},
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = text2,
                onValueChange = { newText -> text2 = newText },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    @Composable
    fun ColAndRowOfTexts(modifier: Modifier = Modifier) {
        Column (
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly
        )
        {
            aRowOfTexts(42)
            aRowOfTexts(43)
            aRowOfTexts(44)
        }
    }

    @Composable
    fun aRowOfTexts(v: Int, modifier: Modifier = Modifier) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        {
            doText(v, 1)
            doText(v, 3)
            doText(v, 1)
        }
    }


    @Composable
    fun doText(vo: Int, vi: Int, modifier: Modifier = Modifier) {
        val t = "C_" + vo + "_" + vi
        Text(
            text = t,
            modifier = modifier
        )
    }

        @Composable
    fun doSomething(modifier: Modifier = Modifier) {
        Column {
            Text(
                text = "Hello one",
                modifier = modifier
            )
            Text(
                text = "Hello two",
                modifier = modifier
            )
            Text(
                text = "Hello rrhhhhrr",
                modifier = modifier
            )    }
    }
}