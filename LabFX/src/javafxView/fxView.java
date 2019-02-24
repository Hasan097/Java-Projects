/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxView;

import consoleView.Game;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class fxView extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Button> a = new ArrayList<Button>();
        String[] str = {"x","x","@","#","$","%","?","&","*"};
        for(int i = 0; i < 9; i++){
            Button btn = new Button();
            btn.setText(str[i]);
            btn.setPrefWidth(85);
            btn.setPrefHeight(25);
            a.add(btn);
        }
        
//        Button butt = new Button();
//           for(int i = 0; i < 9; i++){
//            butt = a.get(i);
//
//            butt.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    Game g = new Game();
//                    g.play();
//                }
//            });            
//           }

        
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 400, 400);
        
        primaryStage.setTitle("Heptilion The Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        int row = 0;
        int col = 0;
        int nextline = 0;
        for(int i = 0; i < 9; i++){
            root.add(a.get(i), col, row);
            nextline++;
            col++;
            if(nextline == 3){
                row++;
                col = 0;
                nextline = 0;
            }
        }
        
    }
    
    // Display welcome message
    public void intro() {
        System.out.println("This is a console-based version of Néstor Romeral Andrés's Heptalion");
        System.out.println();
        System.out.println("For each turn, a player tries to place one of his/her dominoes on the board");
        System.out.println("The last player to make a legal move wins");
        System.out.println("Unlike the real game, a player loses when they either quit");
        System.out.println("  or attempt 3 consecutive illegal moves");
        System.out.println();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
