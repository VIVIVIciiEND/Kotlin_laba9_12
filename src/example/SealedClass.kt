package example

import java.security.cert.CertPathValidatorException.Reason
import java.util.Objects
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
}
sealed class OrderStatus{
    object Created : OrderStatus()
    object Paid: OrderStatus()
    object Shipped : OrderStatus()
    data class Cancelled(val reason: String):OrderStatus()
}

fun handleOrder(status: OrderStatus){
    when(status){
        OrderStatus.Created-> println("заказ создан")
        OrderStatus.Paid-> println("заказ оплачен")
        OrderStatus.Shipped-> println("заказ отправлен")
        is OrderStatus.Cancelled -> println("отменент ${status.reason}")
    }
}
fun main(){
    handleOrder(OrderStatus.Created)
    handleOrder(OrderStatus.Paid)
    handleOrder(OrderStatus.Shipped)
    handleOrder(OrderStatus.Cancelled("нет товара на складе"))
//    val success = NetworkResult.Success("данные получены")
//    val error = NetworkResult.Error("сервер не отвечает", 500)
//    val loading = NetworkResult.Loading
//    handleResult(success)
//    handleResult(error)
//    handleResult(loading)
}
