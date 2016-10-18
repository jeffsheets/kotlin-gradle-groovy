import java.util.*

class KotlinBinarySearch {
    fun bfs(node: Node, result: MutableList<String> = mutableListOf()): MutableList<String> {
        val queue: Queue<Node> = LinkedList<Node>()
        queue.add(node)

        while (queue.isNotEmpty()) {
            val it = queue.poll()

            result.add(it.value)

            if (it.left != null) {
                queue.add(it.left)
            }
            if (it.right != null) {
                queue.add(it.right)
            }
        }
        return result
    }

    fun dfs_stack_inorder(node: Node, result: MutableList<String> = mutableListOf()): MutableList<String> {
        val stack = Stack<Node>()
        stack.push(node)

        while (!stack.empty()) {
            val it = stack.pop()

            if (!it.visited) {
                it.visited = true

                if (it.right != null) {
                    stack.push(it.right)
                }
                stack.push(it)
                if (it.left != null) {
                    stack.push(it.left)
                }
            } else {
                result.add(it.value)
            }
        }
        return result
    }

    fun dfs_stack_preorder(node: Node, result: MutableList<String> = mutableListOf()): MutableList<String> {
        val stack = Stack<Node>()
        stack.push(node)

        while (!stack.empty()) {
            val it = stack.pop()

            if (!it.visited) {
                it.visited = true

                if (it.right != null) {
                    stack.push(it.right)
                }
                if (it.left != null) {
                    stack.push(it.left)
                }
                stack.push(it)
            } else {
                result.add(it.value)
            }
        }
        return result
    }

    fun dfs_inorder(node: Node, result: MutableList<String> = mutableListOf()): MutableList<String> {
        if (node.left != null) {
            dfs_inorder(node.left, result)
        }
        result.add(node.value)
        if (node.right != null) {
            dfs_inorder(node.right, result)
        }
        return result
    }

    fun binarySearch(toFind: Int, list: List<Int>): Int {
        var low = 0
        var high = list.size - 1
        while (low <= high) {
            val middle = (low + high) / 2
            if (list[middle] == toFind) {
                return middle
            }
            if (list[middle] < toFind) {
                low = middle + 1
            } else {
                high = middle - 1
            }
        }
        return -1
    }

    fun quickSort(list: List<Int>): List<Int> {
        if (list.size <= 1) {
            return list
        }
        val middleIndex = list.size / 2
        val middle = list[middleIndex]
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        for (i in list.indices) {
            if (i != middleIndex) {
                if (list[i] <= middle)
                    left.add(list[i])
                else
                    right.add(list[i])
            }
        }
        val listOfLists = quickSort(left) + listOf(middle) + quickSort(right)
        return listOfLists
    }
}
