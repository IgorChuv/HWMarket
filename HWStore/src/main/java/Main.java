import java.util.*;

public class Main {

    static boolean quit = false;
    static int article = 0;

    public static Map<Integer, Product> productList = new HashMap<>();
    public static List<Product> customerBasket = new ArrayList<>();

    //Single-responsibility principle. Классы выполняют только те функции, для которых они логически были созданы
    //Open-closed principle. Функциональность классов расширяется с помощью наследования и имплиментации
    //Interface segregation principle. Класс SearchByWord имплиментирует интерфейсы Searcher и Logger
    public static SearchByWord searchByWord = new SearchByWord();
    public static SearchByPriceRange searchByPriceRange = new SearchByPriceRange();

    //Правило DRY. Вместо повторения кода создан метод
    public static void addToBasket() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Введите арткул товара, чтобы добавить в корзину или 0 для возврата в меню");
            int suggestion = Integer.parseInt(scanner.nextLine());
            if (suggestion == 0) {
                break;
            }
            if (suggestion > productList.size() || suggestion < 0) {
                System.out.println("Товар с таким артикулом не найден\n");
                continue;
            }
            customerBasket.add(productList.get(suggestion - 1));
            System.out.println("Товар добавлен в корзину\n");
        }
    }

    public static int generateArticle() {
        return article++;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//Liskov substitution principle. Классы Phone и Television наследуют класс Product
        productList.put(generateArticle(), new Phone("IPhone 12 Pro", "Apple", "China", 99900.00, 30, 5, "3", "6.1", 1));
        productList.put(generateArticle(), new Television("Телевизор LG 55UN", "LG", "Japan", 36580.00, 5, 5, "55", 2));
        productList.put(generateArticle(), new Television("Samsung T1000", "Samsung", "Korea", 44300.00, 3, 4, "50", 2));
        productList.put(generateArticle(), new Television("Xiaomi Redmi Note 10T", "Xiaomi", "China", 19990.00, 7, 3, "6.5", 1));

        System.out.println("Добро пожаловать в интернет магазин!");
        while(!quit) {
            System.out.println("\nПожалуйста, выберите действие:\n" +
                    "1.Посмотреть все товары\n" +
                    "2.Поиск товара по названию, производителю или стране производства\n" +
                    "3.Поиск товара по цене\n" +
                    "4.Просмотреть товары в корзине\n" +
                    "5.Выход\n ");

            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1 -> {
                    for (int i = 0; i < productList.size(); i++) {
                        System.out.println((i + 1) + "." + productList.get(i) + "\n");
                    }
                    addToBasket();
                }
                case 2 -> {
                    System.out.println("Вы недавно искали:\n ");
                    searchByWord.getLog();
                    System.out.println("\nВведите слово для поиска:");
                    String searchWord = scanner.nextLine();
                    searchByWord.search(productList, searchWord);
                }
                case 3 -> {
                    System.out.println("Введите диапазон цен через пробел:");
                    String priceRange = scanner.nextLine();
                    searchByPriceRange.search(productList, priceRange);
                }
                case 4 -> {
                    System.out.println("Ваша корзина:");
                    int index = 1;
                    int costSum = 0;
                    for (Product product : customerBasket) {
                        costSum += product.getPrice();
                        System.out.println((index++) + "." + product.getName() + " Цена: " + product.getPrice());

                    }
                    System.out.println("Общая стоимость: " + costSum + " руб.");
                }
                case 5 -> quit = true;
            }
        }
    }
}
