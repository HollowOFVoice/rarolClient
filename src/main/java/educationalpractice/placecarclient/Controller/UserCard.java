package educationalpractice.placecarclient.Controller;

import educationalpractice.placecarclient.Entity.*;
import educationalpractice.placecarclient.MainApplication;
import educationalpractice.placecarclient.Service.CardServ;
import educationalpractice.placecarclient.Service.PMServ;
import educationalpractice.placecarclient.Service.UserServ;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static educationalpractice.placecarclient.MainApplication.*;

public class UserCard {

    @FXML
    private Button editCard;
    @FXML
    private Text txtBankCard;

    @FXML
    private Text txtCVVCard;

    @FXML
    private Text txtNameCard;

    @FXML
    private Text txtNumberCard;

    @FXML
    private Text txtPMAndPrice;

    @FXML
    private Text txtPMJProfile1;

    @FXML
    private Text txtSrokCard;

    @FXML
    private Text txtSumma;

    @FXML
    private Text txtTimeBron;

    @FXML
    private Text whoUser;

    private Map<String, User> usersData = new HashMap<>();
    private Map<String, Card> cardData = new HashMap<>();
    CardServ serv = new CardServ();
    UserServ userServ = new UserServ();
PMServ pmServ = new PMServ();
    @FXML
    void btnCancelBron(ActionEvent event) {

    }

    @FXML
    void btnHelp(ActionEvent event) {
        MainApplication.showDialog("help.fxml", "Помощь");
    }

    @FXML
    void btnNext(ActionEvent event) {
        User user = new User();
        User user2 = new User();
        Card card = new Card();
        card.setIdCard(addCardData.getIdCard());
        cardEnerest.getUser().setTimeEntry(entry);
        cardEnerest.getUser().setTimeDeparture(exit);
        user.setIdUser(cardEnerest.getUser().getIdUser());
        userServ.findById(user);
        serv.findById(card);
        serv.update(cardEnerest,cardFind);
        userServ.update(cardEnerest.getUser(),forFind);

        PM pm = new PM();

        pm.setRyadPM(parkovkaBukva);

        pm.setNumberPM(Integer.parseInt(sifra));
        pm.setStatusPM("Свободная касса!");
        pm.setUser(user);
        pm.setCard(card);




        pmServ.add(pm);

        MainApplication.showDialog("OkRent.fxml", "Автостоянка 'PlaceCar'");


    }

    @FXML
    void btnOpenCarUser(ActionEvent event) {
        MainApplication.showDialog("user-car.fxml", "Автостоянка 'PlaceCar'");
    }

    @FXML
    void btnOpenEdtCard(ActionEvent event) {

        MainApplication.showDialog("user-card-bron.fxml", "Автостоянка 'PlaceCar'");
        Stage stage = (Stage) editCard.getScene().getWindow();
        stage.close();

    }

    @FXML
    void btnOpenHomeUser(ActionEvent event) {
        MainApplication.showDialog("user-main1.fxml", "Автостоянка 'PlaceCar'");
    }

    @FXML
    // Ваш существующий код
    public void initialize() {
        List<User> users = userServ.getAll();

        ObservableList<Employee> employeeData = FXCollections.observableArrayList();
        ObservableList<Card> cardData = FXCollections.observableArrayList();
        ObservableList<Employee> matchingEmployees = FXCollections.observableArrayList();
        for (User us : users) {
            // Получаем объект Employee через вложенные объекты
            Employee employee = us.getEmployee();
            // Добавляем данные сотрудника в список
            employeeData.add(employee);
        }
        // Проходим по списку сотрудников
        for (int i = 0; i < employeeData.size(); i++) {
            Employee employee1 = employeeData.get(i);

            // Сравниваем сотрудников по идентификатору
            if (employee1.getIdEmployee().equals(employeeStat.getIdEmployee())) {
                // Если идентификаторы совпадают, добавляем сотрудника в список совпадающих
                matchingEmployees.add(employee1);
                // Можно добавить логику для предотвращения повторного добавления одного и того же сотрудника
                break;
            }
        }



        txtSumma.setText( money);
        txtTimeBron.setText(time);
        txtPMAndPrice.setText(parkovkaBukva+sifra+ ", 8 руб/мин");
        whoUser.setText(employeeStat.getName()+"\n"+employeeStat.getLastname()+"\n"+employeeStat.getSurname());

     serv.getAll();

     if (cardEnerest.equals(null)){
         txtSrokCard.setText("пусто");
     }else {

         txtSrokCard.setText(cardEnerest.getTermCard());
         txtNumberCard.setText(cardEnerest.getNumberCard());
         txtBankCard.setText(cardEnerest.getBankCard());
         txtNameCard.setText(cardEnerest.getNameCard());
         txtCVVCard.setText(cardEnerest.getCvvCard());


     }

    }
}
