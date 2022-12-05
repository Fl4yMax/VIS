package App;

import Database.GatewayWorker;

import java.util.LinkedList;
import java.util.List;

public class AppCore {
    private Worker loggedIn;
    private GatewayWorker dbWorker;
    private List<Worker> workers;

    private List<Worker> workersView;

    private int currW = 1;


    public AppCore()
    {
        super();
        //worker = new Worker("Admin", "Admin", "skladnik");
        dbWorker = new GatewayWorker();
        workers = dbWorker.loadAllWorkers();
        workersView = new LinkedList<>();
        for(Worker wor : workers)
        {
            if(wor.getRank().equals("pracovnik"))
            {
                workersView.add(wor);
            }
        }
       // Worker test = new Worker("Josef", "Máchal", "pracovnik", "+420 552 448 112", "josefm@gmail.com", "Uherské Hradiště, Obořilova 29", 68601, "MAC0044", "Iuswnn78");
        //db.create(test);
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

    public boolean authentication(String login, String password)
    {
        for(Worker wor : workers)
        {
            String wLogin = wor.getCredentials().getKey();
            String wPassword = wor.getCredentials().getValue();
            System.out.println(wLogin + "  " + wPassword);
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
}
