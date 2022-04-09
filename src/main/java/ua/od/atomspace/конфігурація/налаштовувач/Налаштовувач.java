package ua.od.atomspace.конфігурація.налаштовувач;

import ua.od.atomspace.конфігурація.Контекст;

public interface Налаштовувач {
    <T> void налаштувати(T t, Контекст контекст);
}
