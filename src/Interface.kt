interface Movable{
    var speed : Int
    val model : String
    val number : String
    fun move()
    fun stop(){
        println("останавливаемся")
    }
}
class Car(override val model:String , override val number : String) : Movable{
    override var speed = 60
    override fun move() {
        println("Едем на машине co скоростью $speed")
    }
}
class Aircraft(override val model:String , override val number : String) : Movable{
    override var speed = 600
    override fun move(){
        println("летим на самолете со скростью $speed")
    }
    override fun stop() = println("приземляемся")
}
fun travel ( obj : Movable) = obj.move()
interface Worker{
    fun work()
}
interface Student{
    fun study()
}

class WorkingStudent(val name: String) : Worker , Student{
    override fun work() = println("$name рфботает")
    override fun study()= println("$name учится" )
}
interface VideoPlayable{
    fun play()  = println("Play video")
}
interface AudioPlayable{
    fun play() = println("Play audio")
}
class MadialPlayer : VideoPlayable , AudioPlayable {
    override fun play() {
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}
fun main(){
    val player = MadialPlayer()
    player.play()
    val car = Car("Lada" , "134Lad")
    val aircraft = Aircraft("Boeing" , "737")
//    val pavel = WorkingStudent("Pavel")
//    pavel.work()
//    pavel.study()
//    val car : Movable = Car()
//    val aircraft : Movable = Aircraft()
//    travel(car)
//    travel(aircraft)
//    aircraft.move()
//    aircraft.stop()
}