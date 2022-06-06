package model

interface ContactsServiceInterface {
    fun addContact(person: Person, contact: Contact)

    fun removeContact(person: Person, contact: Contact)

    fun removePerson(person: Person)

    fun addPhone(person: Person, phone: String, phoneType: PhoneType)

    fun addEmail(person: Person, email: String)

    fun addAddress(person: Person, city: String, street: String, homeNumber: String, flatNumber: String)

    fun getPersonContacts(person: Person): List<Contact>

    fun getPersonPhones(person: Person): List<Contact.Phone>

    fun getPersonEmails(person: Person): List<Contact.Email>?

    fun getAllPersons(): List<Person>


    //fun changeInfo(person: Person, oldInfo: Contact?, newInfo: Contact?)

    //fun changeName(person: Person, newPerson: Person)

    fun getAllContacts(): Map<Person, List<Contact>>
    fun getPersonDateOfBirth(person: Person): List<Contact.DateOfBirth?>
    fun find(subStringOfName: String?, subStringOfSurname: String?): List<Person>
    fun getPersonAddreses(person: Person): List<Contact.Address>
   // fun exportVcardFile(i: Int)
    fun addDateOfBirth(person: Person, day: Int, month: Int, year: Int)

/*
    fun addPersonInVcard(listOfPerson: List<Person>, i: Int, vcard: VCard)
    fun addEmailInVcard(listOfPerson: List<Person>, i: Int, vcard: VCard)
    fun addAddressInVcard(listOfPerson: List<Person>, i: Int, vcard: VCard)
    fun addNumberInVcard(listOfPerson: List<Person>, i: Int, vcard: VCard)
    fun addDateOfBirth(listOfPerson: List<Person>, i: Int, vcard: VCard)

 */
}