package educationalpractice.placecarclient.Controller;

import educationalpractice.placecarclient.Entity.Employee;
import educationalpractice.placecarclient.Service.EmployeeServ;
import educationalpractice.placecarclient.Service.ErrorAlertServ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AdminCarsEdit {

    @FXML
    private ComboBox<Employee> comboHumanCar;

    @FXML
    private TextField strokeColorCar;

    @FXML
    private TextField strokeGosNumberCar;

    @FXML
    private TextField strokeMarkCar;

    @FXML
    private TextField strokeModelCar;

    private final ErrorAlertServ alertService = new ErrorAlertServ();
    private final EmployeeServ service = new EmployeeServ ();

    @FXML
    private void initialize() {

                service.getAll();

        comboHumanCar.setItems(service.getData());

    }

    @FXML
    void btnCancelEditCar(ActionEvent event) {

    }

    @FXML
    void btnCancelProfile(ActionEvent event) {

    }

    @FXML
    void btnSaveEditCar(ActionEvent event) {

    }

}
