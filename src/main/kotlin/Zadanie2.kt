
fun verifyStr(str:String, alphabet:Array<Char>): Boolean {
    for (char in str) {
        if (!alphabet.contains(char)) return false
    }

    return true
}

fun inputStr(msg:String): String {
    var ret:String
    val alphabet = Array(32) { (it + 1072).toChar() }

    while (true) {
        print(msg)
        ret = readln()

        if (ret.isEmpty()) {
            println("Строка не может быть пустой")
            continue
        }

        if (!verifyStr(ret, alphabet)) {
            println("Строка должна содержать только эти символы: ")
            alphabet.forEach { print(it) }
            println()
            continue
        }

        return ret
    }
}

private fun encodePair(first: Char, second: Char): String {
    var ret: String = (first.code - 1071 + (second.code - 1072) * 32).toString()

    for (i in ret.length until 3) {
        ret = "0$ret"
    }

    return ret
}
// a - 1072
fun main() {
    val inputStrs = inputStr("Привет, введи буквы ")

    for (i in 0 until inputStrs.length - 1) {
        print(encodePair(inputStrs[i], inputStrs[i + 1]) + " ")
    }
}
