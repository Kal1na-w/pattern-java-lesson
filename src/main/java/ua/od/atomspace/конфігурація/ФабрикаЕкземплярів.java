package ua.od.atomspace.конфігурація;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ФабрикаЕкземплярів  {
    private final Reflections reflections;
    private final НалаштовувачОбєктів налаштовувачОбєктів;

    public ФабрикаЕкземплярів() {
        this.налаштовувачОбєктів = new НалаштовувачОбєктів("ua.od.atomspace");
        this.reflections = new Reflections("ua.od.atomspace");
    }
    
    @SneakyThrows
    public <T> T взятиЕкземпляр(Class<T> clazz) {
        T одинака = взятиОдинака(clazz);

        налаштовувачОбєктів.зробитиВсіНалаштування(одинака);

        return одинака;
    }

    private <T> T взятиОдинака(Class<T> clazz) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class<?> одинак = Arrays.stream(clazz.getDeclaredClasses())
                .filter(innerClass -> innerClass.getSimpleName().equals("Одинак"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не має під класу одинака"));

        return (T) одинак.getMethod("взятиЕкзкмпляр").invoke(одинак);
    }
}
