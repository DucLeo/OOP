package model

sealed class Contact {

    data class Phone(var number: String, val phoneType: PhoneType) : Contact()

    data class Email(var emailName: String) : Contact()

    data class Address(var city: String, var street: String, var homeNumber: String, var flatNumber: String) : Contact()

    data class DateOfBirth(var day: Int, var month: Int, var year: Int) : Contact()
}

enum class PhoneType {
    MOBILE, HOME
}