package educationalpractice.placecarclient;


import educationalpractice.placecarclient.Controller.AdminMain;
import educationalpractice.placecarclient.Controller.UserMain1;
import educationalpractice.placecarclient.Controller.WelcomeMain;
import educationalpractice.placecarclient.Entity.Card;
import educationalpractice.placecarclient.Entity.Employee;
import educationalpractice.placecarclient.Entity.PM;
import educationalpractice.placecarclient.Entity.User;
import educationalpractice.placecarclient.Service.SignInServ;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

public class MainApplication extends Application {
    private Stage stage;
    private FXMLLoader fxmlLoader;
    public  static PM idPMSer;
    private static AdminMain adminMainContr;
    private static UserMain1 userMain1Contr;
    @Getter
    @Setter
    private static WelcomeMain signInController;
    public static SignInServ sign = new SignInServ();
    public static String parkovkaBukva;
    public static String sifra;
    public static int piatRub;
    public static Card cardEnerest = new Card();
    public static Card addCardData = new Card();
    public static String money;
    public static String time;
    public static Employee fifa = new Employee(); // данные временного пользователя (юзер)
    @Getter
    @Setter
    public static Employee userInf = new Employee(); // данные временного пользователя (юзер)
    public static Employee emporio = new Employee();
    public static User forFind = new User();
    public static Card cardFind = new Card();
    public static String entry ;
    public static String exit ;
    public static String ember ;
    public static Employee employeeStat = new Employee();//Хранение в себе все данные эмплоера, если таковой вошел в систему
    @Getter
    @Setter
    public static Employee userAdmin = new Employee(); // обозначение, что прога для админа
//    @Getter
//    @Setter
//    public static Employee userSecurity = new Employee(); // обозначение, что прога для охранника

    @Override
    public void start(Stage stage) throws IOException {
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("welcome-main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 870, 570);
        stage.setTitle("Автостоянка 'PlaceCar'");
        stage.setResizable(false);
        stage.setScene(scene);
        signInController = fxmlLoader.getController();
        stage.show();
    }
    public static void startAdmin(String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("admin-mainBeta.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 870, 570);
        stage.setTitle("Автостоянка 'PlaceCar'");
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        adminMainContr = fxmlLoader.getController();
        stage.show();
    }

    public static void startUser(String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("user-main1.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 870, 570);
        stage.setTitle("Автостоянка 'PlaceCar'");
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setScene(scene);
        userMain1Contr = fxmlLoader.getController();
        stage.show();
    }

    public static void showDialog(String nameView, String title){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource(nameView));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle(title);
            dialogStage.setResizable(false);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException l){
            Alert alert = new Alert(Alert.AlertType.NONE,  "Возникла ошибка!",
                    ButtonType.CLOSE, ButtonType.OK);

            Button button = new Button("Понятно");

            button.setOnAction(e -> {
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.show();
            });
            l.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}