val m1 = mutableMapOf()
val m2 = mutableMapOf<String, Any?>()
val m3 = mutableMapOf<String, Any?>(1, 2)
val m4 = mutableMapOf(1)
val m5 = foo<String>(1)
val m6 = mutableListOf<String>()
val m7 = mutableSetOf<Double>()
val date = Date(0)
val anon = object : Base<String>("named", 2) {
    fun run(): Unit { }
}
