package uz.otamurod.chapter12

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import uz.otamurod.chapter12.data.Cat
import uz.otamurod.chapter12.views.PetListItem

class PetListItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testPetListItem() {
        with(composeTestRule) {
            setContent {
                PetListItem(
                    cat = Cat(
                        id = "1",
                        owner = "John Doe",
                        tags = listOf("cute", "fluffy"),
                        createdAt = "2021-07-01T00:00:00.000Z",
                        updatedAt = "2021-07-01T00:00:00.000Z",
                        isFavorite = false
                    ),
                    onPetClicked = { },
                    onFavoriteClicked = {})
            }
            // Assertions using tags
            onNodeWithTag("PetListItemCard").assertExists()
            onNodeWithTag("PetListItemColumn").assertExists()
            onNodeWithTag("PetListItemFavoriteIcon").assertExists()
            // Assertions using text
            onNodeWithText("fluffy").assertIsDisplayed()
            onNodeWithContentDescription("Favorite").assertIsDisplayed()
            onNodeWithContentDescription("Cute cat").assertIsDisplayed()
            // Actions
            onNodeWithTag("PetListItemFavoriteIcon").performClick()
        }
    }
}