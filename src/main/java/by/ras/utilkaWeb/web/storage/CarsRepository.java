package by.ras.utilkaWeb.web.storage;

import by.ras.utilkaWeb.web.entity.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;

@Component
public class CarsRepository {

    private static List<Car> CARS = new ArrayList(Arrays.asList(
            new Car(1L,"AUDI", 6000),
            new Car(2L,"VolksWagen", 7000),
            new Car(3L,"LADA", 8000),
            new Car(4L,"MAZDA", 9000)
    ));
    private static Long ID = (long) CARS.size();

    public List<Car> getAllCars() {
        return CARS;
    }

    public void addAnotherCar(Car car) {
        long newId = ++ID;
        car.setId(newId);
        CARS.add(car);
    }

    public void edit(Car car) {
        List<Car> editingCars = CARS.stream()
                .filter(e -> Objects.equals(e.getId(), car.getId()))
                .collect(Collectors.toList());
        if (!isEmpty(editingCars)) {
            System.out.println("Was car " + editingCars.get(0));
            Car editingCar = editingCars.get(0);
            editingCar.setName(car.getName());
            editingCar.setPrice(car.getPrice());
            System.out.println("Now car "+ editingCars.get(0));
        }
    }

    public void delete(long carId) {
        List<Long> editingCars = CARS.stream()
                .map(Car::getId)
                .collect(Collectors.toList());
        if (!isEmpty(editingCars)) {
            int deletingCarId = editingCars.indexOf(carId);
            CARS.remove(deletingCarId);
        }
    }
}
