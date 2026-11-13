// A deliberately broad ES6 + TypeScript sample used to exercise the lexer, the parser and the
// Kotlin script emitter in one pass.
// import defaultExport, { named as renamed, other } from "./module"
// import * as ns from "./ns"
// import "./side-effect" // side effect only
interface Shape<T> {
    val name: String
    fun area(scale: Double): Double
    val tag: T
}
typealias Pair<A, B> = MutableList<Any?>
typealias Handler = (String?, Any?) -> Unit

typealias Maybe<T> = T?

enum class Color(val value: Any?) {
    Red(null),
    Green(2),
    Blue("blue"),
}
enum class Flag(val value: Any?) {
    On(1),
    Off(0),
}

object Geometry {
    val origin = mutableMapOf("x" to 0, "y" to 0)
    fun distance(ax: Double, ay: Double): Double {
        return Math.sqrt(ax * ax + ay * ay)
    }
}

abstract class BaseShape<T> : Shape<T> {
    val name: String? = "base"
    var tag: T? = null
    var secret: String? = null
    var hidden: Any? = 0
    constructor(name: String, tag: T) {
        this.name = name
        this.tag = tag
        BaseShape.count += 1
    }
    abstract fun area(scale: Double): Double
    var label: Any?
        get() {
            return "${this.name}:${BaseShape.count}"
        }
        set(value) {
            this.secret = value
        }
    var describe: (String?) -> String = { prefix: String -> "${prefix} ${this.name}" }
    companion object {
        var count: Any? = 0
        fun create<U>(tag: U): BaseShape<U> {
            return object : BaseShape<U>("anon", tag) {
                fun area(): Double {
                    return 0
                }
            }
        }
    }
}
class Circle : BaseShape<Double>() {
    var radius: Double? = null
    constructor(radius: Double) {
        super("circle", radius)
        this.radius = radius
    }
    fun area(scale: Double = 1): Double {
        return Math.PI * this.radius * this.radius * scale
    }
}
fun compose<A, B, C>(f: (B?) -> C, g: (A?) -> B): (A?) -> C {
    return { a: A -> f(g(a)) }
}

// overload fun overloaded(value: String): String

// overload fun overloaded(value: Double): Double

fun overloaded(value: Any?): Any? {
    return value
}

val arrowBlock = fun(a: Double, b: Double): Double {
    val sum = a + b
    return sum * 2
}
val arrowExpr = { a: Double -> a * 3 }
val single = { x: Any? -> x + 1 }
val noArgs = { "constant" }
var auto: String? = null
var inferred = 42
var legacy = true
val template = "head ${inferred + 1} middle ${auto ?: "none"} tail"
val array = mutableListOf(1, 2, 3)
val nested = mutableListOf(mutableListOf(1), mutableListOf(2, mutableListOf(3)))
val spread = mutableListOf(*array, 4)
val `object` = (mutableMapOf("a" to 1, "b" to "two", "nested" to mutableMapOf("deep" to true), "array" to array) + spread)
val computedKey = mutableMapOf("k" + 1 to 1, inferred to 2)
val withMethod = object {
    var value = 1
    fun double(): Any? {
        return this.value * 2
    }
}
val methods = object {
    val size: Any?
        get() {
            return 0
        }
    fun run() { }
}
val regex = Regex("ab+c", setOf(RegexOption.IGNORE_CASE))
val json = JSON.parse("{}")
val asserted = auto
val satisfied = mutableMapOf("id" to 1)
val chained = `object`?.nested?.deep
val nullish = auto ?: "fallback"
val ternary = if (inferred > 0) "positive" else "other"
val bitwise = (inferred and 0xff) or 1
val shifted = inferred shl 2
val power = Math.pow(2, 10)
val inOp = "a" in `object`
val typeOf = (inferred)::class.simpleName == "number"

fun controlFlow(items: MutableList<Double>): Unit {
    var total = 0
    var i = 0
    while (i < items.size) {
        total += items[i]
        if (total > 10) {
            break
        } else if (total > 5) {
            continue
        } else {
            total -= 1
        }
        i++
    }
    for (item in items) {
        total += item
    }
    for (key in `object`) {
        println(key)
    }
    while (total > 0) {
        total--
    }
    do {
        total++
    } while (total < 3)
    when (total) {
        0 -> run case0@ {
            println("zero")
            return@case0
        }
        1 -> { }
        2 -> run case1@ {
            println("small")
            return@case1
        }
        else -> run case2@ {
            println("large")
            return@case2
        }
    }
    try {
        throw RuntimeException("boom")
    } catch (error: Throwable) {
        System.err.println(error)
    } finally {
        println("done")
    }
    outer@ for (i in items) {
        for (j in items) {
            if (i == j) {
                continue@outer
            }
        }
    }
}

fun loadAll(urls: MutableList<String>): MutableList<String> {
    val results: MutableList<String> = mutableListOf()
    urls.map(fun(url: Any?) {
        val response = /* not translatable: call to 'fetch' */ fetch(url).await()
        results.add(response.text().await())
    }).awaitAll()
    return results
}

fun counter(limit: Double): Sequence<Any?> = sequence {
    var i = 0
    while (i < limit) {
        yield(i)
        i++
    }
}
// export default
class Registry {
    val entries: MutableMap<String, Any?> = mutableMapOf<String, Any?>()
    fun register(key: String, value: Any?): Registry {
        this.entries[key] = value
        return this
    }
}
println(listOf("translated", template.length).joinToString(" "))
