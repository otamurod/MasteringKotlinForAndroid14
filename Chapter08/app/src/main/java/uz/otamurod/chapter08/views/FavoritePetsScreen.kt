package uz.otamurod.chapter08.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import uz.otamurod.chapter08.data.Cat
import uz.otamurod.chapter08.viewmodel.PetsViewModel

@Composable
fun FavoritePetsScreen(
    onPetClicked: (Cat) -> Unit
) {
    val petsViewModel: PetsViewModel = koinViewModel()
    LaunchedEffect(Unit) {
        petsViewModel.getFavoritePets()
    }
    val pets by petsViewModel.favoritePets.collectAsStateWithLifecycle()

    if (pets.isEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "No Favorite Pets")
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(pets) { pet ->
                PetListItem(
                    cat = pet,
                    onPetClicked = onPetClicked,
                    onFavoriteClicked = {
                        petsViewModel.updatePet(it)
                    }
                )
            }
        }
    }
}