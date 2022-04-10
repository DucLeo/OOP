package Lab1

data class Address(var Index: String, var City: String, var Street: String, var House: Int){
    override fun toString(): String {
        return ("$Index, $City, ул. $Street, д. $House")
    }
}

fun parseListAddresses(TextListAddresses: String) : MutableList<Address>{
    if (TextListAddresses.isEmpty()) throw IllegalArgumentException("Input text is empty!")

    val listAddresses = mutableListOf<Address>()

    val addresses = TextListAddresses.split('\n')

    for(one in addresses){
        val parameter = one.split(", ")
        val numberIndex = parameter[0].split(". ")
        val index = numberIndex[1]
        val city = parameter[1]
        val street = parameter[2].drop(4)
        val house = parameter[3].drop(3).toInt()
        val newAddress = Address(index, city, street, house)

        listAddresses.add(newAddress)
    }

    return listAddresses
}

fun smallestIndex(listAddresses: List<Address>) : Address {
    if (listAddresses.isEmpty()) throw IllegalArgumentException("List of addresses is empty!")

    var requiredAddress = listAddresses[0]
    for (Address in listAddresses) {
        if (requiredAddress.Index.toInt() > Address.Index.toInt()) requiredAddress = Address
    }
    return requiredAddress
}

fun biggestIndex(listAddresses: List<Address>) : Address {
    if (listAddresses.isEmpty()) throw IllegalArgumentException("List of addresses is empty!")

    var requiredAddress = listAddresses[0]
    for (Address in listAddresses) {
        if (requiredAddress.Index.toInt() < Address.Index.toInt()) requiredAddress = Address
    }
    return requiredAddress
}

fun shortestNameStreet(listAddresses: List<Address>) : Address {
    if (listAddresses.isEmpty()) throw IllegalArgumentException("List of addresses is empty!")

    var requiredAddress = listAddresses[0]
    for (Address in listAddresses) {
        if (requiredAddress.Street.length > Address.Street.length) requiredAddress = Address
    }
    return requiredAddress
}

fun longestNameStreet(listAddresses: List<Address>) : Address {
    if (listAddresses.isEmpty()) throw IllegalArgumentException("List of addresses is empty!")

    var requiredAddress = listAddresses[0]
    for (Address in listAddresses) {
        if (requiredAddress.Street.length < Address.Street.length) requiredAddress = Address
    }
    return requiredAddress
}