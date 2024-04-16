package com.example.moviesapp.core.interactor

import com.example.moviesapp.core.viewstate.ViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * super class for any interactions
 */
abstract class UserCase {
    /**
     * the interaction will override what will do (Process)
     */
    abstract fun run(coroutineScope: CoroutineScope, stateFlow: MutableStateFlow<ViewState>)

    /**
     * execute the action in reduce the result (viewState)
     */
    operator fun invoke(coroutineScope: CoroutineScope, stateFlow: MutableStateFlow<ViewState>) {
        run(coroutineScope, stateFlow)
    }
}