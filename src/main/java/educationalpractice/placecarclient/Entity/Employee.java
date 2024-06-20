package educationalpractice.placecarclient.Entity;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    private Long idEmployee; //индивид. номер сотрудника системы в базе
    @NotNull
    private String lastname; //отчество сотрудника системы
    @NotNull
    private String name; //имя сотрудника системы
    @NotNull
    private String surname; //фамилия сотрудника системы
    private String fio;
    @NotNull
    private String role; //роль сотрудника системы
    @NotNull
    private String numberPhone; // номер телефона сотрудника
    @NotNull
    private String login; //логин сотрудника системы
    @NotNull
    private String password; //пароль сотрудника системы
    // Добавляем новое поле для хранения гос номера автомобиля
    private String carLicensePlate;


    @Override
    public String toString() {
        return

                " " + lastname  +
                " " + name +
                " " + surname +  " " +role;


    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee that)) return false;
        return Objects.equals(getLogin(), that.getLogin()) && Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword());
    }





}
