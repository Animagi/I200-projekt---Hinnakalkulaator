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

import java.text.DecimalFormat;

/**
 * Created by Anto on 25/12/2015.
 */

public class Main extends Application {

    Stage window;
    TableView<Product> table;
    TextField nameInput, materialInput, laserInput, bendingInput, weldingInput, assemblingInput, netPriceInput, VATInput, sellPriceInput;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Price calculator");


        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name €");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, String> materialColumn = new TableColumn<>("Material €");
        materialColumn.setMinWidth(100);
        materialColumn.setCellValueFactory(new PropertyValueFactory<>("material"));

        TableColumn<Product, String> laserColumn = new TableColumn<>("Laser €");
        laserColumn.setMinWidth(100);
        laserColumn.setCellValueFactory(new PropertyValueFactory<>("laser"));

        TableColumn<Product, String> bendingColumn = new TableColumn<>("Bending €");
        bendingColumn.setMinWidth(100);
        bendingColumn.setCellValueFactory(new PropertyValueFactory<>("bending"));

        TableColumn<Product, String> weldingColumn = new TableColumn<>("Welding €");
        weldingColumn.setMinWidth(100);
        weldingColumn.setCellValueFactory(new PropertyValueFactory<>("welding"));

        TableColumn<Product, String> assemblingColumn = new TableColumn<>("Assembling €");
        assemblingColumn.setMinWidth(100);
        assemblingColumn.setCellValueFactory(new PropertyValueFactory<>("assembling"));

        TableColumn<Product, String> netPriceColumn = new TableColumn<>("Netprice €");
        netPriceColumn.setMinWidth(100);
        netPriceColumn.setCellValueFactory(new PropertyValueFactory<>("netPrice"));

        TableColumn<Product, String> VATColumn = new TableColumn<>("VAT €");
        VATColumn.setMinWidth(100);
        VATColumn.setCellValueFactory(new PropertyValueFactory<>("VAT"));

        TableColumn<Product, String> sellPriceColumn = new TableColumn<>("Sell Price €");
        sellPriceColumn.setMinWidth(100);
        sellPriceColumn.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));




        //Name Input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        //material Input
        materialInput = new TextField();
        materialInput.setPromptText("material (kg)");


        //laser Input
        laserInput = new TextField();
        laserInput.setPromptText("Laser (Sec)");

        //bending Input
        bendingInput = new TextField();
        bendingInput.setPromptText("Bending (Sec)");

        //welding Input
        weldingInput = new TextField();
        weldingInput.setPromptText("Welding (Sec)");

        assemblingInput = new TextField();
        assemblingInput.setPromptText("Assembling (Sec)");


        netPriceInput = new TextField();


        VATInput = new TextField();

        sellPriceInput = new TextField();


        //Button

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addButtonClicked()); //Action when clicking to add button
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteButtonClicked());
        //Button calculateButton = new Button("Calculate");
        //calculateButton.setOnAction(event -> calculateButtonClicked());

        HBox hBox = new HBox(); //New Box for the buttons
        hBox.setPadding(new Insets(10, 10, 10, 10)); //Spacing in entire layout
        hBox.setSpacing(10); //Spacing between the buttons
        hBox.getChildren().addAll(nameInput, materialInput, laserInput, bendingInput, weldingInput, assemblingInput, addButton, deleteButton);


        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn,materialColumn, laserColumn, bendingColumn, weldingColumn, assemblingColumn, netPriceColumn, VATColumn, sellPriceColumn);



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
        if (Double.parseDouble(materialInput.getText()) <0) {
            System.out.println("Viga");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("materialError");
            alert.setHeaderText("Material Error");
            alert.setContentText("Material Input can't be negative!");
            alert.showAndWait();

        } else {
            product.setMaterial(Double.parseDouble(materialInput.getText()));
            product.setLaser(Double.parseDouble(laserInput.getText()));
            product.setBending(Double.parseDouble(bendingInput.getText()));
            product.setWelding(Double.parseDouble(weldingInput.getText()));
            product.setAssembling(Double.parseDouble(assemblingInput.getText()));
            table.getItems().add(product); //Adding new product to the table
            nameInput.clear();
            materialInput.clear();
            laserInput.clear();
            bendingInput.clear();
            weldingInput.clear();
            assemblingInput.clear();


        }





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
        // products.add(new Product("Example", "0", "0", "0", "0", "0", "0"));
        return products;

    }



}
