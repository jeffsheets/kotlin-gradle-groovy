import spock.lang.Specification
import spock.lang.Unroll

class BinarySearchSpockTest extends Specification {

    BinarySearch bs = new BinarySearch()

    def static node(def val, def left=null, def right=null) {
        [val: val, left: left, right: right, visited: false]
    }

    /*
            1
          2   3
         4 5 6 7
        8       9
         */
    def tree = { node('1', node('2', node('4', node('8')), node('5')), node('3', node('6'), node('7', null, node('9')))) }

    def "breadth first search"() {
        when:
        def result = bs.bfs(tree())
        println result

        then:
        result == ['1', '2', '3', '4', '5', '6', '7', '8', '9']
    }

    def "depth first search preorder"() {
        when:
        def result = bs.dfs_preorder(tree())
        println result

        then:
        result == ['1', '2', '4', '8', '5', '3', '6', '7', '9']
    }

    def "depth first search stack preorder"() {
        when:
        def result = bs.dfs_stack_preorder(tree())
        println result

        then:
        result == ['1', '2', '4', '8', '5', '3', '6', '7', '9']
    }

    def "depth first search inorder"() {
        when:
        def result = bs.dfs_inorder(tree())
        println result

        then:
        result == ['8', '4', '2', '5', '1', '6', '3', '7', '9']
    }

    def "depth first search stack inorder"() {
        when:
        def result = bs.dfs_stack_inorder(tree())
        println result

        then:
        result == ['8', '4', '2', '5', '1', '6', '3', '7', '9']
    }

    def "depth first search postorder"() {
        when:
        def result = bs.dfs_postorder(tree())
        println result

        then:
        result == ['8', '4', '5', '2', '6', '9', '7', '3', '1']
    }

    def "depth first search stack postorder"() {
        when:
        def result = bs.dfs_stack_postorder(tree())
        println result

        then:
        result == ['8', '4', '5', '2', '6', '9', '7', '3', '1']
    }

    @Unroll
    def "binarySearch for #num"(Integer num, Integer primeLocation) {
        given: 'primes'
        def primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89]

        when:
        def result = bs.binarySearch(num, primes)

        then:
        result == primeLocation

        where:
        num || primeLocation
        67  || 18
        8   || -1
        2   || 0
        89  || 23
        97  || -1
    }

    def "quickSort"() {
        given:
        def list = [4, 6, 1, 2, 8, 9, 3, 0, 10, 3]

        when:
        def result = bs.quickSort(list)
        println result

        then:
        result == [0, 1, 2, 3, 3, 4, 6, 8, 9, 10]
    }
}
