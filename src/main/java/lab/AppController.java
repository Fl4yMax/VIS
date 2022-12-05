package lab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AppController {
    private static AppCore appCore;
    private ArrayList<FXMLLoader> loaders;

    public AppController()
    {
        loaders = new ArrayList<>();

        loaders.add(new FXMLLoader(this.getClass().getResource("Logging.fxml")));
        loaders.add(new FXMLLoader(this.getClass().getResource("WorkerMenu.fxml")));
        loaders.add(new FXMLLoader(this.getClass().getResource("WorkerMenuStorage.fxml")));
        loaders.add(new FXMLLoader(this.getClass().getResource("OrderView.fxml")));
    }
    public void startApp()
    {
        this.appCore = new AppCore();
    }

    @FXML
    private void orderView(ActionEvent event) throws IOException
    {
        Pane root = loaders.get(3).load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("MainMenu");
        stage.show();
    }

    @FXML
    private void logIn(ActionEvent event) throws IOException
    {
        Pane root = null;
        String rank = appCore.getRank();
        if(rank == "pracovnik")
        {
            root = loaders.get(1).load();
        }
        else if(rank == "skladnik")
        {
            root = loaders.get(2).load();
        }

        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("MainMenu");
        stage.show();
    }

    @FXML
    private void logOff(ActionEvent event) throws IOException
    {
        Pane root = loaders.get(0).load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("LogIn");
        stage.show();
    }
}
