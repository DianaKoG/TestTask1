interface Animal {
    val name: String
    fun makeNoise(): String
} // интерфейс животного
abstract class HomeAnimal(override val name: String): Animal {
    override fun makeNoise(): String = "Звук домашнего животного"
} // абстрактный класс домашних животных
abstract class WildAnimal(override val name: String): Animal {
    override fun makeNoise(): String = "Звук дикого животного"
} // абстрактный класс диких животных
class Cat(name: String): HomeAnimal(name) {
    override fun makeNoise(): String = "Мяу"
} // класс Кошка
class Dog(name: String): HomeAnimal(name) {
    override fun makeNoise(): String = "Гав"
} // класс Собака
class Tiger(name: String): WildAnimal(name) {
    override fun makeNoise(): String = "Ррр"
} // класс Тигр
class Snake(name: String): WildAnimal(name) {
    override fun makeNoise(): String = "Шшш"
} // класс Змея
class Raccon(name: String): WildAnimal(name) //демонстрация использования абстрактного класса (не знаем звук животного)
class Veterinarian {
    fun treatment(animal: Animal) {
        println("Началось лечение животного с кличкой ${animal.name}")
        println("Звук животного: ${animal.makeNoise()}")
        println("Лечение закончилось")
        println("--------------------")
    }
} // класс ветеринара

fun main(){
    val vetdoc = Veterinarian() // объект класса ветеринара
    val animals = sequenceOf<Animal>(
        Cat("Толик"),
        Dog("Шарик"),
        Tiger("Царь"),
        Snake("Северус"),
        Raccon("Чистюля")
    ) //последовательность принимаемых животных

    animals.forEach { vetdoc.treatment(it) }
} // основной метод для вызова объекта класса ветеринара