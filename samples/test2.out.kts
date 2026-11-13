val s = mutableSetOf()
s.add("awa")
s.add("www")
s.add("zzz")
println(s)
val keys = s.keys()
while (true) {
    val next = keys.next()
    if (next.done) {
        break
    } else {
        println(next.value)
    }
}
i = 0
while (i < s.size) {
    println(i)
    i++
}
