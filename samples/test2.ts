const s = new Set();

s.add("awa");
s.add("www");
s.add("zzz");

println(s);

const keys = s.keys();

while (true) {
    const next = keys.next();

    if (next.done) {
        break;
    } else {
        println(next.value);
    }
}

for (i = 0; i < s.size; i++) {
    println(i);
}