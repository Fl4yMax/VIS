package App;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AppController {
    private static AppCore appCore;
    private ArrayList<FXMLLoader> loaders;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    private List<Worker> workersView;

    @FXML
    private Label failedAuth;

    @FXML
    private Label username;
    @FXML
    private Label product;
    @FXML
    private Label product_id;
    @FXML
    private Label currentNum;
    @FXML
    private Label allNum;
    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label phoneNumber;
    @FXML
    private Label email;
    @FXML
    private Label rank;
    @FXML
    private TextField firstNameUpdate;
    @FXML
    private TextField lastNameUpdate;
    @FXML
    private TextField emailUpdate;
    @FXML
    private TextField addressUpdate;
    @FXML
    private TextField phoneNumberUpdate;

    @FXML
    private Label address;
    private int currNum = 1;


    public AppController()
    {
        loaders = new ArrayList<>();

        loaders.add(new FXMLLoader(this.getClass().getResource("Logging.fxml")));                 //0
        loaders.add(new FXMLLoader(this.getClass().getResource("WorkerMenu.fxml")));              //1
        loaders.add(new FXMLLoader(this.getClass().getResource("WorkerMenuStorage.fxml")));       //2
        loaders.add(new FXMLLoader(this.getClass().getResource("WorkerMenuMaster.fxml")));        //3
        loaders.add(new FXMLLoader(this.getClass().getResource("WorkerMenuQuality.fxml")));       //4
        loaders.add(new FXMLLoader(this.getClass().getResource("WorkerMenuAdmin.fxml")));         //5
        loaders.add(new FXMLLoader(this.getClass().getResource("OrderView.fxml")));               //6
        loaders.add(new FXMLLoader(this.getClass().getResource("UserProfile.fxml")));             //7
        loaders.add(new FXMLLoader(this.getClass().getResource("WorkersAdmin.fxml")));            //8
        loaders.add(new FXMLLoader(this.getClass().getResource("UserAccountOptions.fxml")));      //9
        loaders.add(new FXMLLoader(this.getClass().getResource("UpdateUserProfile.fxml")));       //10
    }
    public void startApp()
    {
        failedAuth.setText("");
        this.appCore = new AppCore();
    }

    @FXML
    private void orderView(ActionEvent event) throws IOException
    {
        Pane root = loaders.get(6).load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("MainMenu");
        stage.show();
    }

    @FXML
    private void userAccountOptions(ActionEvent event) throws IOException
    {
        Pane root = loaders.get(9).load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("MainMenu");
        stage.show();
    }

    @FXML
    private void userProfile(ActionEvent event) throws IOException
    {
        Pane root = loaders.get(7).load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("Profil");
        stage.show();

        AppController controller = loaders.get(7).getController();

        controller.firstName.setText(appCore.getLoggedIn().getFirstName());
        controller.lastName.setText(appCore.getLoggedIn().getLastName());
        controller.address.setText(appCore.getLoggedIn().getAddress());
        controller.phoneNumber.setText(appCore.getLoggedIn().getPhone_number());
        controller.email.setText(appCore.getLoggedIn().getEmail());
        controller.rank.setText(appCore.getLoggedIn().getRank());
    }

    @FXML
    private void logIn(ActionEvent event) throws IOException
    {
        if(appCore.authentication(login.getText(), password.getText()))
        {
            Pane root = menuByRank();

            Scene scene = new Scene(root);

            Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

            stage.setScene(scene);
            stage.resizableProperty().set(true);
            stage.setTitle("MainMenu");
            stage.show();
        }
        else
        {
            login.setText("");
            password.setText("");
            failedAuth.setText("Chybný login nebo heslo");
        }
    }
    @FXML
    private void updateProfile(ActionEvent event) throws IOException
    {
        Pane root = loaders.get(10).load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("Profil");
        stage.show();
    }

    @FXML
    private void saveUpdateProfile(ActionEvent event) throws IOException
    {
        Pane root = loaders.get(10).load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("Profil");
        stage.show();


    }

    @FXML
    private void backToMenu(ActionEvent event) throws IOException
    {
        Pane root = menuByRank();

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
        stage.setTitle("Login");
        stage.show();
    }

    @FXML
    private void workersOverview(ActionEvent event) throws IOException
    {
        BorderPane root = loaders.get(8).load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("Worker overview");
        stage.show();

        AppController controller = loaders.get(8).getController();

        workersView = new LinkedList<>();
        workersView = appCore.getWorkerProduct();

        int max = workersView.size();
        controller.allNum.setText("/" + max);
        controller.currentNum.setText("" + currNum);
        controller.username.setText(workersView.get(currNum - 1).getLogin());

        getObservable();
    }

    private Pane menuByRank() throws IOException
    {
        String rank = appCore.getRank();
        if(rank.equals("pracovnik"))
        {
            return loaders.get(1).load();
        }
        else if(rank.equals("skladnik"))
        {
            return loaders.get(2).load();
        }
        else if(rank.equals("mistr"))
        {
            return loaders.get(3).load();
        }
        else if(rank.equals("kontrola_kvality"))
        {
            return loaders.get(4).load();
        }
        else if(rank.equals("spravce"))
        {
            return loaders.get(5).load();
        }
        return null;
    }

    private void getObservable()
    {
    }

    @FXML
    private void nextWorker(ActionEvent event) throws IOException
    {
        appCore.setCurrW(true);
        this.currNum = appCore.getCurrW();
        BorderPane root = loaders.get(8).load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("Worker overview");
        stage.show();

        AppController controller = loaders.get(8).getController();

        workersView = appCore.getWorkerProduct();

        int max = workersView.size();
        controller.allNum.setText("/" + max);
        controller.currentNum.setText("" + currNum);
        controller.username.setText(workersView.get(currNum - 1).getLogin());
    }

    @FXML
    private void prevWorker(ActionEvent event) throws IOException
    {
        appCore.setCurrW(false);
        this.currNum = appCore.getCurrW();
        BorderPane root = loaders.get(8).load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("Worker overview");
        stage.show();

        AppController controller = loaders.get(8).getController();

        workersView = appCore.getWorkerProduct();

        int max = workersView.size();
        controller.allNum.setText("/" + max);
        controller.currentNum.setText("" + currNum);
        controller.username.setText(workersView.get(currNum - 1).getLogin());
    }

    @FXML
    private void chooseProduct()
    {

    }
}
