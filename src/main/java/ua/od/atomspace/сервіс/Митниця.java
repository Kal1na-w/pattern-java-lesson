package ua.od.atomspace.сервіс;

import ua.od.atomspace.модель.ВідповідьМитніці;
import ua.od.atomspace.модель.Людина;

public interface Митниця {
    ВідповідьМитніці обробитиЛюдину(Людина людина);
}
