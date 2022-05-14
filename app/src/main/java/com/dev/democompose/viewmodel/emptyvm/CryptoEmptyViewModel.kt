package com.dev.democompose.viewmodel.emptyvm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.democompose.repository.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoEmptyViewModel @Inject constructor(
    private val repository: CryptoRepository
): ViewModel(){

    private val _state = mutableStateOf(CryptoEmptyState())
    val state: State<CryptoEmptyState> = _state

    init {
        getCryptoEmpty()
    }

    private fun getCryptoEmpty() {
        viewModelScope.launch{
            val cryptoEmpty = repository.getEmpty()
            _state.value = CryptoEmptyState(cryptoEmpty = cryptoEmpty ?: null)
        }
    }
}