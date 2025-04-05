package com.example.assignment2.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment2.R
import com.example.assignment2.model.Clothes
import com.example.assignment2.model.OnoffStatus

@Composable
fun OnoffClothes(clothes: Clothes, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = clothes.part),
        contentDescription = "",
        modifier = modifier.size(300.dp)
    )

}

//@Preview
//@Composable
//private fun OnoffClothesPreview() {
//    OnoffClothes(clothes = Clothes(partName = R.drawable.body, status = OnoffStatus.ON))
//}