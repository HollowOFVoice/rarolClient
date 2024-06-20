package educationalpractice.placecarclient.Controller;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import educationalpractice.placecarclient.Entity.Car;
import educationalpractice.placecarclient.Entity.Employee;
import educationalpractice.placecarclient.Entity.User;
import educationalpractice.placecarclient.MainApplication;
import educationalpractice.placecarclient.Response.DataResp;
import educationalpractice.placecarclient.Service.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.util.List;

import static educationalpractice.placecarclient.MainApplication.*;

public class AdminEmployee {
    private final EmployeeServ service = new EmployeeServ();
    private final ErrorAlertServ alertService = new ErrorAlertServ();
    @Getter
    private ObservableList<Employee> data = FXCollections.observableArrayList();
    CarServ carServ = new CarServ();

    private boolean addFlag = true;
    private Employee getSelectionElement() {
        Employee temp = tableEmployee.getSelectionModel().getSelectedItem();
        return temp;
    }
    @FXML
    private TableView<Employee> tableEmployee;
    @FXML
    private TableColumn<Employee,String> colFIO;
    @FXML
    private TableColumn<Car,String> colGosNumber;

    @FXML
    private TableColumn<Employee,String> colLogin;

    @FXML
    private TableColumn<Employee,String> colNumberPhone;

    @FXML
    private TableColumn<Employee,String> colPassword;

    @FXML
    private TableColumn<Employee,String> colRole;

    @FXML
    private Text whoUser;
    @FXML
    private Button btnAddEmployee;

    @FXML
    private Button btnCancelEmployee;

    @FXML
    private Button btnDeleteEmployee;

    @FXML
    private Button btnEditEmployee;

    @FXML
    private Button btnOpenCars;

    @FXML
    private Button btnOpenHome;
    @FXML
    void btnAddEmployee(ActionEvent event) {
        MainApplication.showDialog("admin-employee-edit.fxml","Добавление пользователя в базу");

    }

    @FXML
    void btnCancelEmployee(ActionEvent event) {

    }

    @FXML
    void btnDeleteEmployee(ActionEvent event) {

    }

    @FXML
    void btnEditEmployee(ActionEvent event) {
        MainApplication.showDialog("admin-employee-edit.fxml","Редактирование пользователя");
    }

    @FXML
    void btnOpenCars(ActionEvent event) {
        MainApplication.showDialog("admin-cars.fxml","Автостоянка 'PlaceCar'");
        Stage stage = (Stage) btnOpenCars.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnOpenHome(ActionEvent event) {
        MainApplication.showDialog("admin-main.fxml","Главная");
        Stage stage = (Stage) btnOpenHome.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize() {
        service.getAll();
        carServ.getAll();
        whoUser.setText(userAdmin.getSurname());
//        tableEmployee.setItems(service.getData());
        if (userAdmin.getRole().equals("Администратор") ) { //роль равна админу или охране
            btnAddEmployee.setVisible(true);
            btnEditEmployee.setVisible(true);
            btnDeleteEmployee.setVisible(true);
            btnCancelEmployee.setVisible(true);
        } else {
            btnAddEmployee.setVisible(false);
            btnEditEmployee.setVisible(false);
            btnDeleteEmployee.setVisible(false);
            btnCancelEmployee.setVisible(false);
        }


        System.out.println("Введенный: "+userInf.getLogin()+" "+userInf.getPassword());
        //связываем поля таблицы со столбцами
        colFIO.setCellValueFactory(cellData -> Bindings.concat(cellData.getValue().getSurname()," ",cellData.getValue().getName()," ",cellData.getValue().getLastname()," " ));
        colRole.setCellValueFactory(new PropertyValueFactory<Employee, String>("role"));
        colNumberPhone.setCellValueFactory(new PropertyValueFactory<Employee, String>("numberPhone"));
        colLogin.setCellValueFactory(new PropertyValueFactory<Employee, String>("login"));
        colPassword.setCellValueFactory(new PropertyValueFactory<Employee, String>("password"));
        colGosNumber.setCellValueFactory(new PropertyValueFactory<Car, String>("ownerGosNumber"));

        tableEmployee.setItems(service.getData());

    }

}
