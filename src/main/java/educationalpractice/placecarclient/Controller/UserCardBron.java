package educationalpractice.placecarclient.Controller;

import educationalpractice.placecarclient.Entity.Card;
import educationalpractice.placecarclient.Entity.Employee;
import educationalpractice.placecarclient.Entity.User;
import educationalpractice.placecarclient.MainApplication;
import educationalpractice.placecarclient.Service.CardServ;
import educationalpractice.placecarclient.Service.ErrorAlertServ;
import educationalpractice.placecarclient.Service.UserServ;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

import static educationalpractice.placecarclient.MainApplication.cardEnerest;
import static educationalpractice.placecarclient.MainApplication.employeeStat;

public class UserCardBron {

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveCard;
    @FXML
    private TextField strokeBankCard;

    @FXML
    private TextField strokeCVVCard;

    @FXML
    private TextField strokeNameCard;

    @FXML
    private TextField strokeNumberCard;

    @FXML
    private TextField strokeSrokCard;

    ErrorAlertServ alertServ = new ErrorAlertServ();
    CardServ serv = new CardServ();

    UserServ userServ = new UserServ();


    @FXML
    void btnCancelEditCard(ActionEvent event) {

    }

    @FXML
    void btnCancelProfile(ActionEvent event) {

    }



    @FXML
    void btnSaveEditCard(ActionEvent event) {
        try {
            Card card = new Card();
            card.setBankCard(strokeBankCard.getText());
            card.setCvvCard(strokeCVVCard.getText());
            card.setNameCard(strokeNameCard.getText());
            card.setNumberCard(strokeNumberCard.getText());
            card.setTermCard(strokeSrokCard.getText());

            List<User> users = userServ.getAll();

            ObservableList<Employee> employeeData = FXCollections.observableArrayList();
            ObservableList<User> usIddd = FXCollections.observableArrayList();

            for (User us : users) {
                Employee employee = us.getEmployee();
                employeeData.add(employee);
                usIddd.add(us);
            }

            // Предположим, что у нас есть переменная employeeStat, которая содержит данные текущего сотрудника


            User userToLink = null; // Пользователь, к которому будет привязана карта
            for (User user : usIddd) {
                if (user.getEmployee().getIdEmployee().equals(employeeStat.getIdEmployee())) {
                    userToLink = user; // Найден подходящий пользователь для привязки карты
                    break;
                }
            }

            if (userToLink != null) {
                card.setUser(userToLink); // Привязываем карту к найденному пользователю
                serv.add(card); // Добавляем карту в сервис
                cardEnerest = card;
                MainApplication.showDialog("user-card.fxml","Автостоянка 'PlaceCar'");
            } else {
                System.out.println("Не найден пользователь для привязки карты");
            }

        } catch (Exception e) {
            alertServ.addVoid(e);
        }
        Stage stage = (Stage) saveCard.getScene().getWindow();
        stage.close();
    }
}
