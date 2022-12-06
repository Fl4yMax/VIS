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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AppController {
    private static AppCore appCore;
    private ArrayList<FXMLLoader> loaders;

    private static final String FILE_NAME_WORKERS = "workerData.csv";
    private static final String FILE_NAME_PRODUCTS = "productData.csv";
    private static final String FILE_NAME_PARTS = "partData.csv";

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    private List<Worker> workersView;
    private List<Product> productsView;

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
    private TextField firstNameCreate;
    @FXML
    private TextField lastNameCreate;
    @FXML
    private TextField emailCreate;
    @FXML
    private TextField addressCreate;
    @FXML
    private TextField phoneNumberCreate;
    @FXML
    private TextField rankCreate;
    @FXML
    private TextField loginCreate;
    @FXML
    private TextField passwordCreate;

    @FXML
    private TextField selectProduct;
    @FXML
    private Label loginP;

    @FXML
    private Label address;
    private int currNum = 1;

    @FXML
    private Label success;

    @FXML
    private Label successP;

    @FXML
    private Label successDelete;

    @FXML
    private TextField deleteUser;



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
        loaders.add(new FXMLLoader(this.getClass().getResource("WorkersProductView.fxml")));      //8
        loaders.add(new FXMLLoader(this.getClass().getResource("UserAccountOptions.fxml")));      //9
        loaders.add(new FXMLLoader(this.getClass().getResource("UpdateUserProfile.fxml")));       //10
        loaders.add(new FXMLLoader(this.getClass().getResource("CreateUser.fxml")));              //11
        loaders.add(new FXMLLoader(this.getClass().getResource("WorkerSelectProduct.fxml")));     //12
        loaders.add(new FXMLLoader(this.getClass().getResource("DeleteUser.fxml")));              //13
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
        BorderPane root = loaders.get(7).load();

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
    private void saveUpdateProfile(ActionEvent event)
    {
        appCore.updateUser(firstNameUpdate.getText(), lastNameUpdate.getText(), phoneNumberUpdate.getText(), emailUpdate.getText(), addressUpdate.getText());
        success.setText("Úspěšně uloženo");
    }

    @FXML
    private void createProfile(ActionEvent event) throws IOException
    {
        Pane root = loaders.get(11).load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("Vytvoření účtu");
        stage.show();
    }
    @FXML
    private void saveCreateProfile(ActionEvent event)
    {
        appCore.createUser(firstNameCreate.getText(), lastNameCreate.getText(), rankCreate.getText(), phoneNumberCreate.getText(), emailCreate.getText(), addressCreate.getText(), passwordCreate.getText(), loginCreate.getText());
        appCore.reloadWorkers();
    }

    @FXML
    private void deleteProfile(ActionEvent event) throws IOException
    {
        BorderPane root = loaders.get(13).load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("Delete profile");
        stage.show();
    }

    @FXML
    private void saveDeleteProfile(ActionEvent event) throws IOException
    {
        List<Worker> workers;
        workers = appCore.getWorkers();
        String x = deleteUser.getText();

        for(Worker w : workers)
        {
            try
            {
                Integer.parseInt(x);
                if(w.getId() == Integer.parseInt(x))
                {
                    appCore.deleteUser(w);
                    successDelete.setText("Uživatel úspěšně smazán");
                    break;
                }
                else
                {
                    successDelete.setText("Uživatel neexistuje");
                }
            }
            catch (NumberFormatException e)
            {
                if(w.getLogin().equals(x))
                {
                    appCore.deleteUser(w);
                    successDelete.setText("Uživatel úspěšně smazán");
                    break;
                }
                else
                {
                    successDelete.setText("Uživatel neexistuje");
                }
            }
        }
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
            if(!appCore.getLoadInformation())
            {
                load();
            }
        }
        else
        {
            login.setText("");
            password.setText("");
            failedAuth.setText("Chybný login nebo heslo");
        }
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
        appCore.logOff();
        Pane root = loaders.get(0).load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("Login");
        stage.show();
        save();
    }

    @FXML
    private void workersProductOverview(ActionEvent event) throws IOException
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
        productsView = new LinkedList<>();

        int max = workersView.size();
        controller.allNum.setText("/" + max);
        controller.currentNum.setText("" + currNum);
        controller.username.setText(workersView.get(currNum - 1).getLogin());
        if(workersView.get(currNum - 1).getProductId() != 0)
        {
            controller.product.setText((appCore.findProduct(workersView.get(currNum - 1).getProductId())).getName());
        }
        controller.product_id.setText("" + workersView.get(currNum - 1).getProductId());
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
        if(workersView.get(currNum - 1).getProductId() != 0)
        {
            controller.product.setText((appCore.findProduct(workersView.get(currNum - 1).getProductId())).getName());
        }
        controller.product_id.setText("" + workersView.get(currNum - 1).getProductId());
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
        if(workersView.get(currNum - 1).getProductId() != 0)
        {
            controller.product.setText((appCore.findProduct(workersView.get(currNum - 1).getProductId())).getName());
        }
        controller.product_id.setText("" + workersView.get(currNum - 1).getProductId());
    }

    @FXML
    private void chooseProduct(ActionEvent event) throws IOException
    {
        BorderPane root = loaders.get(12).load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) (((Node)event.getSource()).getScene().getWindow());

        stage.setScene(scene);
        stage.resizableProperty().set(true);
        stage.setTitle("Worker product selection");
        stage.show();

        AppController controller = loaders.get(12).getController();

        this.workersView = appCore.getWorkerProduct();
        this.currNum = appCore.getCurrW();
        controller.loginP.setText(workersView.get(currNum - 1).getLogin());
    }

    @FXML
    private void saveChosenProduct(ActionEvent event)
    {
        successP.setText("Úspěšně uloženo");
        this.productsView = appCore.getProducts();
        this.workersView = appCore.getWorkerProduct();
        this.currNum = appCore.getCurrW();
        String x = selectProduct.getText();
        try
        {
            Integer.parseInt(x);
            if(Integer.parseInt(x) == 0)
            {
                workersView.get(currNum - 1).setProductId(0);
            }
            else
            {
                workersView.get(currNum - 1).setProductId(Integer.parseInt(x));
            }
        }
        catch (NumberFormatException e)
        {
            for(Product prod : productsView)
            {
                if(prod.getName().equals(x))
                {
                    workersView.get(currNum - 1).setProductId(prod.getId());
                }
            }
        }
        appCore.updateWorker(workersView.get(currNum - 1));
    }

    public void save()
    {
        List<Worker> workers = appCore.getWorkers();
        List<Product> products = appCore.getProducts();
        try(PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME_WORKERS))) {
            for(Worker w : workers)
            {
                //System.out.println(w.getProductId() + " : " + w.getWorkspaceId());
                pw.printf("%d;%s;%s;%s;%s;%s;%s;%d;%s;%s;%d;%d\n", w.getId(), w.getFirstName(), w.getLastName(), w.getRank(), w.getPhone_number(), w.getEmail(), w.getAddress(), w.getPostalCode(), w.getPassword(), w.getLogin(), w.getProductId(), w.getWorkspaceId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME_PRODUCTS))) {
            for(Product p : products)
            {
                pw.printf("%d;%s;%d;%f\n", p.getId(), p.getName(), p.getCount(), p.getPrice());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Save successful");
    }

    public void load()
    {
        appCore.clearAll();
        try (Scanner scanner = new Scanner(new File(FILE_NAME_WORKERS)).useDelimiter("[;\\n]")) {
            while(scanner.hasNext()) {
                appCore.loadWorkers(scanner.nextInt(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Scanner scanner = new Scanner(new File(FILE_NAME_PRODUCTS)).useDelimiter("[;\\n]")) {
            while(scanner.hasNext()) {
                appCore.loadProducts(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextFloat());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Load successful");
    }
}
