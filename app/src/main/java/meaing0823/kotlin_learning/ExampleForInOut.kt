package meaing0823.kotlin_learning

class ExampleForInOut {
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

        val value1: Any? = pool1.get() // You only can expect it return Any?
        val value2: Any? = pool2.get()
        val value3: Any? = pool3.get()
    }
}