package meaing0823.kotlin_learning

object Example4InOut {
    open class Dollar
    open class OneDollar: Dollar()
    open class TwoDollar: OneDollar()
    class ThreeDollar: TwoDollar()

    class Pool<Dollar> {
        var dollar: Dollar? = null

        fun add(d: Dollar) {
            dollar = d
        }

        fun get(): Dollar? {
            return dollar
        }
    }

    /**
     * This function is used to explain why <in > will only return Any?
     */
    fun function01() {
        val pool0 = Pool<Any>()
        pool0.add("nothing")

        val pool1: Pool<in OneDollar> = pool0
        pool1.add(OneDollar()) // ["nothing", OneDollar]

        val pool2: Pool<in TwoDollar> = pool1
        pool2.add(TwoDollar()) // ["nothing", OneDollar, TwoDollar]

        val pool3: Pool<in ThreeDollar> = pool2
        pool3.add(ThreeDollar()) // ["nothing", OneDollar, TwoDollar, ThreeDollar]

        /**
         * You only can expect it return `Any?`
         * If not, pool3 put in $3 and it may take out $1 or $2 or even a String `nothing`
         * If not, pool2 put in $2 and it may take out $1 ( Cry ) or $3 ( Happy ) or even a String `nothing` ( Faint )
         *
         */
        val value1: Any? = pool1.get()
        val value2: Any? = pool2.get()
        val value3: Any? = pool3.get()
    }

    /**
     * This function is used to explain that how to ensure the data in the Collection class you put into a function is safe ?
     */
    fun function02() {
        fun printElements(list: ArrayList<out Dollar>) {
            // list.add(ThreeDollar()) // You are not allowed to add new element to the list
            // But, you can invoke clear()
            list.forEach (System.out::println)
        }

        val list1 = ArrayList<ThreeDollar>()
        list1.add(ThreeDollar())
        printElements(list1)
    }
}