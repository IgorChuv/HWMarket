import java.util.*;


public class SearchByWord implements Searcher, SearchLogger {

    public static Set<String> searchQueryStorage = new HashSet<>();

    @Override
    public void search(Map<Integer, Product> list, String word) {
        System.out.println("Результаты поиска:\n");
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            Product item = list.get(i);
            if (item.getName().contains(word) || item.getManufacturer().contains(word) || item.getMadeIn().contains(word)) {
                System.out.println((i + 1) + "." + item.toString() + "\n");
                found = true;
                log(item.getName());
            }
        }
        if (!found) {
            System.out.println("Поиск не дал результатов");
        }

    }

    @Override
    public void log(String searchQuery) {

        searchQueryStorage.add(searchQuery);

    }

    public void getLog() {
        for (String item : searchQueryStorage) {
            System.out.println(item);
        }
    }

}


