package educationalpractice.placecarclient.Service;

import com.google.gson.reflect.TypeToken;
import educationalpractice.placecarclient.Entity.Car;
import educationalpractice.placecarclient.Response.BaseResp;
import educationalpractice.placecarclient.Response.DataResp;
import educationalpractice.placecarclient.Response.ListResp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

public class CarServ {
    @Getter
    private ObservableList<Car> data = FXCollections.observableArrayList();
    private final HttpServ http = new HttpServ();
    JsonServ service = new JsonServ();
    ClientProperties prop = new ClientProperties();
    private Type dataType = new TypeToken<DataResp<Car>>() {}.getType();
    private Type listType = new TypeToken<ListResp<Car>>() {}.getType();
    /*private void sort(){
        data.sort(Comparator.comparing(Car::getSurname));
    }*/

    public void findById(Car data) {
        String temp = http.get(prop.getFindByIdCar() + data.getIdCar());
        DataResp<Car> response = service.getObject(temp, dataType);
        if (response.isSuccess()) {
            this.data.add(response.getData());
        } else {
            throw new RuntimeException(response.getMessage());
        }
    }
    private void sort(){
        data.sort(Comparator.comparing(Car::getIdCar));
    }
    public List<Car> getAll(){
        ListResp<Car> data = new ListResp<>();
        data = service.getObject(http.get(prop.getAllCar()),listType);
        if (data.isSuccess()){
            this.data.addAll(data.getData());
            sort();
            this.data.forEach(System.out::println);
        } else {
            throw new RuntimeException(data.getMessage());
        }
        return data.getData();
    }
    public void add(Car data){
        String temp = http.post(prop.getSaveCard(), service.getJson(data));
        DataResp<Car> response = service.getObject(temp, dataType);
        if (response.isSuccess()){
            this.data.add(response.getData());
            sort();
        }else{
            throw new RuntimeException(response.getMessage());
        }
    }

    public void update(Car after, Car before){
        System.out.println(before);
        System.out.println(after);
        String temp = http.put(prop.getUpdateCar(), service.getJson(after));
        DataResp<Car> response = service.getObject(temp, dataType);
        if (response.isSuccess()){
            this.data.remove(before);
            this.data.add(after);
            sort();
        }else{
            throw new RuntimeException(response.getMessage());
        }
    }

    public void delete(Car data){
        String temp = http.delete(prop.getDeleteCar(), data.getIdCar());
        BaseResp response = service.getObject(temp,BaseResp.class);
        if (response.isSuccess()){
            this.data.remove(data);
        }else {
            throw new RuntimeException(response.getMessage());
        }
    }
}
