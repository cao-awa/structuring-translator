import { world, system } from "@minecraft/server";

function countdown() {
    const players = world.getPlayers();

    players[0].onScreenDisplay.setTitle("Get ready!", {
        stayDuration: 220,
        fadeInDuration: 2,
        fadeOutDuration: 4,
        subtitle: "10",
    });

    let countdown = 10;

    const intervalId = system.runInterval(() => {
        countdown--;
        players[0].onScreenDisplay.updateSubtitle(countdown.toString());

        if (countdown == 0) {
            system.clearRun(intervalId);
        }
    }, 20);
}

println("???");

world.beforeEvents.itemUseOn.subscribe((event: ItemUseOnBeforeEvent) => {
    println("???");
    if (event.itemStack.typeId === "minecraft:diamond") {
        countdown();
    }
});
