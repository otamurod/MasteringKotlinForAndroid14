package uz.otamurod.chapter12

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import uz.otamurod.chapter12.data.CatDao
import uz.otamurod.chapter12.data.CatDatabase
import uz.otamurod.chapter12.data.CatEntity

@RunWith(AndroidJUnit4::class)
class CatsDaoTest {
    private lateinit var database: CatDatabase
    private lateinit var catDao: CatDao

    @Before
    fun createDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            CatDatabase::class.java
        ).allowMainThreadQueries().build()
        catDao = database.catDao()
    }

    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    fun testInsertAndReadCat() = runTest {
        // Given a cat
        val cat = CatEntity(
            id = "1",
            owner = "John Doe",
            tags = listOf("cute", "fluffy"),
            createdAt = "2021-07-01T00:00:00.000Z",
            updatedAt = "2021-07-01T00:00:00.000Z",
            isFavorite = false
        )
        // Insert the cat to the database
        catDao.insert(cat)
        // Then the cat is in the database
        val cats = catDao.getCats()
        assert(cats.first().contains(cat))
    }

    @Test
    fun testAddCatToFavorites() = runTest {
        // Given a cat
        val cat = CatEntity(
            id = "1",
            owner = "John Doe",
            tags = listOf("cute", "fluffy"),
            createdAt = "2021-07-01T00:00:00.000Z",
            updatedAt = "2021-07-01T00:00:00.000Z",
            isFavorite = false
        )
        // Insert the cat to the database
        catDao.insert(cat)
        // Favorite the cat
        catDao.update(cat.copy(isFavorite = true))
        // Assert that the cat is in the favorite list
        val favoriteCats = catDao.getFavoriteCats()
        assert(
            favoriteCats.first().contains(
                cat.copy(
                    isFavorite = true
                )
            )
        )
    }
}