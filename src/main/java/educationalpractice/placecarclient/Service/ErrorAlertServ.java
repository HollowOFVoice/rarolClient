package educationalpractice.placecarclient.Service;


import educationalpractice.placecarclient.Entity.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ErrorAlertServ extends Application {

    public void showError(Exception e, String whatMistakeStr) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Что-то не так..");
        alert.setHeaderText(whatMistakeStr);

        VBox dialogPaneContent = new VBox();

        Label label = new Label("Ошибки:");

        String stackTrace = this.getStackTrace(e);
        TextArea textArea = new TextArea();
        textArea.setText(stackTrace);

        dialogPaneContent.getChildren().addAll(label, textArea);

        // Set content for Dialog Pane
        alert.getDialogPane().setContent(dialogPaneContent);

        alert.showAndWait();
    }

    public void showUser(User data, String whatMistakeStr) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Поиск выполнен");
        alert.setHeaderText(whatMistakeStr);

        VBox dialogPaneContent = new VBox();
        Label label = new Label("Найден следующий пользователь:");
        TextArea textArea = new TextArea();
        textArea.setText(String.valueOf(data));
        dialogPaneContent.getChildren().addAll(label, textArea);
        // Set content for Dialog Pane
        alert.getDialogPane().setContent(dialogPaneContent);
        alert.showAndWait();
    }
    
    public void didntStart(Exception e) {
        String whatMistakeStr = "Проверьте своё подключение к интернету и серверу, пожалуйста!";
        showError(e, whatMistakeStr);
    }

/*     public void didntFound() {
        String whatMistakeStr = "Машины с таким гос. номером не найдено! Попробуйте проверить, верность введенных данных";
        showAlertWithSearch(whatMistakeStr);
    }

    public void didntFoundCar() {
        String whatMistakeStr = "Машины с такими данными не существует!";
        showAlertWithSearch(whatMistakeStr);
    }

   public void found(Car cars) {
        String whatMistakeStr = "Результат поиска: ( "+cars+" )";
        showAlertWithSearch(whatMistakeStr);
    }*/

    public void addVoid(Exception e) {
        String whatMistakeStr = "Вы пытаетесь добавить пустоту, или может некорректно вводите данные! Присмотритесь к примерам в строках, они гласят правильный ввод";
        showError(e, whatMistakeStr);
    }

    public void deleteVoid(Exception e) {
        String whatMistakeStr = "Вы пытаетесь удалить пустоту. Выберите сначала объект! (На крайняк проверьте работу сервера...)";
        showError(e, whatMistakeStr);
    }

    private void showAlertWithHeaderText(String whatMistakeStr) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        alert.setX(bounds.getMaxX() - 800);
        alert.setY(bounds.getMaxY() - 650);
        alert.setTitle("Внимание!");
        alert.setContentText(whatMistakeStr);

        alert.showAndWait();
    }

    /*private void showAlertWithSearch(String whatMistakeStr) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        alert.setX(bounds.getMaxX() - 800);
        alert.setY(bounds.getMaxY() - 650);
        alert.setTitle("Поиск");
        alert.setHeaderText("Результаты поиска: ");
        alert.setContentText(whatMistakeStr);

        alert.showAndWait();
    }*/

    public void incorrectInput() {
        String whatMistakeStr = "\nВ полях данные должны начинаться согласно примерам в строках. Учитывайте их, пожалуйста";
        showAlertWithHeaderText(whatMistakeStr);
    }

    public void full() {
        String whatMistakeStr = "\n В выбранном ряде все места заняты, выберете свободный парковочный ряд!";
        showAlertWithHeaderText(whatMistakeStr);
    }
    public void tryRentFullPM() {
        String whatMistakeStr = "\n Вы пытаетемь заронировать места в ряду, где нет свободных мест, пожалуйста, выберете ряд в котором есть свободные места!";
        showAlertWithHeaderText(whatMistakeStr);
    }

    @Override
    public void start(Stage stage) {
        Button button1 = new Button("показать ошибку");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });
        VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        root.getChildren().addAll(button1);
        Scene scene = new Scene(root, 450, 250);
        stage.setTitle("JavaFX Error Alert (o7planning.org)");
        stage.setScene(scene);
        stage.show();
    }

    public String getStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String s = sw.toString();
        return s;
    }

    public void didntfoundEmployee() {
        String whatMistakeStr = "Вы пытаетесь зайти под несуществующим пользователем! Проверьте ввод логина и пароля (и на крайняк работу сервера)...";
        showAlertWithHeaderText(whatMistakeStr);
    }
    public void didntfoundPM() {
        String whatMistakeStr = "";
        showAlertWithHeaderText(whatMistakeStr);
    }
}