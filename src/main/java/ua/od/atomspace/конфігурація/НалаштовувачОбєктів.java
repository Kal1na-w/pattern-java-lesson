package ua.od.atomspace.конфігурація;

import org.reflections.Reflections;
import ua.od.atomspace.конфігурація.налаштовувач.Налаштовувач;

import java.lang.reflect.InvocationTargetException;

public class НалаштовувачОбєктів {

    private final Reflections reflections;

    public НалаштовувачОбєктів(String path) {
        this.reflections = new Reflections(path);
    }

    public <T> void зробитиВсіНалаштування(T t) {
        reflections.getSubTypesOf(Налаштовувач.class)
                .forEach(налаштовувач -> {
                    try {
                        налаштовувач.getDeclaredConstructor().newInstance().налаштувати(t);
                    } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
