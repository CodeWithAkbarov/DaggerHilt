package iqro.mobile.randomnumbermvvm

/**
 *Created by Zohidjon Akbarov
 */
sealed class RandomNumberResponse{
    data class Loading(val isLoading:Boolean):RandomNumberResponse()
    data class Success(val number:Int):RandomNumberResponse()
    data class Failure(val errorMessage:String):RandomNumberResponse()
}
