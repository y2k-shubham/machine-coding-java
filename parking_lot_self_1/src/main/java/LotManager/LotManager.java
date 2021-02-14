package LotManager;

import Models.Car;
import Models.Slot;
import QueryManager.IQueryManager;
import QueryManager.QueryManager;
import SlotManager.ISlotManager;
import SlotManager.SlotManager;

import java.util.HashMap;
import java.util.Map;

public class LotManager implements ILotManager {

    private ISlotManager slotManager;
    private IQueryManager queryManager;

    private Map <Slot, Car> slotCarMap;
    private Map <Car, Slot> carSlotMap;

    public LotManager(int numSlots) {
        this.slotManager = new SlotManager(numSlots);

        this.slotCarMap = new HashMap<>();
        this.carSlotMap = new HashMap<>();

        this.queryManager = new QueryManager(slotCarMap);
    }

    @Override
    public Slot park(Car car) {
        Slot slot = this.slotManager.getNearestEmptySlot();

        this.carSlotMap.put(car, slot);
        this.slotCarMap.put(slot, car);

        this.slotManager.setUnavailable(slot.getSlotNo());
        this.queryManager.addCar(car, slot);

        return slot;
    }

    @Override
    public Slot leave(Car car) {
        Slot slot = this.carSlotMap.get(car);

        this.carSlotMap.remove(car);
        this.slotCarMap.remove(slot);

        this.slotManager.setAvailable(slot.getSlotNo());
        this.queryManager.leaveCar(car, slot);

        return slot;
    }

    @Override
    public Car leave(Slot slot) {
        Car car = this.slotCarMap.get(slot);

        this.leave(car);

        return car;
    }
}
