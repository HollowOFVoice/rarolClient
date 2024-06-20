package educationalpractice.placecarclient;

import educationalpractice.placecarclient.Entity.PM;
import educationalpractice.placecarclient.Entity.User;
import educationalpractice.placecarclient.Service.PMServ;
import educationalpractice.placecarclient.Service.UserServ;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static educationalpractice.placecarclient.Controller.AdminMain.btnEditPMColor;
import static educationalpractice.placecarclient.MainApplication.idPMSer;

public class Places {
    UserServ userServ = new UserServ();
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime twoHoursLater = now.plusHours(2);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedTime = now.format(formatter);
    String formattedFutureTime = twoHoursLater.format(formatter);

    private PM pm = new PM();
    private User user = new User();
    private PMServ serv = new PMServ();

    public GridPane createGridPanel() {
        final int SIZE = 10;
        int bb = 19;
        GridPane grid = new GridPane();

        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S"};
        for (int i = 0; i < bb; i++) {
            Label label = new Label(letters[i]);
            GridPane.setConstraints(label, i + 1, 0);
            grid.getChildren().add(label);
        }

        // Add labels with numbers
        for (int i = 0; i < SIZE; i++) {
            Label label = new Label(String.valueOf(i + 1));
            GridPane.setConstraints(label, 0, i + 1);
            grid.getChildren().add(label);
        }

        // Add buttons to represent cells
        Button[][] cells = new Button[bb][SIZE];

        // Получаем данные из базы данных
        List<PM> allPMs = serv.getAll();

        for (int i = 0; i < bb; i++) {
            for (int j = 0; j < SIZE; j++) {
                Button cell = new Button();
                cell.setPrefSize(30, 30);

                String columnLetter = letters[i];
                int number = j + 1;

                // Проверяем, есть ли данные в базе данных для этой кнопки
                boolean isReserved = allPMs.stream()
                        .anyMatch(pm -> pm.getRyadPM().equals(columnLetter) && pm.getNumberPM() == number);

                if (isReserved) {
                    // Если данные есть, закрашиваем кнопку
                    cell.setStyle("-fx-background-color: #05d5d5;");
                }

                cell.setOnMouseClicked(e -> {
                    if (e.getButton() == MouseButton.PRIMARY) {
                        if (e.getClickCount() == 1) {
                            // Одиночный клик левой кнопкой мыши
                            //  serv.checkUserData(pm);

                            // Здесь может быть логика для отображения данных о месте
                        } else if (e.getClickCount() == 2) {
                            // Двойной клик левой кнопкой мыши
                            if (!cell.getStyle().equals("-fx-background-color: #05d5d5;")) {
                                // Если кнопка не закрашена, бронируем место
                                pm.setRyadPM(columnLetter);
                                pm.setNumberPM(number);
                                pm.setStatusPM("Забронировано");
                                user.setTimeEntry(formattedTime);
                                user.setTimeDeparture(formattedFutureTime);

                                cell.setStyle("-fx-background-color: #05d5d5;");
                                userServ.add(user);
                                serv.add(pm); // Добавляем данные в базу
                            } else {
                                // Если кнопка уже закрашена, отменяем бронь
                                pm.setRyadPM(columnLetter);
                                pm.setNumberPM(number);
                                try {
                                    serv.checkUserData(pm);
                                    serv.delete(idPMSer); // Удаляем данные из базы
                                    cell.setStyle("");
                                } catch (Exception ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                    }
                });

                cells[i][j] = cell;
                GridPane.setConstraints(cell, i + 1, j + 1);
                grid.getChildren().add(cell);
            }
        }

        return grid;
    }

    // Метод для получения всех данных о местах из базы данных
    // Этот метод должен быть реализован в классе PMServ

    // Здесь должен быть код для запроса всех данных о местах из базы данных

}













//    int number;
//    int[] column = new int[26];
//
//    private static final int SIZE = 10;
//
//
//    public static void starik(Stage primaryStage) {
//        GridPane grid = new GridPane();
//
//// Add labels with letters
//        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
//        for (int i = 0; i < SIZE; i++) {
//            Label label = new Label(letters[i]);
//            GridPane.setConstraints(label, i + 1, 0);
//            grid.getChildren().add(label);
//        }
//
//// Add labels with numbers
//        for (int i = 0; i < SIZE; i++) {
//            Label label = new Label(String.valueOf(i + 1));
//            GridPane.setConstraints(label, 0, i + 1);
//            grid.getChildren().add(label);
//        }
//
//// Add buttons to represent cells
//        Button[][] cells = new Button[SIZE][SIZE];
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                Button cell = new Button();
//                cell.setPrefSize(30, 30);
//                cell.setOnAction(e -> {
//                    if (cell.getStyle().equals("-fx-background-color: lightblue;")) {
//                        cell.setStyle("");
//                    } else {
//                        cell.setStyle("-fx-background-color: lightblue;");
//                    }
//                });
//                cells[i][j] = cell;
//                GridPane.setConstraints(cell, i + 1, j + 1);
//                grid.getChildren().add(cell);
//            }
//        }
//
//        Scene scene = new Scene(grid, 400, 400);
//        primaryStage.setTitle("Battleship Table");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }














//package educationalpractice.placecarclient;
//
//import educationalpractice.placecarclient.Entity.PM;
//import educationalpractice.placecarclient.Entity.User;
//import educationalpractice.placecarclient.Service.PMServ;
//import educationalpractice.placecarclient.Service.UserServ;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableView;
//import javafx.scene.input.MouseButton;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//import static educationalpractice.placecarclient.Controller.AdminMain.btnEditPMColor;
//import static educationalpractice.placecarclient.MainApplication.idPMSer;
//
//public class Places {
//UserServ userServ = new UserServ();
//    LocalDateTime now = LocalDateTime.now();
//    LocalDateTime twoHoursLater = now.plusHours(2);
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    String formattedTime = now.format(formatter);
//    String formattedFutureTime = twoHoursLater.format(formatter);
//
//    private PM pm = new PM();
//    private User user = new User();
//    private PMServ serv = new PMServ();
//
//    public GridPane createGridPanel() {
//        final int SIZE = 10;
//        int bb = 19;
//        GridPane grid = new GridPane();
//
//        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S"};
//        for (int i = 0; i < bb; i++) {
//            Label label = new Label(letters[i]);
//            GridPane.setConstraints(label, i + 1, 0);
//            grid.getChildren().add(label);
//        }
//
//        // Add labels with numbers
//        for (int i = 0; i < SIZE; i++) {
//            Label label = new Label(String.valueOf(i + 1));
//            GridPane.setConstraints(label, 0, i + 1);
//            grid.getChildren().add(label);
//        }
//
//        // Add buttons to represent cells
//        Button[][] cells = new Button[bb][SIZE];
//
//        // Получаем данные из базы данных
//        List<PM> allPMs = serv.getAll();
//
//        for (int i = 0; i < bb; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                Button cell = new Button();
//                cell.setPrefSize(30, 30);
//
//                String columnLetter = letters[i];
//                int number = j + 1;
//
//                // Проверяем, есть ли данные в базе данных для этой кнопки
//                boolean isReserved = allPMs.stream()
//                        .anyMatch(pm -> pm.getRyadPM().equals(columnLetter) && pm.getNumberPM() == number);
//
//                if (isReserved) {
//                    // Если данные есть, закрашиваем кнопку
//                    cell.setStyle("-fx-background-color: #05d5d5;");
//                }
//
//                cell.setOnMouseClicked(e -> {
//                    if (e.getButton() == MouseButton.PRIMARY) {
//                        if (e.getClickCount() == 1) {
//                            // Одиночный клик левой кнопкой мыши
//                          //  serv.checkUserData(pm);
//
//                            // Здесь может быть логика для отображения данных о месте
//                        } else if (e.getClickCount() == 2) {
//                            // Двойной клик левой кнопкой мыши
//                            if (!cell.getStyle().equals("-fx-background-color: #05d5d5;")) {
//                                // Если кнопка не закрашена, бронируем место
//                                pm.setRyadPM(columnLetter);
//                                pm.setNumberPM(number);
//                                pm.setStatusPM("Забронировано");
//                                user.setTimeEntry(formattedTime);
//                                user.setTimeDeparture(formattedFutureTime);
//
//                                cell.setStyle("-fx-background-color: #05d5d5;");
//                                userServ.add(user);
//                                serv.add(pm); // Добавляем данные в базу
//                            } else {
//                                // Если кнопка уже закрашена, отменяем бронь
//                                pm.setRyadPM(columnLetter);
//                                pm.setNumberPM(number);
//                                try {
//                                    serv.checkUserData(pm);
//                                    serv.delete(idPMSer); // Удаляем данные из базы
//                                    cell.setStyle("");
//                                } catch (Exception ex) {
//                                    throw new RuntimeException(ex);
//                                }
//                            }
//                        }
//                    }
//                });
//
//                cells[i][j] = cell;
//                GridPane.setConstraints(cell, i + 1, j + 1);
//                grid.getChildren().add(cell);
//            }
//        }
//
//        return grid;
//    }
//
//    // Метод для получения всех данных о местах из базы данных
//    // Этот метод должен быть реализован в классе PMServ
//
//        // Здесь должен быть код для запроса всех данных о местах из базы данных
//
//}













//    int number;
//    int[] column = new int[26];
//
//    private static final int SIZE = 10;
//
//
//    public static void starik(Stage primaryStage) {
//        GridPane grid = new GridPane();
//
//// Add labels with letters
//        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
//        for (int i = 0; i < SIZE; i++) {
//            Label label = new Label(letters[i]);
//            GridPane.setConstraints(label, i + 1, 0);
//            grid.getChildren().add(label);
//        }
//
//// Add labels with numbers
//        for (int i = 0; i < SIZE; i++) {
//            Label label = new Label(String.valueOf(i + 1));
//            GridPane.setConstraints(label, 0, i + 1);
//            grid.getChildren().add(label);
//        }
//
//// Add buttons to represent cells
//        Button[][] cells = new Button[SIZE][SIZE];
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                Button cell = new Button();
//                cell.setPrefSize(30, 30);
//                cell.setOnAction(e -> {
//                    if (cell.getStyle().equals("-fx-background-color: lightblue;")) {
//                        cell.setStyle("");
//                    } else {
//                        cell.setStyle("-fx-background-color: lightblue;");
//                    }
//                });
//                cells[i][j] = cell;
//                GridPane.setConstraints(cell, i + 1, j + 1);
//                grid.getChildren().add(cell);
//            }
//        }
//
//        Scene scene = new Scene(grid, 400, 400);
//        primaryStage.setTitle("Battleship Table");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }




