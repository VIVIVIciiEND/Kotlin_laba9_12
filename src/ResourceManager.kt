class ResourceManager {
    private val resources = mutableListOf<OutpostResource>()
    fun add(resource: OutpostResource){
        resources.add(resource)
        println("добавлен ресурс ${resource.name}")
    }
    fun get(name:String):OutpostResource? {
        return resources.find { it.name == name}
    }
    fun printAll(){
        println("ресурсф базы")
        resources.forEach { println("${it.name} ${it.amount}") }
    }


}