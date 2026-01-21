package payment

import kotlin.time.measureTime

class PaymentProcessor{
    private val validator = PaymentValidator()
    fun pay(payment: Payment): PaymentResult{
        if( !validator.check(payment)){
            return PaymentResult.Error("ошибка валидации")
        }
        return when (payment.type){
            CardType.VISA -> PaymentResult.Success("VISA${System.currentTimeMillis()}")
            CardType.MASTERCARD-> PaymentResult.Processing
            CardType.MIR -> PaymentResult.Success("MIR ${System.currentTimeMillis()}")
            CardType.UNKNOWN -> PaymentResult.Error("неизвестный тип карты")
        }
    }
    fun show(result: PaymentResult) {
        when (result) {
            is PaymentResult.Success -> println("успех ${result.id}")
            is PaymentResult.Error -> println("ошибка ${result.reason}")
            PaymentResult.Processing -> println(" обработке")
        }
    }
}

