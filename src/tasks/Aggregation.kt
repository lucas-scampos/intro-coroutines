package tasks

import contributors.User

fun List<User>.aggregate(): List<User>  {
    var aggregated = mutableListOf<User>()

    this.groupBy { it.login }.entries.forEach {
        aggregated.add(User(it.key, it.value.fold(0) { sum, element -> sum + element.contributions}))
    }

    return aggregated.sortedBy { it.contributions }.reversed()
}
