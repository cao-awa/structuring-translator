val set = Set();
set.add("awa");
set.add("www");
set.add("zzz");
println(set);
while (true) {
    val next = set.keys();
    if (next.done) {
        var break: Any? = null;
    } else {
        println(next.value);
    }
}