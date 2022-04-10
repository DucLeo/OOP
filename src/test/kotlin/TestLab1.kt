import Lab1.*
import Lab1.Address.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow

internal class AddressKtTest{
    @Test
    fun test_parseListAddresses() {
        var address = ""
        assertThrows<IllegalArgumentException> {
            parseListAddresses(address)
        }

        address = """
        1. 091005, Санкт-Петербург, ул. Балтийская, д. 10
        2. 100820, Москва, ул. Арбата, д. 8
        """.trimIndent()

        val listAddresses = parseListAddresses(address)

        assertEquals(listAddresses[0].Index, "091005")
        assertEquals(listAddresses[1].Index, "100820")
        assertEquals(listAddresses[0].City, "Санкт-Петербург")
        assertEquals(listAddresses[1].City, "Москва")
        assertEquals(listAddresses[0].Street, "Балтийская")
        assertEquals(listAddresses[1].Street, "Арбата")
        assertEquals(listAddresses[0].House, 10)
        assertEquals(listAddresses[1].House, 8)

    }

    @Test
    fun test_smallestIndex() {
        var listAddresses: List<Address> = emptyList()
        assertThrows<IllegalArgumentException> {
            smallestIndex(listAddresses)
        }

        listAddresses = listOf(
            Address("091005", "Санкт-Петербург", "Балтийская", 10),
            Address("100820", "Москва", "Арбата", 8),
        )
        val address = smallestIndex(listAddresses)
        assertDoesNotThrow {
            smallestIndex(listAddresses)
        }
        assertEquals(address, listAddresses.minByOrNull { it.Index.toInt() })
    }

    @Test
    fun test_biggestIndex() {
        var listAddresses: List<Address> = emptyList()
        assertThrows<IllegalArgumentException> {
            biggestIndex(listAddresses)
        }

        listAddresses = listOf(
            Address("091005", "Санкт-Петербург", "Балтийская", 10),
            Address("100820", "Москва", "Арбата", 8),
        )
        val address = biggestIndex(listAddresses)
        assertDoesNotThrow {
            biggestIndex(listAddresses)
        }
        assertEquals(address, listAddresses.maxByOrNull { it.Index.toInt() })
    }

    @Test
    fun test_shortestNameStreet() {
        var listAddresses: List<Address> = emptyList()
        assertThrows<IllegalArgumentException> {
            shortestNameStreet(listAddresses)
        }

        listAddresses = listOf(
            Address("091005", "Санкт-Петербург", "Балтийская", 10),
            Address("100820", "Москва", "Арбата", 8),
        )
        val address = shortestNameStreet(listAddresses)
        assertDoesNotThrow {
            shortestNameStreet(listAddresses)
        }
        assertEquals(address, listAddresses.minByOrNull { it.Street.length })
    }

    @Test
    fun test_longestNameStreet() {
        var listAddresses: List<Address> = emptyList()
        assertThrows<IllegalArgumentException> {
            longestNameStreet(listAddresses)
        }

        listAddresses = listOf(
            Address("091005", "Санкт-Петербург", "Балтийская", 10),
            Address("100820", "Москва", "Арбата", 8),
        )
        val address = longestNameStreet(listAddresses)
        assertDoesNotThrow {
            longestNameStreet(listAddresses)
        }
        assertEquals(address, listAddresses.maxByOrNull { it.Street.length })
    }
}