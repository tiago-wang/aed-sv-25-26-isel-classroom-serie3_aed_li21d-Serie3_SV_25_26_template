package part1

data class Node<E>(var value: E, var left:Node<E>?, var right:Node<E>?)

fun <E> equalTrees(root1: Node<E>?, root2: Node<E>?): Boolean {
    if ((root1?.value == null) xor (root2?.value == null)) return false
    else if (root1?.value != root2?.value) return false
    else {
        val left1 = if (root1?.left != null) root1.left else null
        val left2 = if (root2?.left != null) root2.left else null
        val right1 = if (root1?.right != null) root1.right else null
        val right2 = if (root2?.right != null) root2.right else null
        if (left1 == null && left2 == null && right1 == null && right2 == null) return true
        return equalTrees(left1, left2) && equalTrees(right1, right2)
    }
}

fun <E> contains(root: Node<E>?, min: E, max: E, cmp: Comparator<E>): Boolean {
    if (root?.value == null) return false
    else if ((root.left == null && root.right == null) && (cmp.compare(root.value, max) > 0 || cmp.compare(min, root.value) > 0 )) return false
    else if (cmp.compare(root.value, max) <= 0 && cmp.compare(min, root.value) <= 0) return true
    else return (contains(root.left, min, max, cmp) || contains(root.right, min, max, cmp))
}

fun <E> removeGreaterThan(root: Node<E>?, x: E, cmp: Comparator<E>): Node<E>? {
    throw UnsupportedOperationException()
}
