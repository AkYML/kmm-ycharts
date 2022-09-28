package com.ygraph.components.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ygraph.components.common.model.LegendLabel
import com.ygraph.components.common.model.LegendsConfig

@Composable
fun Legends(modifier: Modifier = Modifier, legendsConfig: LegendsConfig) {
    with(legendsConfig) {
        if (legendLabelList.size > 1) {
            LazyVerticalGrid(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = gridPaddingHorizontal,
                        vertical = gridPaddingVertical
                    ),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                columns = GridCells.Fixed(gridColumnCount)
            ) {
                items(legendLabelList) {
                    Legend(legendsConfig, it)
                }
            }
        }
    }
}

@Composable
private fun Legend(config: LegendsConfig, legendLabel: LegendLabel) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(legendLabel.color)
                .size(config.colorBoxSize)
        )
        Spacer(modifier = Modifier.padding(config.spaceBWLabelAndColorBox))
        Text(
            text = legendLabel.name,
            style = config.textStyle,
            overflow = TextOverflow.Ellipsis
        )
    }
}

