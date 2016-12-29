package quadraticequation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class QuadraticEquationFXMLController implements Initializable {
    @FXML
    private Button startButton, exitButton;
    @FXML
    private TextField aTextField, bTextField, cTextField, resultTextField;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startButton.setOnAction(value -> {
            String aText = aTextField.getText(), bText = bTextField.getText(),
                    cText = cTextField.getText();
            if(isNumber(aText) && isNumber(bText) && isNumber(cText)){
                double a = Double.parseDouble(aText), b = Double.parseDouble(bText),
                        c = Double.parseDouble(cText);
                double delta = calculateDelta(a, b, c);
                double[] x = solveEquation(a, b, delta);
                if(x.length == 2) resultTextField.setText("x1 = " + x[0] + " x2 = " + x[1]);
                else if(x.length == 1) resultTextField.setText("x = " + x[0]);
                else resultTextField.setText("Delta mniejsza od 0. Brak miejsc zerowych.");
            }
        });
        exitButton.setOnAction(value -> {
            System.exit(0);
        });
    }    
    public static double calculateDelta(double a, double b, double c){
        return b * b - 4 * a * c;
    }
    public static double[] solveEquation(double a, double b, double delta){
        double[] x;
        if(delta > 0){
            x = new double[2];
            double root = Math.sqrt(delta);
            x[0] = (-b - root)/(2 * a);
            x[1] = (-b + root)/(2 * a);
            return x;
        }
        if(delta == 0){
            x = new double[1];
            x[0] = -b/(2 * a);
            return x;
        }
        x = new double[0];
        return x;
    }
    public static boolean isNumber(String text){
        return text.matches("-?[0-9]+(\\.[0-9]+|[0-9]*)");
    }
}
