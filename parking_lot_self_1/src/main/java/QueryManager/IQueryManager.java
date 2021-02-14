package QueryManager;

import Models.Car;
import Models.Slot;

import java.util.List;

public interface IQueryManager {

    public Car getCar(String regNo);

    public Car getCar(Slot slot);

    public void addCar(Car car, Slot slot);

    public void leaveCar(Car car, Slot slot);

    public List <Car> getCars(String color);

    public List <Slot> getSlots(String color);

}
