package educationalpractice.placecarclient.Controller;

import educationalpractice.placecarclient.Entity.Car;
import educationalpractice.placecarclient.Entity.Employee;
import educationalpractice.placecarclient.Service.CarServ;
import educationalpractice.placecarclient.Service.EmployeeServ;
import educationalpractice.placecarclient.Service.UserServ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AdminEmployeeEdit {

    @FXML
    private ComboBox<Car> comboCarProfile;

    @FXML
    private ComboBox<Employee> comboRoleProfile;

    @FXML
    private TextField strokeLactNameProfile;

    @FXML
    private TextField strokeLastWorkProfile;

    @FXML
    private TextField strokeLoginProfile;

    @FXML
    private TextField strokeNameProfile;

    @FXML
    private TextField strokeNumberPhoneProfile;

    @FXML
    private TextField strokePMJProfile;

    @FXML
    private TextField strokePasswordProfile;

    @FXML
    private TextField strokeSurnameProfile;
    EmployeeServ serv = new EmployeeServ();
    CarServ servCar = new CarServ();
    UserServ userServ = new  UserServ();
    @FXML
    private void initialize() {
        serv.getAll();
            userServ.getAll();

        comboRoleProfile.setItems(serv.getData());
        comboCarProfile.setItems(servCar.getData());
    }

    @FXML
    void btnCancelProfile(ActionEvent event) {

    }

    @FXML
    void btnEditProfile(ActionEvent event) {

    }

//    @FXML
//    void btnOpenHome(ActionEvent event) {
//        MainApplication.showDialog("admin-main.fxml","Автостоянка 'PlaceCar'");
//    }

}
