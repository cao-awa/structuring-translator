import { world, system } from "@minecraft/server";

function countdown() {
    const players = world.getPlayers();

    players[0].runCommand("/say Hello Conium");
}

world.beforeEvents.itemUseOn.subscribe((event) => {
    if (event.itemStack.typeId === "minecraft:stick") {
        world.getPlayers()[0].runCommand("/say Hello Conium");
    }
});