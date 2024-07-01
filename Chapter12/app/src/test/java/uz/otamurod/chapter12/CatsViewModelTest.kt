package uz.otamurod.chapter12

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import uz.otamurod.chapter12.data.Cat
import uz.otamurod.chapter12.data.PetsRepository
import uz.otamurod.chapter12.viewmodel.PetsViewModel

@OptIn(ExperimentalCoroutinesApi::class)
class CatsViewModelTest {
    private val petsRepository = mockk<PetsRepository>(relaxed = true)
    private lateinit var petsViewModel: PetsViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        petsViewModel = PetsViewModel(petsRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testGetPets() = runTest {
        val cats = listOf(
            Cat(
                id = "1",
                owner = "John Doe",
                tags = listOf("cute", "fluffy"),
                createdAt = "2021-07-01T00:00:00.000Z",
                updatedAt = "2021-07-01T00:00:00.000Z",
                isFavorite = false
            )
        )
        // Given
        coEvery { petsRepository.getPets() } returns flowOf(cats)
        // When
        petsViewModel.getPets()
        coVerify { petsRepository.getPets() }
        // Then
        val uiState = petsViewModel.petsUIState.value
        assertEquals(cats, uiState.pets)
    }
}