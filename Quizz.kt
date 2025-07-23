import kotlin.random.Random

data class Question(
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

fun main() {
    val questions = listOf(
        Question(
            "What is the capital of France?",
            listOf("Berlin", "Madrid", "Paris", "Rome"),
            2
        ),
        Question(
            "Which planet is known as the Red Planet?",
            listOf("Venus", "Mars", "Jupiter", "Saturn"),
            1
        ),
        Question(
            "What is the largest mammal?",
            listOf("Elephant", "Blue Whale", "Giraffe", "Great White Shark"),
            1
        ),
        Question(
            "In which year did the first man walk on the moon?",
            listOf("1965", "1969", "1972", "1980"),
            1
        ),
        Question(
            "What is the chemical symbol for Gold?",
            listOf("Go", "Ag", "Au", "Gd"),
            2
        )
    )

    var score = 0
    val shuffledQuestions = questions.shuffled(Random)

    println("Welcome to the Kotlin Quiz Game!")
    println("--------------------------------")

    for ((index, question) in shuffledQuestions.withIndex()) {
        println("Question ${index + 1}: ${question.questionText}")
        question.options.forEachIndexed { i, option ->
            println("${i + 1}. $option")
        }

        var userAnswer: Int? = null
        while (userAnswer == null) {
            print("Your answer (1-${question.options.size}): ")
            try {
                val input = readLine()
                userAnswer = input?.toInt()
                if (userAnswer !in 1..question.options.size) {
                    println("Invalid input. Please enter a number between 1 and ${question.options.size}.")
                    userAnswer = null
                }
            } catch (e: NumberFormatException) {
                println("Invalid input. Please enter a number.")
            }
        }

        if (userAnswer - 1 == question.correctAnswerIndex) {
            println("Correct!")
            score++
        } else {
            println("Wrong! The correct answer was ${question.options[question.correctAnswerIndex]}")
        }
        println()
    }

    println("Quiz Over!")
    println("Your final score is: $score/${shuffledQuestions.size}")
}
