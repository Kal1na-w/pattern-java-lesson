package ua.od.atomspace.сервіс;

import ua.od.atomspace.конфігурація.анотація.Інєкція;
import ua.od.atomspace.конфігурація.анотація.ЗчитатиПараметр;
import ua.od.atomspace.модель.ВідповідьМитніці;
import ua.od.atomspace.модель.Людина;

public class МитницяОдеси implements Митниця {

    @ЗчитатиПараметр
    private String кодовеСлово;

    @Інєкція
    private МитнаПеревірка митнаПеревірка;

    public ВідповідьМитніці обробитиЛюдину(Людина людина) {
        // винести вирок
        return new ВідповідьМитніці(людина, митнаПеревірка.перевірити(людина));
    }

}
