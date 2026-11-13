// import { world, system } from "@minecraft/server"

fun countdown() {
    val players = world.getPlayers()
    players[0].onScreenDisplay.setTitle("Get ready!", mutableMapOf("stayDuration" to 220, "fadeInDuration" to 2, "fadeOutDuration" to 4, "subtitle" to "10"))
    var countdown = 10
    val intervalId = system.runInterval(fun() {
        countdown--
        players[0].onScreenDisplay.updateSubtitle(countdown.toString())
        if (countdown == 0) {
            system.clearRun(intervalId)
        }
    }, 20)
}

println("???")
world.beforeEvents.itemUseOn.subscribe(fun(event: ItemUseOnBeforeEvent) {
    println("???")
    if (event.itemStack.typeId == "minecraft:diamond") {
        countdown()
    }
})
