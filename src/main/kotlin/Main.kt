import java.awt.Color
import kotlin.random.Random

fun inputInt(msg:String, min:Int? = null, max:Int? = null): Int {
    var ret:Int?

    while (true) {
        print(msg)
        ret = readln().toIntOrNull()

        if (ret == null) {
            println("Неверный ввод")
            continue
        }

        if (min != null && ret < min) {
            println("Число должно быть больше или равно $min")
            continue
        }

        if (max != null && ret > max) {
            println("Число должно быть меньше или равно $max")
            continue
        }

        return ret
    }
}
//1 - камень 2 - ножницы 3 - бумага
fun main(args: Array<String>) {

    var dvizhenie = inputInt(" Введите  1 - Камень 2 - Ножницы 3 - Бумага: ", 1, 3)

    if (dvizhenie == 1) {
        var random = (1..3).random()
        if (random == 1) {
            println("Ничья у пк камень")
        }
        if (random == 2) {
            println("Победа у пк ножницы")
        }
        if (random == 3) {
            println("Поражение у пк бумага")

                }

            }
    if (dvizhenie == 2) {
        var random = (1..3).random()
        if (random == 1) {
            println("Поражение у пк камень ")
        }
        if (random == 2) {
            println("Ничья у пк ножницы")
        }
        if (random == 3) {
            println("Победа у пк бумага")

        }
    }
        if (dvizhenie == 3) {
            var random = (1..3).random()
            if (random == 1) {
                println("Победа у пк камень")
            }
            if (random == 2) {
                println("Поражение у пк ножницы")
            }
            if (random == 3) {
                println("Ничья у пк бумага")

            }

    }
        }
