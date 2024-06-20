package educationalpractice.placecarclient.Controller;

import educationalpractice.placecarclient.Entity.PM;
import educationalpractice.placecarclient.MainApplication;
import educationalpractice.placecarclient.Service.ErrorAlertServ;
import educationalpractice.placecarclient.Service.PMServ;
import educationalpractice.placecarclient.Service.UserServ;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static educationalpractice.placecarclient.MainApplication.*;

public class UserMain1 {

    private PMServ serv = new PMServ();
    ErrorAlertServ alertServ = new ErrorAlertServ();
//    String [] alosha = ["ABCDEFJKOPTUVWXY "];
    @FXML
    private GridPane gridPanel;
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
    private Button numberPM61;

    @FXML
    private Button numberPM610;

    @FXML
    private Button numberPM611;

    @FXML
    private Button numberPM612;

    @FXML
    private Button numberPM613;

    @FXML
    private Button numberPM614;

    @FXML
    private Button numberPM615;

    @FXML
    private Button numberPM62;

    @FXML
    private Button numberPM63;

    @FXML
    private Button numberPM64;

    @FXML
    private Button numberPM65;

    @FXML
    private Button numberPM66;

    @FXML
    private Button numberPM67;

    @FXML
    private Button numberPM68;

    @FXML
    private Button numberPM69;

    @FXML
    private Button numberPM7;

    @FXML
    private Button numberPM8;

    @FXML
    private Button numberPM9;

    @FXML
    private Text redPm;

    @FXML
    private Text who;


    @FXML
    private Text textPrice;

    @FXML
    private Text textPrice1;

    @FXML
    private Text yellowPm;
    private final UserServ service = new UserServ();
    private boolean addFlag = true;
    String color;
    @FXML
    void OnNumberPM1(ActionEvent event) {
//        PM pm = new PM();
//        pm.setRyadPM();
//        if (addFlag) {
//
//        }
    }

    @FXML
    void btnCancelRyadPM(ActionEvent event) {

    }

    @FXML
    void btnOpenCar(ActionEvent event) {
        MainApplication.showDialog("user-car.fxml","Автостоянка 'PlaceCar'");
    }

    @FXML
    void btnOpenPMs(ActionEvent event) {
        if (color.equals("-fx-background-color: red;") ){
            alertServ.tryRentFullPM();
        }else {
        MainApplication.showDialog("user-main2.fxml","Автостоянка 'PlaceCar'");}
    }

    @FXML
    void btnOpenProfile(ActionEvent event) {
        MainApplication.showDialog("user-profile.fxml","Автостоянка 'PlaceCar'");
    }


    @FXML
    private void initialize() {

        PM pm2 = new PM();
        int i = 0;
        who.setText(employeeStat.getName()+"\n"+employeeStat.getLastname()+"\n"+employeeStat.getSurname());

        // Получаем список всех парковочных мест из базы данных
        List<PM> allPMS = serv.getAll();

        // Создаем мапу для отслеживания количества мест для каждой буквы
        Map<String, Integer> countMap = new HashMap<>();
        for (PM pm : allPMS) {
            String ryad = pm.getRyadPM(); // Предполагаем, что getRyadPM() возвращает строку с буквой ряда
            countMap.put(ryad, countMap.getOrDefault(ryad, 0) + 1);
        }

        for (Node node : gridPanel.getChildren()) {
            if (node instanceof Button) {
                i++;
                Button button = (Button) node;
                String ryad = button.getText();
                pm2.setNumberPM(i);
                pm2.setRyadPM(ryad);

                // Проверяем количество мест для данной буквы
                int count = countMap.getOrDefault(ryad, 0);
                if (count >= 10) {
                    button.setStyle("-fx-background-color: red;"); // Красим кнопку в красный, если под буквой 10 мест

                } else {
                    button.setStyle("-fx-background-color: green;"); // Или в зеленый, если мест меньше 10
                }

                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // Получение текста с кнопки
                        String buttonText = button.getText();
                        System.out.println("Текст кнопки: " + buttonText);

                        parkovkaBukva= button.getText();
                        color = button.getStyle();
                        if (button.getStyle().equals("-fx-background-color: red;")){
                            alertServ.full();
                        }

                        // Если вы используете userData для хранения данных
                        Object userData = button.getUserData();
                        if (userData != null) {
                            System.out.println("Данные кнопки: " + userData.toString());
                        }
                    }
                });
            }
        }

    }

    }


