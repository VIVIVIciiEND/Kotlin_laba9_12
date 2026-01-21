package example

import java.security.Principal
import javax.annotation.processing.Messager

object GameSession{
    init {
        println("игровая сессия сооздана")
    }
    var isActive: Boolean = false
    fun start(){
        isActive = true
        println("игра началась")
    }
    fun end(){
        isActive = false
        println("игра завершена")
    }
}
object Logger{
    var count = 0
    fun log(message: String){
        count++
        println("[$count] $message")
    }
}
object AppSettings{
    val version = "1.0.0"
    var isDarkMode = true
    fun toggleTheme(){
        isDarkMode = !isDarkMode
    }
}
fun checkTheme(){
    if(AppSettings.isDarkMode){
        println("темная тема велючена")
    }
}
object Colors {
    const val RED = "FF0000"
    const val GREEN ="00FF00"
    const val BLUE = "0000FF"
}

fun main(){
//    val handler = object {
//        val name = "обработчик"
//        fun handle(){
//            println("обрабатываю..")
//        }
//    }
//    println(handler.name)
//    handler.handle()
//    println(Colors.RED)
//    println(Colors.GREEN)
//    println(Colors.BLUE)
//    Logger.log("первое сообщение")
//    Logger.log("второе сообщение")
//    val logger1 = Logger
//    val logger2 = Logger
//    println(logger1===logger2)
//    println("программа запущена")
//    println("проверяем состояние , но не трогаем GaneSession")
//    println("теперь запкскаем игру")
//    GameSession.start()
//    println("проверяем состояние еще раз")
//    println("активна ли сессия ${GameSession.isActive}")
}
