package uz.otamurod.chapter08.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import uz.otamurod.chapter08.data.Cat
import uz.otamurod.chapter08.navigation.ContentType
import uz.otamurod.chapter08.viewmodel.PetsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PetsScreen(
    onPetClicked: (Cat) -> Unit,
    contentType: ContentType,
) {
    val petsViewModel: PetsViewModel = koinViewModel()
    val petsUIState by petsViewModel.petsUIState.collectAsStateWithLifecycle()
    PetsScreenContent(
        modifier = Modifier
            .fillMaxSize(),
        onPetClicked = onPetClicked,
        contentType = contentType,
        petsUIState = petsUIState,
        onFavoriteClicked = {
            petsViewModel.updatePet(it)
        }
    )
}