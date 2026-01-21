package modules

import java.security.Principal

fun handleModuleResult(result: ModuleResult){
    when ( result){
        is ModuleResult.Success ->
            println("${result.message}")
        is ModuleResult.ResourceProduced ->
            println("${result.resourceName} + ${result.amount}")
        is ModuleResult.NotEnoughResources ->
            println(
                "${result.resourceName} " + "${result.required} ${result.available}"
            )
        is ModuleResult.Error ->
            println("${result.reason}")
    }
}
