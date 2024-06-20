package educationalpractice.placecarclient.Controller;

import educationalpractice.placecarclient.Entity.Employee;
import educationalpractice.placecarclient.MainApplication;
import educationalpractice.placecarclient.Service.ErrorAlertServ;
import educationalpractice.placecarclient.Service.SignInServ;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static educationalpractice.placecarclient.MainApplication.*;

public class WelcomeMain {
    ErrorAlertServ alertService = new ErrorAlertServ();
    SignInServ service = new SignInServ();

    @FXML
    private TextField login;

    @FXML
    private TextField password;
    @FXML
    private Button btnSignIn;

    @FXML
    void btnHelp(ActionEvent event) {
        MainApplication.showDialog("help.fxml","Помощь");
    }

    @FXML
    void btnSignIn(ActionEvent event) {
        try {
            userInf.setLogin(login.getText());
            userInf.setPassword(password.getText());
            sign.checkEmployeeForAdmin(userInf);
        }catch (Exception e){
            System.out.println(e);
            alertService.didntStart(e);
        }
        Stage stage = (Stage) btnSignIn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void strokeLogin(ActionEvent event) {
    }

    @FXML
    void strokePassword(ActionEvent event) {

    }


}
