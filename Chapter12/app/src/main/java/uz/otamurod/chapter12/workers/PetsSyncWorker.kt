package uz.otamurod.chapter12.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import java.io.IOException
import uz.otamurod.chapter12.data.PetsRepository

class PetsSyncWorker(
    appContext: Context,
    workerParams: WorkerParameters,
    private val petsRepository: PetsRepository
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            petsRepository.fetchRemotePets()
            Result.success()
        } catch (e: IOException) {
            Log.d("PetsSyncWorker", "Error fetching pets", e)
            Result.failure()
        }
    }
}