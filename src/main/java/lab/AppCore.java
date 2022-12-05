package lab;

import javafx.fxml.FXMLLoader;

import java.util.ArrayList;

public class AppCore {
    private Worker worker;

    public AppCore()
    {
        super();
        worker = new Worker("Admin", "Admin", "skladnik");
    }

    public String getRank()
    {
        return worker.getRank();
    }
}
