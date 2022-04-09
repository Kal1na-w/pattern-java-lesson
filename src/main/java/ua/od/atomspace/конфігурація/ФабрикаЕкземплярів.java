package ua.od.atomspace.конфігурація;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import ua.od.atomspace.сервіс.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ФабрикаЕкземплярів  {
    private final НалаштовувачОбєктів налаштовувачОбєктів;
    private final Контекст контекст;

    public ФабрикаЕкземплярів(Контекст контекст) {
        this.контекст = контекст;
        this.налаштовувачОбєктів = new НалаштовувачОбєктів(контекст.getКонфігураціяЗалежностей().getСканер());
    }
    
    @SneakyThrows
    public <T> T створитиЕкземпляр(Class<T> імплементація) {
        T одинака = створитиЕкзкмплярІмплементації(імплементація);

        налаштовувачОбєктів.зробитиВсіНалаштування(одинака, контекст);

        return одинака;
    }

    private <T> T створитиЕкзкмплярІмплементації(Class<? extends T> імплементація) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return імплементація.getDeclaredConstructor().newInstance();
    }
}
