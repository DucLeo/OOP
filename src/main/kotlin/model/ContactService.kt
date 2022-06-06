package model
/*
import ezvcard.Ezvcard
import ezvcard.VCard
import ezvcard.parameter.EmailType
import ezvcard.parameter.TelephoneType
import ezvcard.property.Address
import ezvcard.property.Birthday
import ezvcard.property.StructuredName*/
import contactNote
import model.ContactsServiceInterface
import java.io.File
import java.util.*


class ContactService : ContactsServiceInterface {
    private val mapOfPerson: MutableMap<Person, MutableList<Contact>> = mutableMapOf()

    override fun addContact(person: Person, contact: Contact) {
        mapOfPerson.getOrPut(person) { mutableListOf() }.add(contact)
    }

    override fun addPhone(person: Person, phone: String, phoneType: PhoneType) {
        val currentPerson = mapOfPerson[person]
        currentPerson?.add(Contact.Phone(phone, phoneType))
    }

    override fun addEmail(person: Person, email: String) {
        mapOfPerson[person]?.add(Contact.Email(email))
    }

    override fun addDateOfBirth(person: Person, day: Int, month: Int, year: Int) {
        mapOfPerson[person]?.add(Contact.DateOfBirth(day, month, year))
    }


    override fun addAddress(
        person: Person,
        city: String,
        street: String,
        homeNumber: String,
        flatNumber: String
    ) {
        mapOfPerson[person]?.add(Contact.Address(city, street, homeNumber, flatNumber))
    }

    override fun removeContact(person: Person, contact: Contact) {
        mapOfPerson.getOrPut(person) { mutableListOf() } -= (contact)
    }

    override fun removePerson(person: Person) {
        mapOfPerson.remove(person)
    }

    override fun getPersonContacts(person: Person): List<Contact> {
        return mapOfPerson[person] ?: emptyList()
    }

    override fun getPersonPhones(person: Person): List<Contact.Phone> {
        val listOfContact = mapOfPerson[person]
        if (listOfContact != null) {
            return listOfContact.filterIsInstance<Contact.Phone>()
        }
        return emptyList()
    }

    override fun getPersonAddreses(person: Person): List<Contact.Address> {
        val listOfContact = mapOfPerson[person]
        if (listOfContact != null) {
            return listOfContact.filterIsInstance<Contact.Address>()
        }
        return emptyList()
    }


    override fun getPersonDateOfBirth(person: Person): List<Contact.DateOfBirth> {
        val listOfContact = mapOfPerson[person]
        if (listOfContact != null) {
            return listOfContact.filterIsInstance<Contact.DateOfBirth>()
        }
        return emptyList()
    }

    override fun getPersonEmails(person: Person): List<Contact.Email> {
        val listOfContact = mapOfPerson[person]
        if (listOfContact != null) {
            return listOfContact.filterIsInstance<Contact.Email>()
        }
        return emptyList()
    }

    override fun getAllPersons(): List<Person> {
        return mapOfPerson.keys.toList()
    }

    override fun getAllContacts(): Map<Person, List<Contact>> {
        return mapOfPerson
    }

    override fun find(subStringOfName: String?, subStringOfSurname: String?): List<Person> {
        val listOfPerson = mapOfPerson.keys
        return listOfPerson.filter {
            val nameMatched = subStringOfName == null || it.firstName.contains(subStringOfName)
            val surnameMatched = subStringOfSurname == null || it.lastName.contains(subStringOfSurname)
            nameMatched && surnameMatched
        }.toList()
    }
/*
    override fun changeInfo(person: Person, oldInfo: Contact?, newInfo: Contact?) {
        mapOfPerson[person]?.remove(oldInfo)
        val currentPerson = mapOfPerson[person]
        if (newInfo != null) {
            currentPerson?.add(newInfo)
        }

    }

    override fun changeName(person: Person, newPerson: Person) {
        val listOfContact = mapOfPerson[person]
        person.firstName = newPerson.firstName
        person.lastName = newPerson.lastName
        if (listOfContact != null) {
            for (j in listOfContact)
                contactNote.addContact(person, j)


        }
    }
*/
    /*
    override fun addPersonInVcard(listOfPerson: List<Person>, i: Int, vcard: VCard) {
        val n = StructuredName()
        n.family = listOfPerson[i].firstName
        n.given = listOfPerson[i].lastName
        vcard.structuredName = n
    }

    override fun addEmailInVcard(listOfPerson: List<Person>, i: Int, vcard: VCard) {
        for (j in 0 until getPersonEmails(listOfPerson[i]).size) {
            vcard.addEmail(getPersonEmails(listOfPerson[i])[j].emailName, EmailType.HOME)
        }
    }

    override fun addAddressInVcard(listOfPerson: List<Person>, i: Int, vcard: VCard) {
        if (getPersonAddreses(listOfPerson[i]).isNotEmpty()) {
            val adr = Address()
            adr.locality = getPersonAddreses(listOfPerson[i])[0].city
            adr.streetAddress =
                (getPersonAddreses(listOfPerson[i])[0].homeNumber + " " + getPersonAddreses(listOfPerson[i])[0].street
                        + " " + getPersonAddreses(listOfPerson[i])[0].flatNumber)
            vcard.addAddress(adr)
        }
    }

    override fun addNumberInVcard(listOfPerson: List<Person>, i: Int, vcard: VCard) {
        for (j in 0 until getPersonPhones(listOfPerson[i]).size)
            if (getPersonPhones(listOfPerson[i])[j].phoneType == PhoneType.MOBILE)
                vcard.addTelephoneNumber(getPersonPhones(listOfPerson[i])[j].number, TelephoneType.CELL)
            else
                vcard.addTelephoneNumber(getPersonPhones(listOfPerson[i])[j].number, TelephoneType.HOME)
    }

    override fun addDateOfBirth(listOfPerson: List<Person>, i: Int, vcard: VCard) {
        if (getPersonDateOfBirth(listOfPerson[i]).isNotEmpty()) {
            val date = Calendar.getInstance()
            date.clear()
            date[Calendar.YEAR] = getPersonDateOfBirth(listOfPerson[i])[0].year
            date[Calendar.MONTH] = getPersonDateOfBirth(listOfPerson[i])[0].month - 1
            date[Calendar.DAY_OF_MONTH] = getPersonDateOfBirth(listOfPerson[i])[0].day
            val bday = Birthday(date.time)
            vcard.birthday = bday
        }
    }

    override fun exportVcardFile(i: Int) {
        val file: File
        val vcard = VCard()
        val listOfPerson = mapOfPerson.keys.toList()
        addPersonInVcard(listOfPerson, i, vcard)
        addAddressInVcard(listOfPerson, i, vcard)
        addEmailInVcard(listOfPerson, i, vcard)
        addNumberInVcard(listOfPerson, i, vcard)
        addDateOfBirth(listOfPerson, i, vcard)

        file = File(listOfPerson[i].firstName + listOfPerson[i].lastName + ".vcf")
        Ezvcard.write(vcard).go(file)
    }
    */
}
