package com.example.buyerapp.presenter.pincode

import com.example.buyerapp.core.framework.mvi.MviViewModel
import com.example.buyerapp.domain.usecase.GetUserInfoUseCase
import com.example.buyerapp.domain.usecase.LogoutUseCase
import com.example.buyerapp.domain.usecase.PinCheckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PinCodeViewModel @Inject constructor(
    val getUserInfoUseCase: GetUserInfoUseCase,
    val pinCheckUseCase: PinCheckUseCase,
    val logoutUseCase: LogoutUseCase
) : MviViewModel<PinCodeViewState, PinCodeEvent, PinCodeEffect>() {
    override fun onTriggerEvent(eventType: PinCodeEvent) {
        when(eventType) {
            is PinCodeEvent.GetUserInfo -> onGetUserInfo()
            is PinCodeEvent.PinCheck -> onPinChecked(eventType.pin)
            is PinCodeEvent.Logout -> onLogout()
        }
    }

    private fun onGetUserInfo() = safeLaunch {
        execute(getUserInfoUseCase(Unit)) {
            setState(PinCodeViewState(userInfo = it))
        }
    }

    private fun onPinChecked(pin: String) = safeLaunch {
        execute(pinCheckUseCase(pin)){
            effectChannel.trySend(PinCodeEffect.OnPinChecked)
        }
    }

    private fun onLogout() = safeLaunch {
        execute(logoutUseCase(Unit)){
            effectChannel.trySend(PinCodeEffect.OnLogout)
        }
    }
}