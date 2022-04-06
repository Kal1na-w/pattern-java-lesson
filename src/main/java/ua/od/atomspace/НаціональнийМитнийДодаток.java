package ua.od.atomspace;

import lombok.SneakyThrows;
import ua.od.atomspace.сервіс.МитнеМіністерствоУкраїни;

public class НаціональнийМитнийДодаток {

    @SneakyThrows
    public static void main(String[] args) {
        МитнеМіністерствоУкраїни митнеМіністерствоУкраїни = new МитнеМіністерствоУкраїни();
        митнеМіністерствоУкраїни.початиЗміну();
    }

}
