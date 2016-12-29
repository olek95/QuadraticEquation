package quadraticequation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuadraticEquation extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("QuadraticEquationFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Program rozwiązujący równanie kwadratowe.");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
