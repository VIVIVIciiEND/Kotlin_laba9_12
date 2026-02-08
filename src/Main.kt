import modules.EnergyGenerator
import modules.ResearchLab
import resources.OutpostResource
import resources.ResourceManager

fun main(){
    val manager = ResourceManager()
    val minerals = OutpostResource(1,"Minerals",300)
    val gas = OutpostResource(2, "Gas" , 100)
    manager.add(minerals)
    manager.add(gas)
    manager.printAll()
    val bonus = minerals.copy(amount = minerals.amount + 50)
    println("копия минералов с бонусом $bonus")
    manager.add(OutpostResource(1, " Minerals" , 120))
    manager.add(OutpostResource(2,"Gas",40))
    val generator = EnergyGenerator()
    val lab = ResearchLab()
    generator.performAction(manager)
    lab.performAction(manager)
    println()
    manager.printAll()
    val loadedResource = FileStorage.load()
    loadedResource.forEach { manager.add(it)}
    if (loadedResource.isEmpty()){
        manager.add(OutpostResource(1,"Minerals",300))
        manager.add(OutpostResource(2,"Gas",100))

    }
    FileStorage.save(manager.getAll())
}
