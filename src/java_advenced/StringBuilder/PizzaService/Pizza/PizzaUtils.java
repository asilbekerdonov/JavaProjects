package java_advenced.StringBuilder.PizzaService.Pizza;

import java.util.List;
import java.util.Locale;

public class PizzaUtils {
    public static String normalizeName(String title) {

        if (title == null || title.isBlank()) {
            return "";
        }

        String trimmed = title.trim();
        return trimmed.substring(0,1).toUpperCase(Locale.ROOT) +
                trimmed.substring(1).toLowerCase(Locale.ROOT);
    }

    public static String formatPrice(String title, double cost) {
        return  new StringBuilder()
        .append(title)
                .append(" — ")
                .append(String.format(Locale.ROOT,"%.2f", cost))
                .append(" ₽")
                .toString();
    }


    public static String buildMenu(List<Pizza> pizzas) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < pizzas.size(); i++) {
            if (i > 0) sb.append(System.lineSeparator());
            Pizza p = pizzas.get(i);
            sb.append(i + 1)
                .append(". ")
                    .append(formatPrice(p.getTitle(), p.getCost()));
        }
        return sb.toString();
    }
}
