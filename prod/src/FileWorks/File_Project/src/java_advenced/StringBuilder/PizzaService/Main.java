package java_advenced.StringBuilder.PizzaService;

import java_advenced.StringBuilder.PizzaService.Pizza.Pizza;
import java_advenced.StringBuilder.PizzaService.Pizza.PizzaUtils;

import java.util.List;

public class Main {

    static void main(String[] args) {
        List<Pizza> menu = List.of(
                new Pizza("Маргарита", 500),
                new Pizza("Пепперони", 550)
        );

        System.out.println(PizzaUtils.buildMenu(menu));
    }


}
