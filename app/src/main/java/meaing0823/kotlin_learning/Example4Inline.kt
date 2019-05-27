package meaing0823.kotlin_learning

object Example4Inline {
    inline fun returnRules(arg1: Char, t: String): Boolean {
        return when (arg1) {
            'o' -> t.indexOf('o') != -1
            else -> false
        }
    }

    inline fun ArrayList<String>.returnFilter(arg1: Char) = this.filter {
        returnRules(arg1, it)
    }.iterator()

    inline fun ArrayList<String>.returnAny(arg1: Char) = this.any {
        returnRules(arg1, it)
    }

    fun function01() {
        val list1 = ArrayList<String>()
        list1.add("one")
        list1.add("two")
        list1.add("three")

        val iterator: Iterator<String>  = list1.returnFilter('o')
        val any: Boolean                = list1.returnAny('o')
    }
}