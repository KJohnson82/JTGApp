package JTGApp;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static JTGApp.Converter.*;

public class Controller implements Initializable {

    @FXML
    private Label resultDisplay;

    @FXML
    private JFXButton convert;

    @FXML
    private TextField txt_enter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String today = LocalDate.now().format(dateFormat);

        /* Loads current date and JDE Date */
        resultDisplay.setText(onAppStart(today));

        /* Click to process Date */
        convert.setOnAction(event -> {
            inputType(txt_enter.getText());
            resultDisplay.setText(answer);
        });

        txt_enter.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (keyCode.equals(KeyCode.ENTER)) {
                inputType(txt_enter.getText());
                resultDisplay.setText(answer);
            }
        });

        txt_enter.setOnAction(actionEvent -> {
            txt_enter.setOnMouseClicked(MouseEvent -> {
                txt_enter.clear();
            });
        });


        };
    public String onAppStart(String today) {
        answer = toDate() + " = " + julianDate(today);
        return answer;
    }

    public void clearTF() {
    this.txt_enter.clear();
   }

    public String inputType(String convertAnswer) {
        convertAnswer = txt_enter.getText();
        if (convertAnswer.chars().allMatch(Character::isWhitespace) || convertAnswer.chars().allMatch(Character::isSpaceChar) || convertAnswer.chars().allMatch(Character::isLetter) || convertAnswer.contains("\\p{Punct}[^/]+")) {
            answer = "Invalid Entry: ";
            System.out.println(answer);
        }
        else if (convertAnswer.matches("[0-9]{6}")) {

            result = javaDate(convertAnswer);
            answer = result + " = " + convertAnswer;
            resultDisplay.setText(answer);

        }
        else if (convertAnswer.matches("[0-9, /]+")) {
            result = julianDate(convertAnswer);
            answer = convertAnswer + " = " + result;
            resultDisplay.setText(answer);
        }
        else {
            answer = "Invalid Entry: ";
            System.out.println(answer);
        }
        return answer;
    }

    }

