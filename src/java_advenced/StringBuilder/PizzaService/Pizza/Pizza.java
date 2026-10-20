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
        String t = title == null ? "" : title.trim();
        if (title != null  &&  title.length() > 2 && title.length() < 30) {
            this.title = title;
        }
        else {
            System.out.println("Enter valid title!");
        }

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
