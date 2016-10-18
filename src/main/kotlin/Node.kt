/**
 * https://kotlinlang.org/docs/reference/data-classes.html
 *
 * data classes get
 *  - equals/hashCode
 *  - toString
 *  - copy()
 *  - destructuring componentN() functions
 *     - https://kotlinlang.org/docs/reference/multi-declarations.html
 *     - val (value, left, right) = node
 */
data class Node(var value: String,
                val left: Node? = null,
                val right: Node? = null) {
    var visited: Boolean = false
}
