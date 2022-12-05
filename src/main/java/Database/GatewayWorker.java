package Database;

import App.Worker;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class GatewayWorker implements Gateway<Worker> {
    public GatewayWorker()
    {
    }

    public List<Worker> loadAllWorkers( ){
        List<Worker> result = new LinkedList<>();
        try(Statement st = Gateway.DBConnection.getConnection().createStatement()) {
            try(ResultSet rs = st.executeQuery("SELECT worker_id, firstName, lastName, rank, phone_number, email, address, postal_code, password, login FROM Worker")) {
                while (rs.next()) {
                    //System.out.println(rs.next());
                    result.add(new Worker(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getString(10)));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result ;
    }

    @Override
    public Worker find(int id) {
        try(PreparedStatement st = Gateway.DBConnection.getConnection().prepareStatement("SELECT worker_id, firstName, lastName, rank, login FROM Worker WHERE worker_id = ?;"))
        {
            st.setInt(1, id);
            try(ResultSet rs = st.executeQuery())
            {
                while (rs.next())
                {

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

    @Override
    public boolean create(Worker obj) {
        try(PreparedStatement st = Gateway.DBConnection.getConnection().prepareStatement("INSERT INTO Worker( firstName, lastName, rank, phone_number, email, address, postal_code, password, login) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS))
        {
            st.setString( 1, obj.getFirstName());
            st.setString( 2, obj.getLastName());
            st.setString( 3, obj.getRank());
            st.setString( 4, obj.getPhone_number());
            st.setString( 5, obj.getEmail());
            st.setString( 6, obj.getAddress());
            st.setInt(7, obj.getPostalCode());
            st.setString( 8, obj.getPassword());
            st.setString( 9, obj.getLogin());

            st.execute();

            try(ResultSet rs = st.getGeneratedKeys())
            {
                if (rs.next()) {
                    // Food
                    obj.setWorkerId(rs.getInt(1));
                }
                return true;
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
        return false;
    }

    @Override
    public boolean update(Worker obj) {
        return false;
    }

    @Override
    public boolean delete(Worker obj) {
        try(PreparedStatement st = Gateway.DBConnection.getConnection().prepareStatement("DELETE FROM Worker WHERE worker_id = ?;"))
        {
            st.setInt(1, obj.getId());
            st.execute();
            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
