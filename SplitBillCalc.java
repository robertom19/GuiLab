package splitbillcalc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import java.text.NumberFormat;

public class SplitBillCalc extends Application {
    
    Stage window; //creates window
    Button button; //creates button (calculate)
    Button button2; //creates a second button (clear)
    Button button3; //creates a third button (exit)
    Label msg1;
    Label msg2;
    //For currency formatting
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    
    
    public static void main(String[] args) {
        launch(args);
    }
     
    
    @Override 
    public void start(Stage primaryStage) {
        
        window=primaryStage; //sets window as primaryStage
        window.setTitle("Split Bill Calculator"); //names window (or stage) Split Bill Calculator
        
        //Following sets up grid for window        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        
        //Bill label
        Label bLabel = new Label("Bill: ");
        GridPane.setConstraints(bLabel, 0, 0);
        
        //Bill input
        TextField bInput = new TextField();
        bInput.setPromptText("Enter Bill Amount");
        GridPane.setConstraints(bInput, 1, 0);
        
        //Sales Tax label
        Label tLabel = new Label("Sales Tax: ");
        GridPane.setConstraints(tLabel, 0, 1);
        
        //Sales Tax input
        TextField tInput = new TextField();
        tInput.setPromptText("Enter Sales Tax");
        GridPane.setConstraints(tInput, 1, 1); 
        
        //Split label
        Label sLabel = new Label("Split: ");       
        GridPane.setConstraints(sLabel, 0, 2);
        
        //Split Input
        TextField sInput = new TextField();
        sInput.setPromptText("People Splitting");       
        GridPane.setConstraints(sInput, 1, 2);    
        
        // Message to user
        msg1 = new Label();
        GridPane.setConstraints(msg1, 1,4);
        // Error Message to user
        msg2 = new Label();
        GridPane.setConstraints(msg2, 1,4);       
        
        //button setup        
        button = new Button(); //implements button
        button.setText("Calculate"); //Names button 'Calculate'  
        button.setOnAction(e ->  isInt(bInput, bInput.getText()) );  //Checks to see if value is an int 
        button.setOnAction(e ->  isInt(tInput, tInput.getText()) );  //Checks to see if value2 is an int 
        button.setOnAction(e ->  isInt(sInput, sInput.getText()) );  //Checks to see if value3 is an int
        GridPane.setConstraints(button, 1,5);
        button.setPadding(new Insets(5, 5, 5, 5));  
        //                
    
        //button 2 setup         
        button2 = new Button(); //implements button2
        button2.setText("Clear"); //Names button2 'Clear'
        GridPane.setConstraints(button2, 2,5);  
        button2.setPadding(new Insets(5, 5, 5, 5));       
        //        
        
        //button 3 setup         
        button3 = new Button(); //implements button3
        button3.setText("Exit"); //Names button3 'Exit' 
        GridPane.setConstraints(button3, 3,5);
        button3.setPadding(new Insets(5, 5, 5, 5));        
        //         
               
        
       
        //adds elements to the grid
        grid.getChildren().addAll(bLabel, bInput, tLabel, tInput, sLabel, sInput, msg1, msg2, button, button2, button3);
        
        Scene scene = new Scene(grid, 400, 250);
        window.setScene(scene);
        window.show();
        
        
    }

    //Following method validates the inputs and outputs value into console
    private boolean isInt(TextField input, String message){
        try{
            int value = Integer.parseInt(input.getText());  //Bill
            int value2 = Integer.parseInt(input.getText()); //SalesTax
            int value3 = Integer.parseInt(input.getText()); //Split
            int v1 = value;
            int v2 = value2;
            int v3 = value3;
            System.out.println(v1); 
            System.out.println(v2);
            System.out.println(v3);
            msg1.setText("Integers Approved");            
            return true;
            
        }catch(NumberFormatException e){
            msg2.setText("Arithmetic is invalid");
            return false;
         }
    }
   
}

