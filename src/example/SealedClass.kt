package example

import javax.annotation.processing.Messager

sealed class NetworkResult{
    data class Success(val data:String):NetworkResult()
    data class Error(val message: String , val code: Int):NetworkResult()
    object Loading : NetworkResult()
}
fun handleResult(result: NetworkResult){
    when ( result){
        is NetworkResult.Success -> {
            println("успех : ${result.data}")
        }
        is NetworkResult.Error->{
            println("обтшика ${result.code}: ${result.message}")
        }
        NetworkResult.Loading->{
            println("загрузка...")
        }
    }
}fun main(){
    val success = NetworkResult.Success("данные получены")
    val error = NetworkResult.Error("сервер не отвечает", 500)
    val loading = NetworkResult.Loading
    handleResult(success)
    handleResult(error)
    handleResult(loading)
}
