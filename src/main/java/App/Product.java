package App;

public class Product {
    private String name;
    private int price;
    private int count;
    private int made;

    private Part[] parts;

    public Product(String name, int price, int count, Part[] parts) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.made = 0;
        this.parts = parts;
    }
}
