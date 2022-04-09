package ua.od.atomspace.конфігурація;

import lombok.Getter;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class КонфігураціяЗалежностей {

    @Getter
    private final Reflections сканер;

    private final Map<Class, Class> картаЗалежостей;

    public КонфігураціяЗалежностей(String пакет, Map<Class, Class> картаЗалежостей) {
        this.сканер = new Reflections(пакет);
        this.картаЗалежостей = картаЗалежостей;
    }

    @SneakyThrows
    public <T> Class<? extends T> взятиЗалежність(Class<T> інтерфейс) {
        if (картаЗалежостей.containsKey(інтерфейс)) {
            return картаЗалежостей.get(інтерфейс);
        }
        Class<? extends T> реалізація = знайтиРеалізацію(інтерфейс);

        картаЗалежостей.put(інтерфейс, реалізація);

        return реалізація;
    }

    private <T> Class<? extends T> знайтиРеалізацію(Class<T> інтерфейс) throws InterruptedException {
        Set<Class<? extends T>> підТипи = сканер.getSubTypesOf(інтерфейс);
        if (підТипи.size() != 1) {
            throw new RuntimeException("Кількість реалізацій не дорівнюе 1");
        }
        return підТипи.stream()
                .findFirst()
                .orElseThrow(InterruptedException::new);
    }
}
