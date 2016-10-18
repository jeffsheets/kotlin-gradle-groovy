import com.winterbe.expekt.expect
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

/**
 * NOTE: Install the Spek IntelliJ Plugin to run in IntelliJ
 */
class KotlinBinarySearchSpec: Spek({
    describe("Kotlin Binary Search tests") {
        val bs = KotlinBinarySearch()

        /*
                1
              2   3
             4 5 6 7
            8       9
             */
        fun tree(): Node {
            return Node("1", Node("2", Node("4", Node("8")), Node("5")), Node("3", Node("6"), Node("7", null, Node("9"))))
        }

        it("should be correct for breadth first search") {
            val result = bs.bfs(tree())
            println(result)

            expect(result).to.equal(mutableListOf("1", "2", "3", "4", "5", "6", "7", "8", "9"))
        }

        it("should be correct for depth first stack inorder") {
            val result = bs.dfs_stack_inorder(tree())
            println(result)

            expect(result).to.equal(mutableListOf("8", "4", "2", "5", "1", "6", "3", "7", "9"))
        }

        it("should be correct for depth first inorder") {
            val result = bs.dfs_inorder(tree())
            println(result)

            expect(result).to.equal(mutableListOf("8", "4", "2", "5", "1", "6", "3", "7", "9"))
        }

        it("should be correct for depth first stack preorder") {
            val result = bs.dfs_stack_preorder(tree())
            println(result)

            expect(result).to.equal(mutableListOf("1", "2", "4", "8", "5", "3", "6", "7", "9"))
        }

        describe("binarySearch") {
            val primes = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89)

            it("should work for 67") {
                expect(bs.binarySearch(67, primes)).to.equal(18)
            }

            //Nice trick - https://realm.io/news/kau-rob-fletcher-kotlin-testing/
            for ((num, primeLocation) in mapOf(8 to -1, 2 to 0, 89 to 23, 97 to -1)) {
                describe("binarySearch of $num") {
                    val result = bs.binarySearch(num, primes)
                    it("has location $primeLocation in array") {
                        expect(result).to.equal(primeLocation)
                    }
                }
            }
        }

        it("should quicksort correctly") {
            val list = listOf(4, 6, 1, 2, 8, 9, 3, 0, 10, 3)

            val result = bs.quickSort(list)

            expect(result).to.equal(listOf(0, 1, 2, 3, 3, 4, 6, 8, 9, 10))
        }
    }
})
