package tgo1014.timeof.presentation.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tgo1014.timeof.domain.models.WhateverDomain
import tgo1014.timeof.domain.usecases.GetWhateverFlowListUseCase
import tgo1014.timeof.domain.usecases.UpsertWhateverUseCase
import tgo1014.timeof.presentation.models.WhateverPresentation
import tgo1014.timeof.presentation.models.mappers.toPresentation
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWhateverFlowListUseCase: GetWhateverFlowListUseCase,
    private val upsertWhateverUseCase: UpsertWhateverUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()

    init {
        observeWhateverList()
    }

    fun createWhatever(name: String, duration: Int) = viewModelScope.launch {
        upsertWhateverUseCase(WhateverDomain(name = name, duration = duration.seconds))
    }

    private fun observeWhateverList() {
        getWhateverFlowListUseCase()
            .onEach { list ->
                _state.update { state ->
                    state.copy(whateverList = list.map { it.toPresentation() })
                }
            }
            .launchIn(viewModelScope)
    }

    data class State(
        val whateverList: List<WhateverPresentation> = emptyList()
    )

}