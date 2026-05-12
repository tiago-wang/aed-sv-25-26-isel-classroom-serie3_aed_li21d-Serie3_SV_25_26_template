package part1

data class Node<E>(var value: E, var left:Node<E>?, var right:Node<E>?)

fun <E> equalTrees(root1: Node<E>?, root2: Node<E>?): Boolean {
    throw UnsupportedOperationException()
}

fun <E> contains(root: Node<E>?, min: E, max: E, cmp: Comparator<E>): Boolean {
    throw UnsupportedOperationException()
}


fun <E> removeGreaterThan(root: Node<E>?, x: E, cmp: Comparator<E>): Node<E>? {
    throw UnsupportedOperationException()
}