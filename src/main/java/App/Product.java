package App;

public class Product {
    private String name;
    private float price;
    private int count;

    private int product_id;

    private Part[] parts;

    public Product(String name, int count, float price) {
        this.name = name;
        this.price = price;
        this.count = count;
    }
    public Product(int product_id, String name, int count, float price) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.product_id = product_id;
    }

    public int getId()
    {
        return this.product_id;
    }
    public String getName()
    {
        return this.name;
    }
    public int getCount()
    {
        return this.count;
    }
    public float getPrice()
    {
        return this.price;
    }
}