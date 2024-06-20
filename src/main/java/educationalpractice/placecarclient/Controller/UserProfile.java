package educationalpractice.placecarclient.Controller;

import educationalpractice.placecarclient.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import static educationalpractice.placecarclient.MainApplication.employeeStat;

public class UserProfile {

    @FXML
    private Text txtLastNameProfile;

    @FXML
    private Text txtLastWorkProfile;

    @FXML
    private Text txtNameProfile;

    @FXML
    private Text txtPMJProfile;

    @FXML
    private Text txtPMJProfile1;

    @FXML
    private Text txtPhoneNumberProfile;

    @FXML
    private Text txtSurnameProfile;

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
        MainApplication.showDialog("user-main1.fxml","Автостоянка 'PlaceCar'");
    }

    @FXML
    private void initialize() {
        txtSurnameProfile.setText(employeeStat.getSurname());
        txtNameProfile.setText(employeeStat.getName());
        txtLastNameProfile.setText(employeeStat.getLastname());
        txtPhoneNumberProfile.setText(employeeStat.getNumberPhone());
        whoUser.setText(employeeStat.getName()+"\n"+employeeStat.getLastname()+"\n"+employeeStat.getSurname());

    }
}
