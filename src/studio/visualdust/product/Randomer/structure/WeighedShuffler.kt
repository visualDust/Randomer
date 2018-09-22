package studio.visualdust.product.Randomer.structure

import java.util.*
import kotlin.collections.ArrayList

open class WeighedShuffler<T>(list: List<T>,
                              weight: DoubleArray)
    : Iterator<T>, Iterable<T> {

    val list: ArrayList<T> = ArrayList(list)
    private val size: Int = list.size

    private val weightRange: DoubleArray
    private val weightSum: Double

    private val weight: DoubleArray = Arrays.copyOf(weight, weight.size)

    private val random = Random()

    init {
        weightRange = DoubleArray(size + 1)
        for (i in 0 until size) {
            weightRange[i + 1] = weightRange[i] + weight[i]
        }
        weightSum = weightRange[size]
    }

    override fun hasNext(): Boolean {
        return size != 0
    }

    override fun next(): T {
        val value = random.nextDouble() * weightSum
        val index = bisearch(value)
        return list[index]
    }

    private fun bisearch(w: Double): Int {
        var left = 0
        var right = size
        while (left + 1 != right) {
            val mid = (left + right) / 2
            if (w >= weightRange[mid]) {
                left = mid
            } else {
                right = mid
            }
        }
        return left
    }

    override fun iterator(): Iterator<T> {
        return this
    }
}
