import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by Anto on 25/12/2015.
 */

public class Main extends Application {

    Stage window;
    TableView<Product> table;
    TextField nameInput, materialInput, laserInput, netPriceInput;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Price calculator");

        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> materialColumn = new TableColumn<>("Material");
        materialColumn.setMinWidth(100);
        materialColumn.setCellValueFactory(new PropertyValueFactory<>("material"));

        TableColumn<Product, Double> laserColumn = new TableColumn<>("Laser");
        laserColumn.setMinWidth(100);
        laserColumn.setCellValueFactory(new PropertyValueFactory<>("laser"));

        TableColumn<Product, Double> netPriceColumn = new TableColumn<>("Netprice");
        netPriceColumn.setMinWidth(100);
        netPriceColumn.setCellValueFactory(new PropertyValueFactory<>("netPrice"));



        //Name Input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //material Input
        materialInput = new TextField();
        materialInput.setPromptText("kg");


        //laser Input
        laserInput = new TextField();
        laserInput.setPromptText("Seconds");


        netPriceInput = new TextField();


        //Button

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addButtonClicked()); //Action when clicking to add button
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteButtonClicked());
        Button calculateButton = new Button("Calculate");
        //calculateButton.setOnAction(event -> calculateButtonClicked());

        HBox hBox = new HBox(); //New Box for the buttons
        hBox.setPadding(new Insets(10, 10, 10, 10)); //Spacing in entire layout
        hBox.setSpacing(10); //Spacing between the buttons
        hBox.getChildren().addAll(nameInput, materialInput, laserInput, netPriceInput, addButton, deleteButton, calculateButton);


        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn,materialColumn, laserColumn, netPriceColumn);



        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();







    }

    //Add button clicked
    public void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setMaterial(Double.parseDouble(materialInput.getText()));
        product.setLaser(Double.parseDouble(laserInput.getText()));
        table.getItems().add(product); //Adding new product to the table
        nameInput.clear();
        materialInput.clear();
        laserInput.clear();
        netPriceInput.clear();


    }

    //Delete button clicked
    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);


    }









    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 850.00, 20, 8));
        products.add(new Product("Tuna", 700, 400, 8));
        return products;

    }



}
