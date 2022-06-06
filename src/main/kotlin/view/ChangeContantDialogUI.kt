package view

import model.PhoneType
import contactNote
import model.Person
import java.awt.Rectangle
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class ChangeContactDialogUI : JDialog(),
    ActionListener {
    // Поле для ввода Имени
    private val txtFirstName = JTextPane()

    // Поле для ввода Фамилии
    private val txtLastName = JTextPane()

    // Поле для ввода Телефона
    private val txtPhone = JTextPane()

    private val txtHomePhone = JTextPane()

    // Поле для ввода E-mail
    private val txtEmail = JTextPane()

    private val txtOtherEmail = JTextPane()

    private val txtBirthdayday = JTextPane()
    private val txtBirthdaymonth = JTextPane()
    private val txtBirthdayyear = JTextPane()

    private val txtCity = JTextPane()
    private val txtStreet = JTextPane()
    private val txtHomeNumber = JTextPane()
    private val txtFlatNumber = JTextPane()

    // Надо ли сохранять изменения
    // Надо ли записывать изменения после закрытия диалога
    private var isSave = false

    init {
        layout = null
        buildFields()
        buildButtons()
        isModal = true
        isResizable = false
        setBounds(500, 500, 500, 350)
        isVisible = true
    }

    private fun buildFields() {
        val lblFirstName = JLabel("Имя:")
        lblFirstName.horizontalAlignment = SwingConstants.RIGHT
        lblFirstName.bounds = Rectangle(PAD, 0 * H_B + PAD, W_L, H_B)
        add(lblFirstName)
        txtFirstName.bounds = Rectangle(W_L + 2 * PAD, 0 * H_B + PAD, W_T, H_B)
        txtFirstName.border = BorderFactory.createEtchedBorder()
        add(txtFirstName)

        // Набор метки и поля для Фамилии
        val lblLastName = JLabel("Фамилия:")
        lblLastName.horizontalAlignment = SwingConstants.RIGHT
        lblLastName.bounds = Rectangle(PAD, 1 * H_B + PAD, W_L, H_B)
        add(lblLastName)
        txtLastName.bounds = Rectangle(W_L + 2 * PAD, 1 * H_B + PAD, W_T, H_B)
        txtLastName.border = BorderFactory.createEtchedBorder()
        add(txtLastName)

        // Набор метки и поля для Телефона
        val lblPhone = JLabel("Моб. Телефон:")
        lblPhone.horizontalAlignment = SwingConstants.RIGHT
        lblPhone.bounds = Rectangle(PAD, 2 * H_B + PAD, W_L, H_B)
        add(lblPhone)
        txtPhone.bounds = Rectangle(W_L + 2 * PAD, 2 * H_B + PAD, W_T, H_B)
        txtPhone.border = BorderFactory.createEtchedBorder()
        add(txtPhone)

        val lblHomePhone = JLabel("Дом. Телефон:")
        lblHomePhone.horizontalAlignment = SwingConstants.RIGHT
        lblHomePhone.bounds = Rectangle(PAD, 3 * H_B + PAD, W_L, H_B)
        add(lblHomePhone)
        txtHomePhone.bounds = Rectangle(W_L + 2 * PAD, 3 * H_B + PAD, W_T, H_B)
        txtHomePhone.border = BorderFactory.createEtchedBorder()
        add(txtHomePhone)


        // Набор метки и поля для Email
        val lblOtherEmail = JLabel("Доп. email:")
        lblOtherEmail.horizontalAlignment = SwingConstants.RIGHT
        lblOtherEmail.bounds = Rectangle(PAD, 5 * H_B + PAD, W_L, H_B)
        add(lblOtherEmail)
        txtOtherEmail.bounds = Rectangle(W_L + 2 * PAD, 5 * H_B + PAD, W_T, H_B)
        txtOtherEmail.border = BorderFactory.createEtchedBorder()
        add(txtOtherEmail)


        // Набор метки и поля для Email
        val lblEmail = JLabel("Email:")
        lblEmail.horizontalAlignment = SwingConstants.RIGHT
        lblEmail.bounds = Rectangle(PAD, 4 * H_B + PAD, W_L, H_B)
        add(lblEmail)
        txtEmail.bounds = Rectangle(W_L + 2 * PAD, 4 * H_B + PAD, W_T, H_B)
        txtEmail.border = BorderFactory.createEtchedBorder()
        add(txtEmail)

        // Набор метки и поля для Birthday
        val lblBirthday = JLabel("Birthday:")
        lblBirthday.horizontalAlignment = SwingConstants.RIGHT
        lblBirthday.bounds = Rectangle(PAD, 6 * H_B + PAD, W_L, H_B)
        add(lblBirthday)

        txtBirthdayday.bounds = Rectangle(W_L + 2 * PAD, 6 * H_B + PAD, 20, H_B)
        txtBirthdayday.border = BorderFactory.createEtchedBorder()
        add(txtBirthdayday)
        txtBirthdaymonth.bounds = Rectangle(W_L + 2 * PAD + 35, 6 * H_B + PAD, 20, H_B)
        txtBirthdaymonth.border = BorderFactory.createEtchedBorder()
        add(txtBirthdaymonth)
        txtBirthdayyear.bounds = Rectangle(W_L + 2 * PAD + 70, 6 * H_B + PAD, 30, H_B)
        txtBirthdayyear.border = BorderFactory.createEtchedBorder()
        add(txtBirthdayyear)

        val lblCity = JLabel("City:")
        lblCity.horizontalAlignment = SwingConstants.RIGHT
        lblCity.bounds = Rectangle(PAD, 7 * H_B + PAD, W_L, H_B)
        add(lblCity)


        txtCity.bounds = Rectangle(W_L + 2 * PAD, 7 * H_B + PAD, W_T, H_B)
        txtCity.border = BorderFactory.createEtchedBorder()
        add(txtCity)

        val lblStreet = JLabel("Street:")
        lblStreet.horizontalAlignment = SwingConstants.RIGHT
        lblStreet.bounds = Rectangle(PAD, 8 * H_B + PAD, W_L, H_B)
        add(lblStreet)

        txtStreet.bounds = Rectangle(W_L + 2 * PAD, 8 * H_B + PAD, W_T, H_B)
        txtStreet.border = BorderFactory.createEtchedBorder()
        add(txtStreet)

        val lblHomeNumber = JLabel("Home:")
        lblHomeNumber.horizontalAlignment = SwingConstants.RIGHT
        lblHomeNumber.bounds = Rectangle(PAD, 9 * H_B + PAD, W_L, H_B)
        add(lblHomeNumber)

        txtHomeNumber.bounds = Rectangle(W_L + 2 * PAD, 9 * H_B + PAD, W_T, H_B)
        txtHomeNumber.border = BorderFactory.createEtchedBorder()
        add(txtHomeNumber)

        val lblFlatNumber = JLabel("Flat:")
        lblFlatNumber.horizontalAlignment = SwingConstants.RIGHT
        lblFlatNumber.bounds = Rectangle(PAD, 10 * H_B + PAD, W_L, H_B)
        add(lblFlatNumber)

        txtFlatNumber.bounds = Rectangle(W_L + 2 * PAD, 10 * H_B + PAD, W_T, H_B)
        txtFlatNumber.border = BorderFactory.createEtchedBorder()
        add(txtFlatNumber)
    }

    // Размещаем кнопки на форме
    private fun buildButtons() {
        val btnSave = JButton("Сохранить")
        btnSave.actionCommand = EditContactDialog.SAVE
        btnSave.addActionListener(this)
        btnSave.bounds = Rectangle(
            EditContactDialog.PAD, 11 * EditContactDialog.H_B + EditContactDialog.PAD,
            EditContactDialog.W_B,
            EditContactDialog.H_B
        )
        add(btnSave)
        val btnCancel = JButton("Отменить")
        btnCancel.actionCommand = EditContactDialog.CANCEL
        btnCancel.addActionListener(this)
        btnCancel.bounds = Rectangle(
            EditContactDialog.W_B + 2 * EditContactDialog.PAD, 11 * EditContactDialog.H_B + EditContactDialog.PAD,
            EditContactDialog.W_B,
            EditContactDialog.H_B
        )
        add(btnCancel)
    }

    // Обработка нажатий кнопок
    override fun actionPerformed(ae: ActionEvent) {
        val action = ae.actionCommand
        // Если нажали кнопку SAVE (сохранить изменения) - запоминаем этой
        isSave = SAVE == action
        // Закрываем форму
        isVisible = false
    }
/*
    fun changeInfo(buttonRow: JButton, i: Int) {
        val currentPerson = contactNote.getAllPersons()[i]
        val person: Person
        if ((txtFirstName.text != "") and (txtLastName.text == "")) {
            person = Person(txtFirstName.text, currentPerson.lastName)
            contactNote.changeName(currentPerson, person)
            buttonRow.text = currentPerson.firstName + " " + currentPerson.lastName
        } else
            if ((txtFirstName.text == "") and (txtLastName.text != "")) {
                person = Person(currentPerson.firstName, txtLastName.text)
                contactNote.changeName(currentPerson, person)
                buttonRow.text = currentPerson.firstName + " " + txtLastName.text
            } else
                if ((txtFirstName.text != "") and (txtLastName.text != "")) {
                    person = Person(txtFirstName.text, txtLastName.text)
                    contactNote.changeName(currentPerson, person)
                    buttonRow.text = txtFirstName.text + " " + txtLastName.text
                }

        var city = ""
        var street = ""
        var homeNumber = ""
        var flatNumber = ""
        if (txtCity.text != "")
            if (contactNote.getPersonAddreses(currentPerson).isNotEmpty())
                contactNote.getPersonAddreses(currentPerson)[0].city = txtCity.text
            else {
                city = txtCity.text
            }
        if (txtStreet.text != "")
            if (contactNote.getPersonAddreses(currentPerson).isNotEmpty())
                contactNote.getPersonAddreses(currentPerson)[0].street = txtStreet.text
            else {
                street = txtStreet.text
            }


        if (txtHomeNumber.text != "")
            if (contactNote.getPersonAddreses(currentPerson).isNotEmpty())
                contactNote.getPersonAddreses(currentPerson)[0].homeNumber = txtHomeNumber.text
            else {
                homeNumber = txtHomeNumber.text
            }

        if (txtFlatNumber.text != "")
            if (contactNote.getPersonAddreses(currentPerson).isNotEmpty())
                contactNote.getPersonAddreses(currentPerson)[0].flatNumber = txtFlatNumber.text
            else {
                flatNumber = txtFlatNumber.text
            }

        if ((txtFlatNumber.text != "") and (txtHomeNumber.text != "") and (txtStreet.text != "") and (txtCity.text != ""))
            contactNote.addAddress(currentPerson,city,street,homeNumber,flatNumber)
        var day = 0

        var month = 0

        var year = 0

        if (txtBirthdayday.text != "")
            if (contactNote.getPersonDateOfBirth(currentPerson).isNotEmpty())
                contactNote.getPersonDateOfBirth(currentPerson)[0].day =
                    txtBirthdayday.text.toInt()
            else {
                day = txtBirthdayday.text.toInt()
            }
        if (txtBirthdaymonth.text != "")
            if (contactNote.getPersonDateOfBirth(currentPerson).isNotEmpty())
                contactNote.getPersonDateOfBirth(currentPerson)[0].month =
                    txtBirthdaymonth.text.toInt()
            else {
                month = txtBirthdaymonth.text.toInt()
            }
        if (txtBirthdayyear.text != "")
            if (contactNote.getPersonDateOfBirth(currentPerson).isNotEmpty())
                contactNote.getPersonDateOfBirth(currentPerson)[0].year =
                    txtBirthdayyear.text.toInt()
            else {
                year = txtBirthdayyear.text.toInt()
            }

        if ((txtBirthdayyear.text != "") and (txtBirthdaymonth.text != "") and (txtBirthdayday.text != "")) {
            contactNote.addDateOfBirth(currentPerson, day, month, year)
        }
        if (txtEmail.text != "")
            if (contactNote.getPersonEmails(currentPerson).isNotEmpty())
                contactNote.getPersonEmails(currentPerson)[0].emailName = txtEmail.text
            else {
                contactNote.addEmail(currentPerson, txtEmail.text)
            }

        if (txtOtherEmail.text != "")
            if (contactNote.getPersonEmails(currentPerson).size > 1)
                contactNote.getPersonEmails(currentPerson)[1].emailName = txtOtherEmail.text
            else {
                contactNote.addEmail(currentPerson, txtOtherEmail.text)
            }

        if (txtPhone.text != "")
            if (contactNote.getPersonPhones(currentPerson).isNotEmpty())
                contactNote.getPersonPhones(currentPerson)[0].number = txtPhone.text
            else {
                contactNote.addPhone(currentPerson, txtPhone.text, PhoneType.MOBILE)
            }

        if (txtHomePhone.text != "")
            if (contactNote.getPersonPhones(currentPerson).size > 1)
                contactNote.getPersonPhones(currentPerson)[1].number = txtHomePhone.text
            else {
                contactNote.addPhone(currentPerson, txtPhone.text, PhoneType.HOME)
            }
    }
*/
    companion object {
        // Заголовки кнопок
        const val SAVE = "SAVE"

        // Размер отступа
        const val PAD = 10

        // Ширина метки
        const val W_L = 100

        //Ширина поля для ввода
        const val W_T = 300

        // высота элемента - общая для всех
        const val H_B = 25
    }


}