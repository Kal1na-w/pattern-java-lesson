package ua.od.atomspace.конфігурація;

import org.reflections.Reflections;
import ua.od.atomspace.конфігурація.налаштовувач.Налаштовувач;

import java.lang.reflect.InvocationTargetException;

public class НалаштовувачОбєктів {

    private final Reflections reflections;

    public НалаштовувачОбєктів(Reflections reflections) {
        this.reflections = reflections;
    }

    public <T> void зробитиВсіНалаштування(T t, Контекст контекст) {
        reflections.getSubTypesOf(Налаштовувач.class)
                .forEach(налаштовувач -> {
                    try {
                        налаштовувач.getDeclaredConstructor().newInstance().налаштувати(t, контекст);
                    } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
