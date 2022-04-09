package ua.od.atomspace.конфігурація;

import lombok.Getter;
import lombok.Setter;
import ua.od.atomspace.сервіс.*;

import java.util.HashMap;
import java.util.Map;

public class Контекст {

    @Getter
    private final КонфігураціяЗалежностей конфігураціяЗалежностей;
    private final Map<Class, Object> одинаки = new HashMap<>();
    @Setter
    private ФабрикаЕкземплярів фабрикаЕкземплярів;

    public Контекст(КонфігураціяЗалежностей конфігураціяЗалежностей) {
        this.конфігураціяЗалежностей = конфігураціяЗалежностей;
    }

    public <T> T взятиЕкземпляр(Class<T> клас) {
        if (одинаки.containsKey(клас)) {
            return (T) одинаки.get(клас);
        }

        Class<? extends T> імплементація = клас;
        if (клас.isInterface()) {
            імплементація = конфігураціяЗалежностей.взятиЗалежність(клас);
        }

        T реалізаця = фабрикаЕкземплярів.створитиЕкземпляр(імплементація);

        одинаки.put(імплементація, реалізаця);

        return реалізаця;
    }
}
