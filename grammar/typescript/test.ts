const set: Set<String> = new Set<String>;

set.add("awa");
set.add("www");
set.add("zzz");

println(set);

while (true) {
    const next = set.keys().next();

    if (next.done) {
        break;
    } else {
        println(next.value);
    }
}