package com.example.assignment2.uicomponents


import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun OnoffCheckbox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    partName: String
) {
    Row(modifier = modifier) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
        )
        Text(text = partName, fontSize = 32.sp)
    }
}




@Preview
@Composable
private fun OnoffCheckboxPreview() {
    OnoffCheckbox(true, {}, partName = "arm")
}