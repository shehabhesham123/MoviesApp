package com.example.moviesapp.core.interactor

import androidx.compose.runtime.MutableState
import com.example.moviesapp.core.viewstate.ViewState
import com.example.moviesapp.feature.movies.viewstate.Failure
import com.example.moviesapp.feature.movies.viewstate.Success
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * super class for any interactions
 */
abstract class UserCase {
    /**
     * the interaction will override what will do (Process)
     */
    abstract suspend fun run(coroutineScope: CoroutineScope, stateFlow: MutableState<ViewState>)

    /**
     * execute the action in reduce the result (viewState)
     */
    operator fun invoke(coroutineScope: CoroutineScope, stateFlow: MutableState<ViewState>) {
        coroutineScope.launch {
            run(coroutineScope, stateFlow)
        }
    }

    protected fun getState(data: Any?, errorMessage: String?): ViewState {
        return if (data != null) {
            Success(data)
        } else {
            Failure(errorMessage)
        }
    }
}