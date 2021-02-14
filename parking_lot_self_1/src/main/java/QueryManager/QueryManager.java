package QueryManager;

import Models.Car;
import Models.Slot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryManager implements IQueryManager {

    private Map <String, Car> regNoCarMap;
    private Map <String, List <Car> > colorCarsMap;
    private Map <String, List <Slot> > colorSlotsMap;

    private Map <Slot, Car> slotCarMap;

    public QueryManager(Map <Slot, Car> slotCarMap) {
        this.slotCarMap = slotCarMap;

        this.regNoCarMap = new HashMap<>();
        this.colorCarsMap = new HashMap<>();
        this.colorSlotsMap = new HashMap<>();
    }


    @Override
    public Car getCar(String regNo) {
        return this.regNoCarMap.get(regNo);
    }

    @Override
    public Car getCar(Slot slot) {
        return this.slotCarMap.get(slot);
    }

    @Override
    public void addCar(Car car, Slot slot) {
        this.regNoCarMap.put(car.getRegNo(), car);
        this.colorCarsMap.get(car.getColor()).add(car);
        this.colorSlotsMap.get(car.getColor()).add(slot);
    }

    @Override
    public void leaveCar(Car car, Slot slot) {
        this.regNoCarMap.remove(car.getRegNo());
        this.colorCarsMap.get(car.getColor()).remove(car);
        this.colorSlotsMap.get(car.getColor()).remove(slot);
    }

    @Override
    public List<Car> getCars(String color) {
        return this.colorCarsMap.get(color);
    }

    @Override
    public List<Slot> getSlots(String color) {
        return this.colorSlotsMap.get(color);
    }
}
