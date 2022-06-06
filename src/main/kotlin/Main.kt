import model.ContactService
import view.MainJFramePanel
import javax.swing.*

var contactNote = ContactService()

fun main() {
    SwingUtilities.invokeLater {
        val telephoneNote = MainJFramePanel()
        telephoneNote.isVisible = true
    }
}