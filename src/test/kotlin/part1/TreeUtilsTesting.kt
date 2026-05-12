package part1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

val cmp={ i1: Int, i2: Int -> i1 - i2 }

fun emptyBST(): Node<Int>?=null

fun singleNodeBST(i:Int): Node<Int>?=add(null,i,cmp)

fun populatedBST(array:IntArray): Node<Int>? {
    var tree: Node<Int>? = null
    for (i in array) tree = add(tree, i, cmp)
    return tree
}

fun populatedBST(): Node<Int>? {
    val nodes = intArrayOf(10, 4, 1, 8, 5, 6, 7, 0, 2, 3, 9, 12, 11)
    var tree: Node<Int>? = null
    for (i in nodes.indices) tree = add(tree, nodes[i], cmp)
    return tree
}

fun subPopulatedBST(): Node<Int>? {
    val nodes = intArrayOf(10, 4, 1, 8, 12, 11)
    var tree: Node<Int>? = null
    for (i in nodes.indices) tree = add(tree, nodes[i], cmp)
    return tree
}

fun <E> sizeBST(root: Node<E>?): Int {
    return if (root == null) 0 else 1 + sizeBST(root.left) + sizeBST(root.right)
}

fun <E> search(root: Node<E>?, key: E, cmp: Comparator<E>): Node<E>? {
    if (root == null || cmp.compare(key, root.value) == 0) return root
    else if (cmp.compare(key, root.value) < 0) return search<E>(root.left, key, cmp)
    else return search<E>(root.right, key, cmp)
}

fun <E> add(root: Node<E>?, e: E, cmp: Comparator<E>): Node<E> {
    var root = root
    if (root == null) root = Node(e,null,null)
    else if (cmp.compare(e, root.value) < 0) root.left = add(root.left, e, cmp)
    else root.right = add(root.right, e, cmp)
    return root
}

fun <E> remove(root: Node<E>?, e: E?, cmp: Comparator<E>): Node<E>? {
    var root = root
    if (root == null) return root
    else {
        if (cmp.compare(e, root.value) < 0) root.left = remove<E>(root.left, e, cmp)
        else if (cmp.compare(e, root.value) > 0) root.right = remove<E>(root.right, e, cmp)
        else { // found, delete it
            if (root.left == null) root = root.right
            else if (root.right == null) root = root.left
            else {
                val y: Node<E> = minimum(root.right!!)
                root.value = y.value
                root.right = remove(root.right, y.value, cmp)
            }
        }
        return root
    }
}

fun <E> minimum(root: Node<E>): Node<E> {
    if (root.left == null) return root
    else return minimum(root.left!!)
}

fun <E> maximum(root: Node<E>): Node<E> {
    if (root.right == null) return root
    else return minimum(root.right!!)
}

fun leftChildsBST(): Node<Int>? {
    val nodes = intArrayOf(5, 4, 3, 2, 1)
    var tree: Node<Int>? = null
    for (i in nodes.indices) tree = add(tree, nodes[i], cmp)
    return tree
}

fun rightChildsBST(): Node<Int>? {
    val nodes = intArrayOf(1, 2, 3, 4, 5)
    var tree: Node<Int>? = null
    for (i in nodes.indices) tree = add(tree, nodes[i], cmp)
    return tree
}

fun <E> assertEqual(root1: Node<E>?, root2: Node<E>?) {
    if (root1 != null && root2 != null) {
        assertEquals(root1.value, root2.value)
        assertEqual(root1.left, root2.left)
        assertEqual(root1.right, root2.right)
    }
    assertEquals(root1, root2)
}



















