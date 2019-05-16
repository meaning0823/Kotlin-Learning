package meaing0823.kotlin_learning

object Example4Nullable {
    data class Person(val name: String, var isWorking: Boolean)

    fun function01() {
        val michael = if (System.currentTimeMillis() % 2 == 1L) Person("Michael", true) else null

        if (michael?.isWorking ?: false) "Is ${michael!!.name} working == ${michael.isWorking}"

        if (michael?.isWorking != null) "Is ${michael.name} working == ${michael.isWorking}"

        if (michael?.isWorking == true) "Is ${michael.name} working == ${michael.isWorking}"
    }
}