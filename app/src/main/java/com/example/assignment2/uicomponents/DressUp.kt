package com.example.assignment2.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.assignment2.model.Clothes
import com.example.assignment2.model.OnoffStatus

@Composable
fun DressUp(clothesList: SnapshotStateList<Clothes>, orientation: Int, modifier: Modifier = Modifier) {

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(modifier = modifier) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // 상단 반 차지
                , contentAlignment = Alignment.Center
            ) {
                // 몸통은 따로
                OnoffClothes(clothes = clothesList[0])
                // 몸통 빼고
                clothesList.drop(1).forEach { clothes ->
                    if (clothes.status == OnoffStatus.ON) {
                        OnoffClothes(clothes = clothes) // ✅ 체크된 항목만 표시
                    }
                }
            }
            Column(
                modifier = Modifier
                    .weight(1f) // 하단 반 차지
                    .fillMaxWidth()
            ) {
                clothesList.drop(1).chunked(2).forEachIndexed { chunkIndex, chunk ->
                    Row {
                        chunk.forEachIndexed { indexInRow, clothes ->
                            val actualIndex = chunkIndex * 2 + indexInRow + 1
                            OnoffCheckbox(
                                isChecked = (clothes.status == OnoffStatus.ON),
                                onCheckedChange = { isChecked ->
                                    clothesList[actualIndex] = clothesList[actualIndex].copy(
                                        status = if (isChecked) OnoffStatus.ON else OnoffStatus.OFF
                                    )
                                },
                                modifier = Modifier.weight(1f),
                                partName = clothes.partName
                            )
                        }
                    }
                }
            }

        }
    } else {
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(), // 상단 반 차지
                contentAlignment = Alignment.Center,
                ) {
                // 몸통은 따로
                OnoffClothes(clothes = clothesList[0])
                // 몸통 빼고
                clothesList.drop(1).forEach { clothes ->
                    if (clothes.status == OnoffStatus.ON) {
                        OnoffClothes(clothes = clothes) // ✅ 체크된 항목만 표시
                    }
                }
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)) {
                clothesList.drop(1).chunked(5).forEachIndexed { chunkIndex, chunk ->
                    Column {
                        chunk.forEachIndexed { indexInRow, clothes ->
                            val actualIndex = chunkIndex * 5 + indexInRow + 1
                            OnoffCheckbox(
                                isChecked = (clothes.status == OnoffStatus.ON),
                                onCheckedChange = { isChecked ->
                                    clothesList[actualIndex] = clothesList[actualIndex].copy(
                                        status = if (isChecked) OnoffStatus.ON else OnoffStatus.OFF
                                    )
                                },

                                partName = clothes.partName
                            )
                        }
                    }
                }
            }
        }
    }
}
