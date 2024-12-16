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