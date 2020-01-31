package by.ras.utilkaWeb.web.controller;

import by.ras.utilkaWeb.web.entity.Car;
import by.ras.utilkaWeb.web.storage.CarsRepository;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class FrontController {

	CarsRepository carsRepository;

	@Autowired
	public FrontController(CarsRepository carsRepository) {
		this.carsRepository = carsRepository;
	}

	@RequestMapping(value = "/car/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Car> getAll() {
		return carsRepository.getAllCars();
	}

	@RequestMapping(value = "/car/add/", method = RequestMethod.POST)
	public @ResponseBody void add(@Param String name, @Param Integer price) {
		System.out.println(name);
		System.out.println(price);
		Car car = new Car(name, price);
		carsRepository.addAnotherCar(car);
	}

	@RequestMapping(value = "/car/edit", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void edit(@Param Long id, @Param String name, @Param Integer price) {
		Car car = new Car(id, name, price);
		carsRepository.edit(car);
	}

	@RequestMapping(value = "/car/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody void delete(@PathVariable Long id) {
		carsRepository.delete(id);
	}
}
