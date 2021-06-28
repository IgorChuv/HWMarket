public abstract class Product {
    private final String name;
    private final String manufacturer;
    private final String madeIn;
    private final double price;
    private final int quantity;
    private final int rate;

    public Product(String name, String manufacturer, String madeIn, double price, int quantity, int rate) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.rate = rate;
        this.price = price;
        this.madeIn = madeIn;


    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getRate() {
        return rate;
    }

    public String getMadeIn() {
        return madeIn;
    }

    @Override
    public String toString() {
        return name +
                "\nПроизводитель: " + manufacturer +
                "\nЦена:" + price + " руб." +
                "\nКоличество на складе: " + quantity +
                "\nРейтинг: " + rate;
    }
}
