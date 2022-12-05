package Database;

import App.Order;

public class GatewayOrder implements Gateway<Order>{


    @Override
    public Order find(int id) {
        return null;
    }

    @Override
    public boolean create(Order obj) {
        return false;
    }

    @Override
    public boolean update(Order obj) {
        return false;
    }

    @Override
    public boolean delete(Order obj) {
        return false;
    }
}
