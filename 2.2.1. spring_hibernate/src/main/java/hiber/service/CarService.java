package hiber.service;

import hiber.model.Car;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CarService {

    void addCar(Car car);

}
