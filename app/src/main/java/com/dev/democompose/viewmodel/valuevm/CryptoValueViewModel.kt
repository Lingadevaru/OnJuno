package com.dev.democompose.viewmodel.valuevm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.democompose.repository.CryptoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoValueViewModel @Inject constructor(
    private val repository: CryptoRepository
): ViewModel(){

    private val _state = mutableStateOf(CryptoValueState())
    val state: State<CryptoValueState> = _state

    init {
        getCryptoValue()
    }

    private fun getCryptoValue() {
        viewModelScope.launch{
            val cryptoValue = repository.getValue()
            _state.value = CryptoValueState(cryptoValue = cryptoValue ?: null)
        }
    }
}