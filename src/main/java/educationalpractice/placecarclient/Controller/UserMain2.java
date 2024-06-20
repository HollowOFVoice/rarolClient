package educationalpractice.placecarclient.Controller;

import educationalpractice.placecarclient.Entity.PM;
import educationalpractice.placecarclient.MainApplication;
import educationalpractice.placecarclient.Service.ErrorAlertServ;
import educationalpractice.placecarclient.Service.PMServ;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static educationalpractice.placecarclient.MainApplication.*;

public class UserMain2 {


    // Добавьте два текстовых поля для ввода времени


    // Форматтер для парсинга времени в формате HH:mm
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    private PMServ serv = new PMServ();


    @FXML
    private GridPane gridPane;
    @FXML
    private Text greenPm;

    @FXML
    private Button numberPM1;

    @FXML
    private Button numberPM10;

    @FXML
    private Button numberPM2;

    @FXML
    private Button numberPM3;

    @FXML
    private Button numberPM4;

    @FXML
    private Button numberPM5;

    @FXML
    private Button numberPM6;

    @FXML
    private Button numberPM7;

    @FXML
    private Button numberPM8;

    @FXML
    private Button numberPM9;

    @FXML
    private Text redPm;

    @FXML
    private Text textPrice;

    @FXML
    private TextField txtEntryPm;

    @FXML
    private TextField txtEntryPm1;

    @FXML
    private Text txtNumberPMBron;

    @FXML
    private Text txtRyadBron;

    @FXML
    private Text txtSumma;

    @FXML
    private Text txtTimeBron;

    @FXML
    private Text txtTimeBron1;

    @FXML
    private Text yellowPm;

    String color;
    ErrorAlertServ alertServ = new ErrorAlertServ();

    @FXML
    void OnNumberPM1(ActionEvent event) {

    }

    @FXML
    void btnBronPM(ActionEvent event) {
        if (color.equals("-fx-background-color: red;") ){
            alertServ.tryRentFullPM();
        }else {
        MainApplication.showDialog("user-card.fxml","Автостоянка 'PlaceCar'");}
    }

    @FXML
    void btnCancelPM(ActionEvent event) {

    }

    public void calculateTimeDifference() {
        // Получение времени въезда и выезда из текстовых полей
        String timeEntry = txtEntryPm.getText();
        String timeExit = txtEntryPm1.getText();

        // Преобразование строк в объекты LocalTime
        LocalTime entryTime = LocalTime.parse(timeEntry, formatter);
        LocalTime exitTime = LocalTime.parse(timeExit, formatter);


entry = txtEntryPm.getText();
exit =txtEntryPm1.getText();
        // Вычисление разницы в минутах
        long minutesBetween = ChronoUnit.MINUTES.between(entryTime, exitTime);

        System.out.println("Разница во времени: " + minutesBetween + " минут");
        txtSumma.setText(String.valueOf(minutesBetween*piatRub));
        txtTimeBron.setText(String.valueOf(minutesBetween)+" минут");
        money = txtSumma.getText();
        time = txtTimeBron.getText();
    }


    @FXML
    void btnOpenCar(ActionEvent event) {
        MainApplication.showDialog("user-car.fxml","Автостоянка 'PlaceCar'");
    }

    @FXML
    void btnOpenProfile(ActionEvent event) {
        MainApplication.showDialog("user-profile.fxml","Автостоянка 'PlaceCar'");
    }


    @FXML
    // Ваш существующий код
    public void initialize() {

        PM pm = new PM();
        List<PM> allPMs = serv.getAll();
        txtRyadBron.setText(parkovkaBukva);

        // Предполагается, что у вас есть GridPane с кнопками
        for (Node node : gridPane.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                String alo = button.getText();
pm.setNumberPM(Integer.parseInt(button.getText()));
pm.setRyadPM(parkovkaBukva);
                try {
                    pm.setNumberPM(Integer.parseInt(alo));
                    serv.checkUserData(pm);
                    if (idPMSer!=null) { // isOccupied() - предполагаемый метод для проверки занятости
                        button.setStyle("-fx-background-color: red;"); // Красим кнопку в красный, если место занято
                    }
                }catch (Exception e){
                    System.out.println("Свободная касса");
                    button.setStyle("-fx-background-color: green;"); // Или в зеленый, если место свободно
                }
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // Получение текста с кнопки
                        String buttonText = button.getText();
                        System.out.println("Текст кнопки: " + buttonText);
                        if (button.getText().contains("ABCDEFJKOPTUVWXY")){
                            piatRub = 5;
                        }else {
                            piatRub = 8;
                        }
                        txtNumberPMBron.setText(buttonText);
                        sifra = buttonText;
//                        parkovkaBukva +=buttonText;
                        color = button.getStyle();
                        if (button.getStyle().equals("-fx-background-color: red;")){
                            alertServ.full();
                        }

                        // Если вы используете userData для хранения данных
                        Object userData = button.getUserData();
                        if (userData != null) {

                            System.out.println("Данные кнопки: " + userData.toString());
                        }



                        // Вызов метода для вычисления разницы во времени
                        try {
                            calculateTimeDifference();
                        }catch (Exception o){
                            System.out.println("TIME NO SET");
                        }


                    }
                });
            }
        }
    }
}

