package example

import kotlin.properties.Delegates

class UserProfile(initialName : String , initialEmail : String ){
    var name : String by Delegates.observable(initialName){
        _,old , new ->
        println("имя изменено $old -> $new")
    }
    var email : String by Delegates.observable(initialEmail){
            _,old , new ->
        println("почта изменено $old -> $new")
    }
    val avatar : String by lazy {
        println("закружаем аватар для $name ...")
        "avatar_of_$name.png"
    }
}

fun main(){
    println("Создаем профиль пользователя")
    val user = UserProfile("Алиса" , "alice@example.com")
    println("\nимя ${user.name}")
    println("email ${user.email}")

    println("\nобращяумся к автору впервые")
    println("файл автора ${user.avatar}")

    println("\nобращаемся к аватфру снова (должен бять взят из кэша")
    println("Файл аватара ${user.avatar}")

    println("\nменяем почту")
    user.email ="alice_new@example.org"

    println("\nменяем имя")
    user.name = "Алиса К."
}
