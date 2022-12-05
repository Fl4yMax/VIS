package Database;

import App.Product;

public class GatewayProduct implements Gateway<Product> {


    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public boolean create(Product obj) {
        return false;
    }

    @Override
    public boolean update(Product obj) {
        return false;
    }

    @Override
    public boolean delete(Product obj) {
        return false;
    }
}
