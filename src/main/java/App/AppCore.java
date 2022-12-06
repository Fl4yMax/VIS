package App;

import Database.GatewayProduct;
import Database.GatewayWorker;

import java.util.LinkedList;
import java.util.List;

public class AppCore {
    private Worker loggedIn;
    private GatewayWorker dbWorker;
    private GatewayProduct dbProduct;
    private List<Worker> workers;

    private List<Worker> workersView;
    private List<Product> products;

    private boolean loadFromDB = true;

    private int currW = 1;


    public AppCore()
    {
        super();
        dbWorker = new GatewayWorker();
        dbProduct = new GatewayProduct();
        workers = dbWorker.loadAllWorkers();
        products = dbProduct.loadAllProducts();
        workersView = new LinkedList<>();
        setWorkersView();
    }

    public boolean getLoadInformation()
    {
        return this.loadFromDB;
    }
    public void clearAll()
    {
        workers.clear();
        products.clear();
    }
    public List<Worker> getWorkers()
    {
        return workers;
    }

    public String getRank()
    {
        return loggedIn.getRank();
    }

    public Worker getLoggedIn()
    {
        return this.loggedIn;
    }

    public void setCurrW(boolean ud) //true -> up, false -> down
    {
        if(ud)
        {
            if(currW < workersView.size())
            {
                this.currW++;
            }
            else
            {
                this.currW = 1;
            }
        }
        else
        {
            if(currW - 1 > 0)
            {
                this.currW--;
            }
            else
            {
                this.currW = workersView.size();
            }
        }
    }

    public int getCurrW()
    {
        return this.currW;
    }

    public List<Worker> getWorkerProduct()
    {
        return this.workersView;
    }
    public List<Product> getProducts(){return this.products;}

    public boolean authentication(String login, String password)
    {
        for(Worker wor : workers)
        {
            String wLogin = wor.getCredentials().getKey();
            String wPassword = wor.getCredentials().getValue();
            if(wLogin.equals(login) && wPassword.equals(password))
            {
                this.loggedIn = wor;
                return true;
            }
            else if(login == "" || password == "")
            {
                return false;
            }
        }
        return false;
    }

    public void updateUser(String firstName, String lastName, String phoneNumber, String email, String address)
    {
        if(!firstName.equals(""))
        {
            loggedIn.updateFirstName(firstName);
        }
        if(!lastName.equals(""))
        {
            loggedIn.updateLastName(lastName);
        }
        if(!phoneNumber.equals(""))
        {
            loggedIn.updatePhoneNumber(phoneNumber);
        }
        if(!email.equals(""))
        {
            loggedIn.updateEmail(email);
        }
        if(!address.equals(""))
        {
            loggedIn.updateAddress(address);
        }
        dbWorker.update(loggedIn);
        loggedIn = dbWorker.find(loggedIn.getId());
    }

    public void updateWorker(Worker w)
    {
        dbWorker.update(w);
        reloadWorkers();
    }

    public void createUser(String firstName, String lastName, String rank, String phone_number, String email, String address, String password, String username)
    {
        dbWorker.create(new Worker(firstName, lastName, rank, phone_number, email, address, 77777, password, username));
        reloadWorkers();
    }

    public void deleteUser(Worker w)
    {
        dbWorker.delete(w);
        reloadWorkers();
    }

    public Worker findWorker(int id)
    {
        return dbWorker.find(id);
    }

    public void setWorkersView()
    {
        this.workersView.clear();
        for(Worker wor : workers)
        {
            if(wor.getRank().equals("pracovnik"))
            {
                this.workersView.add(wor);
            }
        }
    }
    public void reloadWorkers()
    {
        this.workers.clear();
        this.workers = dbWorker.loadAllWorkers();
    }
    public void logOff()
    {
        this.loggedIn = null;
    }

    public Product findProduct(int id)
    {
        return dbProduct.find(id);
    }

    public void loadWorkers(int worker_id, String firstName, String lastName, String rank, String phone_number, String email, String address, int postal_code, String password, String username, int product_id, int workspace_id)
    {
        //this.workers.clear();
        workers.add(new Worker(worker_id, firstName, lastName, rank, phone_number, email, address, postal_code, password, username, product_id, workspace_id));
    }
    public void loadProducts(int product_id, String name, int count, float price)
    {
        products.add(new Product(product_id, name, count, price));
    }
}
