// Typescript import: [world, system, DimensionLocation] from "@minecraft/server"
fun countdown(targetLocation:DimensionLocation){
    val players=world.getPlayers();
    players[0].onScreenDisplay.setTitle(
        "Get ready!",
        /* NOT IMPLIED: anonymous object
            stayDuration:220,
            subtitle:"10",
            fadeOutDuration:4,
            fadeInDuration:2,
        */
        Any(),
    );
    var countdown=10;
    val intervalId=system.runInterval(
        {
            countdown--;
            players[0].onScreenDisplay.updateSubtitle(countdown.toString(),);
            if(countdown==0){
                system.clearRun(intervalId,);
            }
        },
        20,
    );
}
