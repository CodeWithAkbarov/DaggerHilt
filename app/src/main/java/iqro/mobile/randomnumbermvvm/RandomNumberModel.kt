package iqro.mobile.randomnumbermvvm

import kotlinx.coroutines.flow.flow
import java.util.*

/**
 *Created by Zohidjon Akbarov
 */
class RandomNumberModel {

    fun getRandomNumber() = flow {
        emit(RandomNumberResponse.Loading(true))
        kotlinx.coroutines.delay(1000)
        emit(RandomNumberResponse.Success(Random().nextInt(10000)))
    }

}