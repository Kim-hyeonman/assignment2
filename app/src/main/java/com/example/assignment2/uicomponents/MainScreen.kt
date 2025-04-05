package com.example.assignment2.uicomponents


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2.model.Clothes
import com.example.assignment2.model.ClothesFactory
import com.example.assignment2.model.OnoffStatus

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val orientation = LocalConfiguration.current.orientation

    val clothesList = rememberSaveable(
        saver = listSaver(
            save = { list -> list.map { it.status.name } },
            restore = { savedStatuses ->
                mutableStateListOf<Clothes>().apply {
                    val original = ClothesFactory.makeOnoffClothes()
                    original.forEachIndexed { index, item ->
                        val status =
                            OnoffStatus.valueOf(savedStatuses.getOrNull(index) ?: item.status.name)
                        add(item.copy(status = status))
                    }
                }
            }
        )
    ) {
        mutableStateListOf<Clothes>().apply {
            addAll(ClothesFactory.makeOnoffClothes())
        }
    }


    DressUp(orientation = orientation, clothesList = clothesList)
    Text(
        modifier = Modifier.padding(32.dp),
        text = "202111272 김현만",
        fontSize = 32.sp
    )

}
