package ua.od.atomspace.сервіс;

import ua.od.atomspace.модель.Людина;

import java.util.Random;

public class МоноМитнаПеревірка implements МитнаПеревірка {
    @Override
    public boolean перевірити(Людина людина) {
        System.out.println(" ---> Де найближче відділення монобанку?");
        if(new Random().nextInt(2) % 2 == 0) {
            System.out.println("Та тут недалеко! <----");
            return false;
        }
        System.out.println("Моно не має відділень! <---");
        System.out.println(" ---> Ну тоді моно проходити");
        return true;
    }

}
