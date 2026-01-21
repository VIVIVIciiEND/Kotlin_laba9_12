package payment

fun main(){
    val processor = PaymentProcessor()
    val payments = listOf(
        Payment("4_111_111_11_111_111",1000,CardType.VISA),
        Payment("5_111_111_11_111_111",2000,CardType.MASTERCARD),
        Payment("2_111_111_11_111_111",1500,CardType.MIR),
        Payment("123456789",500,CardType.UNKNOWN),
        Payment("123",3000,CardType.VISA)
    )
    println("=== обработка платежей ===")
    payments.forEach{ payment ->
        println("\nплатеж ${payment.type} ${payment.card.take(4)}... , ${payment.sum} руб")
        val  result = processor.pay(payment)
        processor.show(result)
    }
    println("\n=== работа с enum===")
    val cardType = CardType.VISA
    println("Тип карты $cardType")
    println("порядковый номер ${cardType.ordinal}")
    println("все типы карт ${CardType.values().joinToString()}")
    val payment1 = Payment("4111111111111111" , 1000 , CardType.VISA)
    val payment2  = payment1.copy(type = CardType.MASTERCARD , sum = 2000)
    println("\n=== сравнение data class ")
    println("платеж 1 $payment1")
    println("платеж 2 $payment2")
    println("одинаковые ${payment1== payment2}")
}