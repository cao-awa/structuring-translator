import { world, system } from "@minecraft/server";

function countdown() {
    const players = world.getPlayers();

    players[0].runCommand("/say Hello Conium");
}

const context = world.beforeEvents.itemUseOn.subscribe((event) => {
    if (event.itemStack.typeId === "minecraft:stick") {
        event.source.runCommand("/say Hello Conium!");
    }
});

world.beforeEvents.itemUseOn.subscribe((event) => {
    if (event.itemStack.typeId === "minecraft:diamond") {
        event.source.runCommand("/say Bye Bedrock!");

        world.beforeEvents.itemUseOn.unsubscribe(context);
    }
});

const w = 1;