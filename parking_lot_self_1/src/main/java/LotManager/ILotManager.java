package LotManager;

import Models.Car;
import Models.Slot;

public interface ILotManager {

    public Slot park(Car car);

    public Slot leave(Car car);

    public Car leave(Slot slot);

}
