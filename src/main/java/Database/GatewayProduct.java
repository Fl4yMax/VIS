package Database;

import App.Product;
import App.Worker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class GatewayProduct implements Gateway<Product> {


    @Override
    public Product find(int id) {
        try(PreparedStatement st = Gateway.DBConnection.getConnection().prepareStatement("SELECT product_id, name, count, price FROM Product WHERE product_id = ?;"))
        {
            st.setInt(1, id);
            try(ResultSet rs = st.executeQuery())
            {
                while (rs.next())
                {
                    return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4));
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> loadAllProducts( ){
        List<Product> result = new LinkedList<>();
        try(Statement st = Gateway.DBConnection.getConnection().createStatement()) {
            try(ResultSet rs = st.executeQuery("SELECT product_id, name, count, price FROM Product")) {
                while (rs.next()) {
                    //System.out.println(rs.next());
                    result.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result ;
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
