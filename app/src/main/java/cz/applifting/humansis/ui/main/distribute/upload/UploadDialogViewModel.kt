package cz.applifting.humansis.ui.main.distribute.upload

import androidx.lifecycle.MutableLiveData
import cz.applifting.humansis.model.db.SyncError
import cz.applifting.humansis.repositories.ErrorsRepository
import cz.applifting.humansis.ui.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Petr Kubes <petr.kubes@applifting.cz> on 27, November, 2019
 */
enum class Screen {
    MAIN,
    ERROR_INFO
}

class UploadDialogViewModel @Inject constructor(
    private val errorsRepository: ErrorsRepository
): BaseViewModel() {

    val currentScreenLD: MutableLiveData<Screen> = MutableLiveData()
    val syncErrorListLD: MutableLiveData<List<SyncError>> = MutableLiveData()

    init {
        currentScreenLD.value = Screen.MAIN

        launch {
            errorsRepository.getAll().collect {
                syncErrorListLD.value = it
            }
        }
    }

    fun changeScreen(screen: Screen) {
        currentScreenLD.value = screen
    }
}