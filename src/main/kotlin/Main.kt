

var technology: String = "";
var screenName: String = "";

fun main(args: Array<String>) {

    technology = args[0];
    screenName = args[1];

    Generators().removeSpecialCharacters()
    Generators().nameGenerator()
}


class Generators() {

    fun removeSpecialCharacters() {
        screenName = screenName.filter { !it.isDigit() }
        val regex = Regex("[^A-Za-z ]")
        screenName = regex.replace(screenName, "")

    }

    fun getiOSName() : String {
        return screenName.replace(" ", "_").snakeToUpperCamelCase()
    }

    fun getAndroidName() : String {
        return screenName.replace(" ", "_")
    }

    fun getFlutterName() : String {
        return screenName.replace(" ", "_").lowercase()
    }

    private val snakeRegex = "_[a-zA-Z]".toRegex()

    // String extensions
    fun String.snakeToLowerCamelCase(): String {
        return snakeRegex.replace(this) {
            it.value.replace("_","")
                .uppercase()
        }
    }

    fun String.snakeToUpperCamelCase(): String {
        return this.snakeToLowerCamelCase().capitalize()
    }


    fun nameGenerator() {
        when(technology) {
            "iOS" -> println("** Generated iOS Name ** \nView Name :-> ${getiOSName()} \nViewModel Name :-> ${getiOSName()}ViewModel")
            "Android" -> println("** Generated Android Name ** \nLayout Name :-> activity_${getAndroidName()} \nController Name :-> ${getiOSName()}Activity \nModel Name :-> ${getiOSName()}Model")
            "Flutter" -> println("** Generated Flutter Name ** \nLayout Name :-> ${getFlutterName()} \nController Name :-> ${getFlutterName().substringBefore("_")}_controller \nModel Name :-> ${getFlutterName().substringBefore("_")}_model")
            else -> println("Something went wrong!")
        }
    }
}