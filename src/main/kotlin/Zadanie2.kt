fun verifyStr(str:String, alphabet: String): Boolean {
    for (char in str) {
        if (!alphabet.contains(char)) return false
    }

    return true
}

fun inputStr(msg:String, alphabet: String): String {
    var ret:String

    while (true) {
        print(msg)
        ret = readln()

        if (ret.isEmpty()) {
            println("Строка не может быть пустой")
            continue
        }

        if (!verifyStr(ret, alphabet)) {
            println("Строка должна содержать только эти символы: ")
            println(alphabet)
            continue
        }

        break
    }

    if (ret.length % 2 == 1) {
        ret += "а"
    }

    return ret
}

fun addZeroes(str: String, len: Int): String {
    var ret = str

    for (i in str.length until len) {
        ret = "0$ret"
    }

    return ret
}

fun product(a1: Array<Char>, a2: Array<Char>): List<Pair<Char, Char>> {
    val ret = mutableListOf<Pair<Char, Char>>()

    for (i in a1) {
        for (j in a2) {
            ret.add(Pair(i, j))
        }
    }

    return ret
}
private const val CHARS = 31
fun encode(fst: Char, snd: Char, cols: Array<Char>, rows: Array<Char>) = addZeroes(
    (cols.indexOf(fst) + 1 + rows.indexOf(snd) * CHARS).toString(),
    3
)

fun decode(num: String, cols: Array<Char>, rows: Array<Char>): String {
    val n = num.toInt() - 1
    val snd = cols[n / CHARS]
    val fst = rows[n % CHARS]

    return "$fst$snd"
}

fun main() {
    val alphabet = "абвгдежзиклмнопрстуфхцчшщъыьэюя"

    val rows = Array(CHARS) { alphabet[it] }
    val cols = rows

    val inputStrs = inputStr("Привет, введи буквы ", alphabet)
    val encodeMode = inputInt("Использовать типовую таблицу (0) или генерировать случайную (1)? ", 0, 1)

    if (encodeMode == 1) {
        println("Генерация случайной таблицы...")
        rows.shuffle()
        cols.shuffle()
    }

    var counter = 0
    for (p in product(Array(CHARS) { alphabet[it] }, Array(CHARS) { alphabet[it] })) {
        print("${encode(p.second, p.first, cols, rows)} ")
        counter++
        if (counter >= CHARS) {
            counter = 0
            println()
        }
    }

    println("Изначальный текст: ")
    counter = 0
    while (counter < inputStrs.length) {
        print("${inputStrs[counter]}${inputStrs[counter + 1]} ")
        counter += 2
    }
    println()

    var out = ""
    var i = 0
    while (i < inputStrs.length) {
        out += "${encode(inputStrs[i], inputStrs[i + 1], cols, rows)} "
        i += 2
    }
    out = out.substring(0 until out.length - 1)

    println("Зашифрованный текст: ")
    println(out)

    println("Расшифрованный текст: ")
    for (n in out.split(" ")) {
        print("${decode(n, cols, rows)} ")
    }
}
