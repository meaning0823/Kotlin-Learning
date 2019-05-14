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

    fun method01() {
        val pool1 = Pool<OneDollar>()
        pool1.add(OneDollar())

        val pool2: Pool<in TwoDollar> = pool1
        pool2.add(TwoDollar())

        val pool3: Pool<in ThreeDollar> = pool2
        pool3.add(ThreeDollar())
    }

}