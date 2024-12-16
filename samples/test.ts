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
    }, 20, abc, def);
}

world.beforeEvents.itemUseOn.subscribe((event) => {
    if (event.itemStack.typeId === "minecraft:stick") {
        countdown();
    }
});

const set = new Set();

set.add("awa");
set.add("www");
set.add("zzz");

println(set);

const keys = set.keys();

while (true) {
    const next = keys.next();

    if (next.done) {
        break;
    } else {
        println(next.value);
    }
}

for (i = 0; i < set.size; i++) {
    println(i);
}