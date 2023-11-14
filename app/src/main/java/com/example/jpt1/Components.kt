package com.example.jpt1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import java.lang.reflect.Field

data class LabelAndValue(val label: String, val value: String)

class Components {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun myTextField(label : String, aVal: String) {
        var text1 by remember { mutableStateOf(TextFieldValue(aVal)) }
        OutlinedTextField(
            value = text1,
            onValueChange = { newText -> text1 = newText },
            label = { Text(label) },
            modifier = Modifier.width(80.dp)
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun aRowOfIconAndTextFields(which: String, labelValuePairs: List<LabelAndValue> ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            anIcon(which = which)

            for ((label, value) in labelValuePairs) {
                myTextField("$label", "$value")
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Example1() {
        val series1: List<LabelAndValue> = listOf(
            LabelAndValue("Reps", "12"),
            LabelAndValue("Weight", "42"),
            LabelAndValue("Units", "Kg"),
        )
        val series2: List<LabelAndValue> = listOf(
            LabelAndValue("Reps", "13"),
            LabelAndValue("Weight", "33"),
            LabelAndValue("Units", "Kg"),
        )

        Column()
        {
            aRowOfIconAndTextFields("glutes", labelValuePairs = series1)
            aRowOfIconAndTextFields("breast", labelValuePairs = series2)
        }
    }

    @Composable
    fun anIcon(which: String) {
        val resourceId = getResourceIdFromName(which)

        if (resourceId != 0) {
            Image(
                painter = painterResource(id = resourceId),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
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
    
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun aRowOfTextFields(labelValuePairs: List<LabelAndValue> ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for ((label, value) in labelValuePairs) {
                myTextField("$label", "$value")
            }
        }
    }

}