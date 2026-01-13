package modules

import resources.ResourceManager

class ResearchLab : OutpostModule("исследовательская лаборатория") {
    override fun performAction(manager: ResourceManager) {
        val minerals = manager.get("Minerals")
        if(minerals == null || minerals.amount < 30){
            println("недостаточно минералов для исследования")
            return
        }
        minerals.amount -=30
        println("лаборатория проводит исследование")
    }
}