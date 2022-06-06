package view

import model.Contact
import model.PhoneType
import contactNote
import model.Person
import java.awt.Rectangle
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*
//Dialog for insert person
class EditContactDialog : JDialog(),
    ActionListener {
    // Поле для ввода Имени
    private val txtFirstName = JTextPane()
    // Поле для ввода Фамилии
    private val txtLastName = JTextPane()
    // Поле для ввода Моб.Телефона
    private val txtMobPhone = JTextPane()
    // Поле для ввода Дом.Телефона
    private val txtHomePhone = JTextPane()
    // Поле для ввода E-mail
    private val txtEmail = JTextPane()
    // Поле для ввода Доп.E-mail
    private val txtOtherEmail = JTextPane()
    // Поле для ввода дня рождения
    private val txtBirthdayday = JTextPane()
    private val txtBirthdaymonth = JTextPane()
    private val txtBirthdayyear = JTextPane()
    // Поле для ввода адреса
    private val txtCity = JTextPane()
    private val txtStreet = JTextPane()
    private val txtHomeNumber = JTextPane()
    private val txtFlatNumber = JTextPane()


    var isSave = false
        private set

    init {
        layout = null
        buildFields()
        buildButtons()
        isModal = true
        isResizable = false
        setBounds(500, 500, 500, 350)
        isVisible = true
    }

    // Размещаем метки и поля ввода на форме
    private fun buildFields() {
        // Набор метки и поля для Имени
        val lblFirstName = JLabel("Name:")
        // Выравнивание текста с правой стороны
        lblFirstName.horizontalAlignment = SwingConstants.RIGHT
        // Выставляем координаты метки
        lblFirstName.bounds = Rectangle(PAD, 0 * H_B + PAD, W_L, H_B)
        // Кладем метку на форму
        add(lblFirstName)
        // Выставляем координаты поля
        txtFirstName.bounds = Rectangle(W_L + 2 * PAD, 0 * H_B + PAD, W_T, H_B)
        // Делаем "бордюр" для поля
        txtFirstName.border = BorderFactory.createEtchedBorder()
        // Кладем поле на форму
        add(txtFirstName)

        // Набор метки и поля для Фамилии
        val lblLastName = JLabel("Family Name:")
        lblLastName.horizontalAlignment = SwingConstants.RIGHT
        lblLastName.bounds = Rectangle(PAD, 1 * H_B + PAD, W_L, H_B)
        add(lblLastName)
        txtLastName.bounds = Rectangle(W_L + 2 * PAD, 1 * H_B + PAD, W_T, H_B)
        txtLastName.border = BorderFactory.createEtchedBorder()
        add(txtLastName)

        // Набор метки и поля для Телефона
        val lblMobPhone = JLabel("Мобильный телефон:")
        lblMobPhone.horizontalAlignment = SwingConstants.RIGHT
        lblMobPhone.bounds = Rectangle(PAD, 2 * H_B + PAD, W_L, H_B)
        add(lblMobPhone)
        txtMobPhone.bounds = Rectangle(W_L + 2 * PAD, 2 * H_B + PAD, W_T, H_B)
        txtMobPhone.border = BorderFactory.createEtchedBorder()
        add(txtMobPhone)

        val lblHomePhone = JLabel("Домашний телефон:")
        lblHomePhone.horizontalAlignment = SwingConstants.RIGHT
        lblHomePhone.bounds = Rectangle(PAD, 3 * H_B + PAD, W_L, H_B)
        add(lblHomePhone)
        txtHomePhone.bounds = Rectangle(W_L + 2 * PAD, 3 * H_B + PAD, W_T, H_B)
        txtHomePhone.border = BorderFactory.createEtchedBorder()
        add(txtHomePhone)

        // Набор метки и поля для Email
        val lblEmail = JLabel("Email:")
        lblEmail.horizontalAlignment = SwingConstants.RIGHT
        lblEmail.bounds = Rectangle(PAD, 4 * H_B + PAD, W_L, H_B)
        add(lblEmail)
        txtEmail.bounds = Rectangle(W_L + 2 * PAD, 4 * H_B + PAD, W_T, H_B)
        txtEmail.border = BorderFactory.createEtchedBorder()
        add(txtEmail)

        // Набор метки и поля для Email
        val lblOtherEmail = JLabel("Доп. email:")
        lblOtherEmail.horizontalAlignment = SwingConstants.RIGHT
        lblOtherEmail.bounds = Rectangle(PAD, 5 * H_B + PAD, W_L, H_B)
        add(lblOtherEmail)
        txtOtherEmail.bounds = Rectangle(W_L + 2 * PAD, 5 * H_B + PAD, W_T, H_B)
        txtOtherEmail.border = BorderFactory.createEtchedBorder()
        add(txtOtherEmail)

        // Набор метки и поля для Birthday
        val lblBirthday = JLabel("День рождения:")
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

        val lblCity = JLabel("Город:")
        lblCity.horizontalAlignment = SwingConstants.RIGHT
        lblCity.bounds = Rectangle(PAD, 7 * H_B + PAD, W_L, H_B)
        add(lblCity)



        txtCity.bounds = Rectangle(W_L + 2 * PAD, 7 * H_B + PAD, W_T, H_B)
        txtCity.border = BorderFactory.createEtchedBorder()
        add(txtCity)

        val lblStreet = JLabel("Улица:")
        lblStreet.horizontalAlignment = SwingConstants.RIGHT
        lblStreet.bounds = Rectangle(PAD, 8 * H_B + PAD, W_L, H_B)
        add(lblStreet)
        txtStreet.bounds = Rectangle(W_L + 2 * PAD, 8 * H_B + PAD, W_T, H_B)
        txtStreet.border = BorderFactory.createEtchedBorder()
        add(txtStreet)

        val lblHomeNumber = JLabel("Дом:")
        lblHomeNumber.horizontalAlignment = SwingConstants.RIGHT
        lblHomeNumber.bounds = Rectangle(PAD, 9 * H_B + PAD, W_L, H_B)
        add(lblHomeNumber)
        txtHomeNumber.bounds = Rectangle(W_L + 2 * PAD, 9 * H_B + PAD, W_T, H_B)
        txtHomeNumber.border = BorderFactory.createEtchedBorder()
        add(txtHomeNumber)

        val lblFlatNumber = JLabel("Квартира:")
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
        btnSave.actionCommand = SAVE
        btnSave.addActionListener(this)
        btnSave.bounds = Rectangle(
            PAD, 11 * H_B + PAD,
            W_B,
            H_B
        )
        add(btnSave)

        val btnCancel = JButton("Отменить")
        btnCancel.actionCommand = CANCEL
        btnCancel.addActionListener(this)
        btnCancel.bounds = Rectangle(
            W_B + 2 * PAD, 11 * H_B + PAD,
            W_B,
            H_B
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

    fun addInfo() {
        val person : Person
        if ((txtLastName.text != "") or (txtFirstName.text != "")) {
            person = Person(txtFirstName.text, txtLastName.text)
            val mobPhone: Contact.Phone
            if (txtMobPhone.text != "") {
                mobPhone = Contact.Phone(txtMobPhone.text, PhoneType.MOBILE)
                contactNote.addContact(person, mobPhone)
            }

            val homePhone: Contact.Phone
            if (txtHomePhone.text != "") {
                homePhone = Contact.Phone(txtHomePhone.text, PhoneType.HOME)
                contactNote.addContact(person, homePhone)
            }
            val email: Contact.Email
            val otherEmail: Contact.Email
            if (txtEmail.text != "") {
                email = Contact.Email(txtEmail.text)
                contactNote.addContact(person, email)
            }
            if (txtOtherEmail.text != "") {
                otherEmail = Contact.Email(txtOtherEmail.text)
                contactNote.addContact(person, otherEmail)
            }
            if ((txtBirthdayday.text != "") and (txtBirthdaymonth.text != "") and (txtBirthdayyear.text != "")) {
                val date = Contact.DateOfBirth(
                    txtBirthdayday.text.toInt(),
                    txtBirthdaymonth.text.toInt(),
                    txtBirthdayyear.text.toInt()
                )
                contactNote.addContact(person, date)
            }

            val address: Contact.Address
            if ((txtCity.text != "") and (txtStreet.text != "") and (txtHomeNumber.text != "") and (txtFlatNumber.text != "")) {
                address = Contact.Address(txtCity.text, txtStreet.text, txtHomeNumber.text, txtFlatNumber.text)
                contactNote.addContact(person, address)
            }

        }
    }

    fun checkContactWithoutPhone(): Int{
        if ((txtHomePhone.text == "") and (txtMobPhone.text == ""))
            return 0
        return 1
    }

    fun checkContactWithoutNameOrSurname() : Int{
        if ((txtFirstName.text == "") and (txtLastName.text == ""))
            return 0
        return 1
    }

    companion object {
        // Заголовки кнопок
        const val SAVE = "SAVE"
        const val CANCEL = "CANCEL"

        // Размер отступа
        const val PAD = 10

        // Ширина метки
        const val W_L = 100

        //Ширина поля для ввода
        const val W_T = 300

        // Ширина кнопки
        const val W_B = 120

        // высота элемента - общая для всех
        const val H_B = 25
    }
}