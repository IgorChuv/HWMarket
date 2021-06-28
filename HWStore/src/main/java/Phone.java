import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Phone extends Product implements Supportable {
    private final String numberOfCameras;
    private final String displayDiagonal;
    private final int yearsWarranty;

    public Phone(String name, String manufacturer, String madeIn, double price, int quantity, int rate, String numberOfCameras, String displayDiagonal, int yearsWarranty) {
        super(name, manufacturer, madeIn, price, quantity, rate);
        this.numberOfCameras = numberOfCameras;
        this.displayDiagonal = displayDiagonal;
        this.yearsWarranty = yearsWarranty;
    }

    @Override
    public String warrantySupport(LocalDateTime purchaseDate) {

        return purchaseDate.withYear(purchaseDate.getYear() + yearsWarranty).format(DateTimeFormatter.ofPattern("dd.MM.yyyy г."));
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nХарактеристики: "
                + "\nКоличество камер: " + numberOfCameras
                + "\nДиагональ экрана: " + displayDiagonal
                + "\nСрок гарантии: " + yearsWarranty + " год";
    }
}
