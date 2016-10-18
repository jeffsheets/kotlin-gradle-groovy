class BinarySearch {

    def bfs(def node, def result=[]) {
        Queue queue = new LinkedList()
        queue.add(node)

        while (queue) {
            def it = queue.poll()

            result << it.val

            if (it.left) {
                queue.add(it.left)
            }
            if (it.right) {
                queue.add(it.right)
            }
        }
        result
    }

    def dfs_stack_inorder(def node, def result=[]) {
        Stack stack = new Stack()
        stack.push(node)

        while (!stack.empty()) {
            def it = stack.pop()

            if (!it.visited) {
                it.visited = true

                if (it.right) {
                    stack.push(it.right)
                }
                stack.push(it)
                if (it.left) {
                    stack.push(it.left)
                }
            } else {
                result << it.val
            }
        }
        result
    }

    def dfs_stack_preorder(def node, def result=[]) {
        Stack stack = new Stack()
        stack.push(node)

        while (!stack.empty()) {
            def it = stack.pop()

            if (!it.visited) {
                it.visited = true

                if (it.right) {
                    stack.push(it.right)
                }
                if (it.left) {
                    stack.push(it.left)
                }
                stack.push(it)
            } else {
                result << it.val
            }
        }
        result
    }

    def dfs_stack_postorder(def node, def result=[]) {
        Stack stack = new Stack()
        stack.push(node)

        while (!stack.empty()) {
            def it = stack.pop()

            if (!it.visited) {
                it.visited = true

                stack.push(it)
                if (it.right) {
                    stack.push(it.right)
                }
                if (it.left) {
                    stack.push(it.left)
                }
            } else {
                result << it.val
            }
        }
        result
    }

    def dfs_inorder(def node, def result=[]) {
        if (node.left) {
            dfs_inorder(node.left, result)
        }
        result << node.val
        if (node.right) {
            dfs_inorder(node.right, result)
        }
        result
    }

    def dfs_preorder(def node, def result=[]) {
        result << node.val
        if (node.left) {
            dfs_preorder(node.left, result)
        }
        if (node.right) {
            dfs_preorder(node.right, result)
        }
        result
    }

    def dfs_postorder(def node, def result=[]) {
        if (node.left) {
            dfs_postorder(node.left, result)
        }
        if (node.right) {
            dfs_postorder(node.right, result)
        }
        result << node.val
        result
    }

    def binarySearch(Integer toFind, List<Integer> list) {
        Integer low = 0
        Integer high = list.size() - 1
        while (low <= high) {
            Integer middle = (low + high) / 2
            if (list[middle] == toFind) {
                return middle
            }
            if (list[middle] < toFind) {
                low = middle + 1
            } else {
                high = middle - 1
            }
        }
        -1
    }

    def quickSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int middleIndex = list.size() / 2
        Integer middle = list[middleIndex];
        List<Integer> left = []
        List<Integer> right = []
        for (int i = 0; i < list.size(); i++) {
            if (i != middleIndex) {
                if (list[i] <= middle)
                    left << list[i]
                else
                    right << list[i]
            }
        }
        List listOfLists = quickSort(left) + [middle] + quickSort(right)
        return listOfLists.flatten();
    }

    def static node(def val, def left=null, def right=null) {
        [val: val, left: left, right: right, visited: false]
    }

    static void main(String... args) {
        /*
            1
          2   3
         4 5 6 7
        8       9
         */
        def tree = { node('1', node('2', node('4', node('8')), node('5')), node('3', node('6'), node('7', null, node('9')))) }

        BinarySearch bs = new BinarySearch()

        println bs.dfs_preorder(tree())
        println bs.dfs_inorder(tree())
        println bs.dfs_postorder(tree())

        println bs.dfs_stack_preorder(tree())
        println bs.dfs_stack_inorder(tree())
        println bs.dfs_stack_postorder(tree())

        println bs.bfs(tree())

        def primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89]
        println bs.binarySearch(67, primes)
        println bs.binarySearch(8, primes)
        println bs.binarySearch(2, primes)
        println bs.binarySearch(89, primes)
        println bs.binarySearch(97, primes)


        def list = [4, 6, 1, 2, 8, 9, 3, 0, 10, 3]
        println bs.quickSort(list)
    }
}
