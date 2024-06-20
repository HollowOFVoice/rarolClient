package educationalpractice.placecarclient.Controller;

import educationalpractice.placecarclient.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static educationalpractice.placecarclient.MainApplication.employeeStat;

public class UserCar {

    @FXML
    private Button backButton;
    @FXML
    private Text txtCarColor;

    @FXML
    private Text txtCarMark;

    @FXML
    private Text txtGosNumber;

    @FXML
    private Text txtLastWorkProfile;

    @FXML
    private Text txtModelCar;

    @FXML
    private Text txtPMJProfile;

    @FXML
    private Text txtPMJProfile1;

    @FXML
    private Text txtPMJProfile2;

    @FXML
    private Text whoUser;

    @FXML
    void btnHelp(ActionEvent event) {
        MainApplication.showDialog("help.fxml","Помощь");
    }

    @FXML
    void btnOpenCarUser(ActionEvent event) {
        MainApplication.showDialog("user-car.fxml","Автостоянка 'PlaceCar'");
    }

    @FXML
    void btnOpenHomeUser(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void initialize() {

        whoUser.setText(employeeStat.getName()+"\n"+employeeStat.getLastname()+"\n"+employeeStat.getSurname());
  //  txtCarColor.setText(employeeStat.g);
    }

}
