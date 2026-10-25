package java_advenced.StringBuilder.PizzaService.Pizza;

import java.util.List;
import java.util.Locale;

public class Pizza {
    private String title;
    private double cost;


    public Pizza(String title, double cost) {
        setTitle(title);
        setCost(cost);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Название не может быть null");
        }
        String trimmed = title.trim();
        if (trimmed.length() < 2 || trimmed.length() > 30) {
            throw new IllegalArgumentException(
                    "Название должно быть от 2 до 30 символов, получено: " + trimmed.length()
            );

        }
        this.title = trimmed;


    }

    public  double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if (cost > 0 && cost <= 5000) {
            this.cost = cost;
        }
        else {
            System.out.println("Enter valid cost!");
        }

    }


}
