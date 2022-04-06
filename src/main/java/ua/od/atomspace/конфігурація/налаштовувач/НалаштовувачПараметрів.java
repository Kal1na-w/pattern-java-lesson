package ua.od.atomspace.конфігурація.налаштовувач;

import ua.od.atomspace.конфігурація.анотація.ЗчитатиПараметр;

import java.io.*;
import java.util.Arrays;

public class НалаштовувачПараметрів implements Налаштовувач {
    @Override
    public <T> void налаштувати(T t) {
        Arrays.stream(t.getClass().getDeclaredFields())
                .filter(field -> field.getAnnotation(ЗчитатиПараметр.class) != null)
                .forEach(field -> {
                    String значення = зчитатиПараметр(field.getName());
                    try {
                        field.setAccessible(true);
                        field.set(t, значення);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } finally {
                        field.setAccessible(false);
                    }
                });
    }

    public String зчитатиПараметр(String ключ) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("application.properties"))) {
            while (bufferedReader.ready()) {
                String[] ключТаЗначення = bufferedReader.readLine().split(": ");;
                if (ключТаЗначення[0].equals(ключ)) {
                    return ключТаЗначення[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Такого параметру взагалі нема!!!");
    }

}
