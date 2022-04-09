package ua.od.atomspace.сервіс;


import ua.od.atomspace.конфігурація.анотація.ЗчитатиПараметр;
import ua.od.atomspace.модель.ВідповідьМитніці;

public class МіграційнаСлужбаУкраїни implements МіграційнаСлужба {

    @ЗчитатиПараметр
    private String часиРоботи;

    @Override
    public void мігрувати(ВідповідьМитніці відповідьМитніці) {
        System.out.println(" ---> Ми працюємо " + this.часиРоботи);
        if (відповідьМитніці.isПідтвердженний()) {
            System.out.println(" ---> Тримайте квиток до Києва");
            return;
        }
        System.out.println(" ---> Наздогоняйте руській корабль");
    }

}
