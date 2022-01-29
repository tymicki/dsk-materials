import list.ArrayListQueue

/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

class TreeNode<T>(private val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    // solution
    fun printEachLevel() {
        // 1 You begin by initializing a Queue data structure to facilitate the level-order
        //traversal. You also create nodesLeftInCurrentLevel to keep track of the
        //number of nodes you’ll need to work on before you print a new line.
        val queue = ArrayListQueue<TreeNode<T>>()
        var nodesLeftInCurrentLevel = 0

        queue.enqueue(this)
        //2. Your level-order traversal continues until your queue is empty.
        while (queue.isEmpty.not()) {
            //3. Inside the first while loop, you begin by setting nodesLeftInCurrentLevel to
            //the current elements in the queue.
            nodesLeftInCurrentLevel = queue.count

            //4. Using another while loop, you dequeue the first nodesLeftInCurrentLevel
            //number of elements from the queue. Every element you dequeue is printed
            //without establishing a new line. You also enqueue all the children of the node.
            while (nodesLeftInCurrentLevel > 0) {
                val node = queue.dequeue()
                node?.let {
                    print("${node.value} ")
                    node.children.forEach { queue.enqueue(it) }
                    nodesLeftInCurrentLevel--
                } ?: break
            }

            //5. At this point, you generate the new line using println(). In the next iteration,
            //nodesLeftInCurrentLevel is updated with the count of the queue, representing
            //the number of children from the previous iteration.
            println()
        }
    }
}