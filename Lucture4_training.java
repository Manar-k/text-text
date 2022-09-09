/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucture4_training;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author lokamloka
 */
public class Lucture4_training extends Application {
    //Text text =new Text(50,50,"HELLO LOKAMLOKA :) .");
    @Override
    public void start(Stage lec4) {
        Pane tpane=new Pane();
        
        Text text =new Text(50,50,"HELLO LOKAMLOKA :) .");
        tpane.getChildren().add(text);
        
        HBox btbox=new HBox(20);
        btbox.setStyle("-fx-border-color: pink");
        btbox.setPadding(new Insets(5,5,5,5));
        Button bt1=new Button("LEFT");
        Button bt2=new Button("Right");
      
        bt1.setContentDisplay(ContentDisplay.LEFT);
        bt1.setContentDisplay(ContentDisplay.RIGHT);
        
        btbox.getChildren().addAll(bt1,bt2);
        btbox.setAlignment(Pos.CENTER);
        //action
        bt1.setOnAction(e-> text.setX(text.getX()-5));
        bt2.setOnAction(e-> text.setX(text.getX()+5));
    ////////////////////////////////button////////////////////////////////////////    
        Label entermsg=new Label("Enter a new message: ");
        TextField t=new TextField();
        t.setAlignment(Pos.CENTER);
        t.setMinWidth(200);
        HBox txtbox=new HBox(5);
        txtbox.setStyle("-fx-border-color: pink");
        txtbox.setPadding(new Insets(5,5,5,5));
        txtbox.getChildren().addAll(entermsg,t);
        //action 
        t.setAlignment(Pos.CENTER);
        t.setOnAction(e->text.setText(t.getText()));
    ////////////////////////////////textfield////////////////////////////////////////    
        CheckBox fbold=new CheckBox("Bold");
        CheckBox fitalic=new CheckBox("Italic");
        VBox fbox=new VBox(20);
        fbox.setStyle("-fx-border-color: pink");
        fbox.setPadding(new Insets(5,5,5,5));
        fbox.getChildren().addAll(fbold,fitalic);
        //action
        text.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        EventHandler<ActionEvent>handler=e->{
            if (fbold.isSelected() && fitalic.isSelected()) {
                    text.setFont(Font.font("Times New Roman", FontWeight.BOLD,FontPosture.ITALIC, 20));
            }
            else if (fbold.isSelected()) { 
                text.setFont(Font.font("Times New Roman", FontWeight.BOLD,FontPosture.REGULAR, 20));
            }
            else if (fitalic.isSelected()) { 
                text.setFont(Font.font("Times New Roman", FontWeight.NORMAL,FontPosture.ITALIC, 20));
            }
            else {text.setFont(Font.font("Times New Roman", FontWeight.NORMAL,FontPosture.REGULAR, 20));
            }
        };
        fbold.setOnAction(handler);
        fitalic.setOnAction(handler);
    ///////////////////////////////font////////////////////////////////////////////
        RadioButton red=new RadioButton("RED");
        RadioButton green=new RadioButton("GREEN");
        RadioButton blue=new RadioButton("BLUE");
        
        ToggleGroup g=new ToggleGroup();
        red.setToggleGroup(g);
        green.setToggleGroup(g);
        blue.setToggleGroup(g);
        
        VBox cbox=new VBox(20);
        cbox.setStyle("-fx-border-color: pink");
        cbox.setPadding(new Insets(5,5,5,5));
        cbox.getChildren().addAll(red,green,blue);
        //Action
        red.setOnAction(e-> {if(red.isSelected()){text.setFill(Color.RED);}});
        green.setOnAction(e->{if(green.isSelected()){text.setFill(Color.GREEN);}});
        blue.setOnAction(e->{if(blue.isSelected()){text.setFill(Color.BLUE);}});
    ///////////////////////////////radio////////////////////////////////////////////    
        
        
        
        BorderPane paneforall=new BorderPane();
        paneforall.setBottom(btbox);
        paneforall.setCenter(tpane);
        paneforall.setTop(txtbox);
        paneforall.setRight(fbox);
        paneforall.setLeft(cbox);
        
        //paneforall.setRight(t);//for text
        
        Scene scene=new Scene(paneforall,400,200);
        lec4.setTitle("DEMO");
        lec4.setScene(scene);
        lec4.show();
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {launch(args);}
    
}
