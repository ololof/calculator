package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import static sample.Model.error;

public class Controller {

    @FXML
    public Text result;
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    private String num1;
    private String num2;

    private Model model = new Model();

    public Controller() {
    }
    //method that warns against illegal actions
    public static void exep(String exep) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Недопустимое действие");
        alert.setHeaderText(null);
        alert.setContentText(exep);
        alert.showAndWait();

    }
   // methods that listen to the input values
    @FXML
    public void enterNumber1(ActionEvent event) {
        String value = ((TextField) event.getSource()).getText();
        field1.setText(value);

    }

    @FXML
    public void enterNumber2(ActionEvent event) {
        String value = ((TextField) event.getSource()).getText();
        field2.setText(value);
    }

//if there is an error, the result is cleared
    @FXML
    public void evaluate() {
        num1 = field1.getText();
        num2 = field2.getText();
        model.enterNumber(num1, num2);
        model.calculation();
        if (error) {
            exep("Введите числовые значения делимого и не равного нулю делителя. Используйте '.' для ввода дробных чисел ");
            result.setText("");
        } else {
            error = false;

            result.setText(model.calculation());
        }


    }


}

