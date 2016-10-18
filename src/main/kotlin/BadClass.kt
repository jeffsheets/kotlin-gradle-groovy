
class BadClass {

    fun varVersusVal() {
        var four = 4
        four = 5   // OK

        val five = 5
        //five = 6  //ERROR
    }

    fun nullChecks() {
        var three: Int? = 3
        three = null  //OK

        var four: Int = 4
        //four = null  //ERROR
    }

    fun strings() {
        val year = 2016

        println("Year is $year")

        println("""
            The Year is $year
            and it will soon be winter
        """)
    }
}

