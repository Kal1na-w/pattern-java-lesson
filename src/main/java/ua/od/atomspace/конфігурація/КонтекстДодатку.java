package ua.od.atomspace.конфігурація;

import lombok.Getter;

import java.util.HashMap;

public class КонтекстДодатку {

    public static Контекст зформувати(String пакет, HashMap<Class, Class> мапаЗалежностей) {
        КонфігураціяЗалежностей конфігураціяЗалежностей = new КонфігураціяЗалежностей(пакет, мапаЗалежностей);
        Контекст контекст = new Контекст(конфігураціяЗалежностей);
        ФабрикаЕкземплярів фабрикаЕкземплярів = new ФабрикаЕкземплярів(контекст);
        контекст.setФабрикаЕкземплярів(фабрикаЕкземплярів);

        return контекст;
    }
}
