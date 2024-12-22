package com.denofdevelopers.animals.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.denofdevelopers.animals.R
import com.denofdevelopers.animals.model.Animal
import com.denofdevelopers.animals.ui.theme.AnimalsTheme

@Composable
fun AnimalsHomeScreen() {

}

@Composable
fun AnimalCard(animal: Animal, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = animal.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium)),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(animal.image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img)
            )
            Text(
                text = animal.description,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
            Text(
                text = stringResource(R.string.animal_species, animal.species),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
            )
            Text(
                text = stringResource(R.string.animal_family, animal.family),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
            )
            Text(
                text = stringResource(R.string.animal_habitat, animal.habitat),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
            )
            Text(
                text = stringResource(R.string.animal_found, animal.placeWhereFound),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
            )
            Text(
                text = stringResource(R.string.animal_diet, animal.diet),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
            )
            Text(
                text = stringResource(R.string.animal_weight, animal.weightKg.toString()),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
            )
            Text(
                text = stringResource(R.string.animal_height, animal.heightCm.toString()),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small)),
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Start,
            )
        }
    }
}

@Composable
private fun AnimalsListScreen(
    animals: List<Animal>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(
            items = animals,
            key = { animal ->
                animal.id
            }
        ) { animal ->
            AnimalCard(animal = animal, modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading),
        modifier = modifier
    )
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(R.string.loading_failed)
        )
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimalCardPreview() {
    AnimalCard(
        Animal(
            176,
            "Lion",
            "Panthera leo",
            "Felidae",
            "Grasslands and Savannas",
            "Africa",
            "Carnivore",
            "The lion is a large and powerful wild cat known for its majestic appearance and social behavior.",
            190,
            120,
            ""
        )
    )
}

@Preview(showBackground = true)
@Composable
fun AmphibiansListScreenPreview() {
    AnimalsTheme {
        val mockData = List(10) {
           Animal(
                it,
                "Lion",
                "Panthera leo",
                "Felidae",
                "Grasslands and Savannas",
                "Africa",
                "Carnivore",
                "The lion is a large and powerful wild cat known for its majestic appearance and social behavior.",
                190,
                120,
                ""
            )
        }
        AnimalsListScreen(mockData, Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    AnimalsTheme {
        LoadingScreen(
            Modifier
                .fillMaxSize()
                .size(200.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    AnimalsTheme {
        ErrorScreen(
            {}, Modifier.fillMaxSize()
        )
    }
}