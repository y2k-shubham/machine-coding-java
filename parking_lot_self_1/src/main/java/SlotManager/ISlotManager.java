package SlotManager;

import Models.Slot;

import java.util.List;

public interface ISlotManager {

    public List <Slot> getAllSlots();

    public boolean slotsAvailable();

    public Slot getNearestEmptySlot();

    public boolean isAvailable(int slotNo);

    public void setAvailable(int slotNo);

    public void setUnavailable(int slotNo);

}
