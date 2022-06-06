package view

import contactNote
import model.PhoneType
import java.awt.Rectangle
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*

class InformationAboutContactDialogUI constructor(i: Int, buttonRow: MutableList<JButton>) : JDialog(),
    ActionListener {
    private var k = i
    private val but = buttonRow[k]
    init {
        layout = null

        val lblFirstName = JLabel("Имя:" + contactNote.getAllPersons()[k].firstName)
        lblFirstName.horizontalAlignment = SwingConstants.LEFT
        lblFirstName.bounds = Rectangle(
            EditContactDialog.PAD, 0 * EditContactDialog.H_B + EditContactDialog.PAD,
            W_B + 2 * PAD + 140,
            EditContactDialog.H_B
        )
        add(lblFirstName)

        val lblLastName = JLabel("Фамилия:" + contactNote.getAllPersons()[k].lastName)
        lblLastName.horizontalAlignment = SwingConstants.LEFT
        lblLastName.bounds = Rectangle(
            EditContactDialog.PAD, 1 * EditContactDialog.H_B + EditContactDialog.PAD,
            W_B + 2 * PAD + 140,
            EditContactDialog.H_B
        )
        add(lblLastName)
        contactNote.getAllPersons()
        if (contactNote.getPersonPhones(contactNote.getAllPersons()[k]).isNotEmpty()) {
            if (contactNote.getPersonPhones(contactNote.getAllPersons()[k])[0].phoneType == PhoneType.MOBILE) {
                val lblNumber =
                    JLabel("Моб. номер:" + contactNote.getPersonPhones(contactNote.getAllPersons()[k])[0].number)
                lblNumber.horizontalAlignment = SwingConstants.LEFT
                lblNumber.bounds = Rectangle(
                    EditContactDialog.PAD, 2 * EditContactDialog.H_B + EditContactDialog.PAD,
                    W_B + 2 * PAD + 140,
                    EditContactDialog.H_B
                )
                add(lblNumber)
            }
        }
        if (contactNote.getPersonPhones(contactNote.getAllPersons()[k]).size > 1) {
            if (contactNote.getPersonPhones(contactNote.getAllPersons()[k])[1].phoneType == PhoneType.HOME) {
                val lblNumber =
                    JLabel("Дом. номер:" + contactNote.getPersonPhones(contactNote.getAllPersons()[k])[1].number)
                lblNumber.horizontalAlignment = SwingConstants.LEFT
                lblNumber.bounds = Rectangle(
                    EditContactDialog.PAD, 3 * EditContactDialog.H_B + EditContactDialog.PAD,
                    W_B + 2 * PAD + 140,
                    EditContactDialog.H_B
                )
                add(lblNumber)
            }
        }
        if (contactNote.getPersonEmails(contactNote.getAllPersons()[k]).isNotEmpty()) {
            val lblEmail = JLabel("Email:" + contactNote.getPersonEmails(contactNote.getAllPersons()[k])[0].emailName)
            lblEmail.horizontalAlignment = SwingConstants.LEFT
            lblEmail.bounds = Rectangle(
                EditContactDialog.PAD, 4 * EditContactDialog.H_B + EditContactDialog.PAD,
                W_B + 2 * PAD + 140,
                EditContactDialog.H_B
            )
            add(lblEmail)
        }

        if (contactNote.getPersonEmails(contactNote.getAllPersons()[k]).size > 1) {
            val lblOtherEmail = JLabel("Доп. email:" + contactNote.getPersonEmails(contactNote.getAllPersons()[k])[1].emailName)
            lblOtherEmail.horizontalAlignment = SwingConstants.LEFT
            lblOtherEmail.bounds = Rectangle(
                EditContactDialog.PAD, 5 * EditContactDialog.H_B + EditContactDialog.PAD,
                W_B + 2 * PAD + 140,
                EditContactDialog.H_B
            )
            add(lblOtherEmail)
        }

        if (contactNote.getPersonDateOfBirth(contactNote.getAllPersons()[k]).isNotEmpty()) {
            val lblDateOfBirth =
                JLabel(
                    "День рождения:" + contactNote.getPersonDateOfBirth(contactNote.getAllPersons()[k])[0].day + " " +
                            contactNote.getPersonDateOfBirth(contactNote.getAllPersons()[k])[0].month + " " + contactNote.getPersonDateOfBirth(
                        contactNote.getAllPersons()[k]
                    )[0].year
                )
            lblDateOfBirth.horizontalAlignment = SwingConstants.LEFT
            lblDateOfBirth.bounds = Rectangle(
                EditContactDialog.PAD, 6 * EditContactDialog.H_B + EditContactDialog.PAD,
                W_B + 2 * PAD + 140,
                EditContactDialog.H_B
            )
            add(lblDateOfBirth)
        }

        if (contactNote.getPersonAddreses(contactNote.getAllPersons()[k]).isNotEmpty()) {
            val lblAddress =
                JLabel(
                    "Адрес: " + contactNote.getPersonAddreses(contactNote.getAllPersons()[k])[0].city + " " +
                            contactNote.getPersonAddreses(contactNote.getAllPersons()[k])[0].street + " дом " + contactNote.getPersonAddreses(
                        contactNote.getAllPersons()[k]
                    )[0].homeNumber + " кв" + contactNote.getPersonAddreses(contactNote.getAllPersons()[k])[0].flatNumber
                )
            lblAddress.horizontalAlignment = SwingConstants.LEFT
            lblAddress.bounds = Rectangle(
                EditContactDialog.PAD, 7 * EditContactDialog.H_B + EditContactDialog.PAD,
                500,
                EditContactDialog.H_B
            )
            add(lblAddress)
        }
        buildButtons(i, buttonRow)
        // Диалог в модальном режиме - только он активен
        isModal = true
        // Запрещаем изменение размеров
        isResizable = false
        // Выставляем размеры формы
        setBounds(300, 300, 450, 310)
        // Делаем форму видимой
        isVisible = true
    }


    // Размещаем кнопки на форме
    private fun buildButtons(i: Int, buttonRow: MutableList<JButton>) {
        val btnDelete = JButton("Удалить")
        k
        buttonRow.size
        btnDelete.addActionListener {
            buttonRow[k].parent.remove(buttonRow[k])
            k--
            revalidate()
            repaint()
            isVisible = false
        }
        btnDelete.bounds = Rectangle(
            PAD, 9 * H_B + PAD,
            W_B + 10,
            30
        )
        add(btnDelete)

        val btnCancel = JButton("Отменить")
        btnCancel.actionCommand = CANCEL
        btnCancel.addActionListener(this)
        btnCancel.bounds = Rectangle(
            W_B + 2 * PAD + 10, 9 * H_B + PAD,
            W_B,
            30
        )
        add(btnCancel)

        val btnChange = JButton("Редактировать")
        btnChange.addActionListener {
            val ccd = ChangeContactDialogUI()
            //ccd.changeInfo(but, i)
            revalidate()
            repaint()
            isVisible = false
        }
        btnChange.bounds = Rectangle(
            W_B + 2 * PAD + 140, 9 * H_B + PAD,
            W_B + 10,
            30
        )
        add(btnChange)

        val btnExport = JButton("Экспорт Vcard")
        btnExport.addActionListener {
            //contactNote.exportVcardFile(i)
            isVisible = false
        }
        btnExport.bounds = Rectangle(
            W_B + 2 * PAD + 150, 9 * H_B + PAD-230,
            W_B + 10,
            30
        )
        add(btnExport)
    }

    override fun actionPerformed(ae: ActionEvent) {
        // Если нажали кнопку SAVE (сохранить изменения) - запоминаем этой
        // Закрываем форму
        isVisible = false
    }


    companion object {
        const val CANCEL = "CANCEL"

        // Размер отступа
        const val PAD = 10

        // Ширина кнопки
        const val W_B = 120

        // высота элемента - общая для всех
        const val H_B = 25
    }

}