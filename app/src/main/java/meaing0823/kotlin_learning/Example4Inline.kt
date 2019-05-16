package meaing0823.kotlin_learning

object Example4Inline {
    inline fun returnRules(arg1: Int, t: String): Boolean {
        return when (arg1) {
            0 -> t.indexOf('o') != -1
            else -> false
        }
    }

    inline fun ArrayList<String>.returnFilter(arg1: Int): List<String> {
        return this.filter {
            returnRules(arg1, it)
        }
    }

    inline fun ArrayList<String>.returnAny(arg1: Int): Boolean {
        return this.any {
            returnRules(arg1, it)
        }
    }

    fun function01() {
        val list1 = ArrayList<String>()
        list1.add("one")
        list1.add("two")
        list1.add("three")

        list1.returnFilter(0)
        list1.returnAny(0)
    }
}