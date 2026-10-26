package com.example.a30daysofreading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysofreading.data.DataSource
import com.example.a30daysofreading.model.ReadingTip
import com.example.a30daysofreading.ui.theme._30DaysOfReadingTheme

@Composable
fun ReadingTipCard(readingTip: ReadingTip, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(top = 8.dp, start = 16.dp, bottom = 8.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(readingTip.imageRes),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .clip(MaterialTheme.shapes.small),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Text(
                text = "Day ${readingTip.dayNumber}",
                style = MaterialTheme.typography.labelSmall
            )

            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(readingTip.titleRes),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.weight(1f)
                )

                TipButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }

            if (expanded) {
                Text(
                    text = stringResource(readingTip.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

        }
    }
}

@Composable
fun TipButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess
            else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }

}

@Preview(showBackground = true)
@Composable
fun ReadingTipCardPreview() {
    _30DaysOfReadingTheme {
        ReadingTipCard(DataSource.readingTips[3])
    }
}