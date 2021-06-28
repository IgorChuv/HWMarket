import java.util.*;

public class SearchByPriceRange implements Searcher {

    @Override
    public void search(Map<Integer, Product> list, String word) {
        String[] range = word.split(" ");
        System.out.println("Результаты поиска:\n");
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            Product item = list.get(i);
            if (Integer.parseInt(range[0]) <= item.getPrice() && Integer.parseInt(range[1]) >= item.getPrice()) {
                System.out.println((i + 1) + "." + item.toString() + "\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Поиск не дал результатов");
        }
    }
}
