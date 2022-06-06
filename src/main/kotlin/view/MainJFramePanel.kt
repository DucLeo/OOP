package view

import model.Contact
import model.PhoneType
import contactNote
import model.Person
import java.awt.BorderLayout
import java.awt.Component
import java.awt.Dimension
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.JPanel

class MainJFramePanel : JFrame("UI") {
    private val panel = JPanel()

    private val buttonRow = mutableListOf<JButton>()

    init {
        panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
        fillClassesForTest()
        setSize(300, 500)
        defaultCloseOperation = EXIT_ON_CLOSE
        add(createContactsPanel(), BorderLayout.CENTER)
        panel.repaint()
        add(createNewContactButton(), BorderLayout.SOUTH)
        panel.repaint()
    }

    private fun createNewContactButton(): Component {
        var listOfPersons: List<Person>
        val buttonAddNewContact = JButton("Добавить контакт")
        val numberPanel = JPanel(BorderLayout(40, 300))
        buttonAddNewContact.addActionListener {
            val ecd = EditContactDialog()

            if (ecd.isSave) {
                ecd.addInfo()
                if (ecd.checkContactWithoutNameOrSurname() == 0) JOptionPane.showMessageDialog(panel, "Невозможно создать контакт без имени и фамилии")
                else
                    if (ecd.checkContactWithoutPhone() == 0) JOptionPane.showMessageDialog(panel, "Невозможно создать контакт без номера")
                    else {
                        listOfPersons = contactNote.getAllPersons()
                        val newButton = JButton(listOfPersons.last().firstName + " " + listOfPersons.last().lastName)
                        buttonRow.add(newButton)
                        newButton.maximumSize = Dimension(300, 40)
                        newButton.addActionListener {
                            val scd = InformationAboutContactDialogUI(buttonRow.size - 1, buttonRow)
                            scd.revalidate()
                            scd.repaint()
                            panel.revalidate()
                            panel.repaint()
                        }
                        panel.add(newButton)
                        panel.revalidate()
                        panel.repaint()
                    }
            }

        }
        buttonAddNewContact.maximumSize = Dimension(300, 40)
        numberPanel.add(buttonAddNewContact)
        return numberPanel
    }

    private fun createContactsPanel(): Component {
        val listOfPersons = contactNote.getAllPersons()

        for (i in listOfPersons.indices) {
            buttonRow.add(
                JButton(
                    listOfPersons[i].firstName + " "
                            + listOfPersons[i].lastName
                )
            )
            buttonRow[i].maximumSize = Dimension(300, 40)
            buttonRow[i].addActionListener {
                InformationAboutContactDialogUI(i, buttonRow)
            }
            panel.add(buttonRow[i])
        }

        return panel
    }

    private fun fillClassesForTest() {
        val person = Person("Vadim", "Khamatov")
        val friend = Person("Andrey", "Bludin")
        val myPhone = Contact.Phone("41429", PhoneType.MOBILE)
        val friendPhone = Contact.Phone("8937932133", PhoneType.MOBILE)
        val email = Contact.Email("vadimvadim228@yandex.ru")
        val address = Contact.Address(
            "Saint-Petersburg",
            "Novoizmailovsky prospekt", "16", "91"
        )
        val dateOfBirthdayOfPerson = Contact.DateOfBirth(5, 12, 2001)
        contactNote.addContact(person, dateOfBirthdayOfPerson)
        contactNote.addContact(friend, friendPhone)
        contactNote.addContact(person, address)
        contactNote.addContact(person, myPhone)
        contactNote.addContact(person, email)
    }
}