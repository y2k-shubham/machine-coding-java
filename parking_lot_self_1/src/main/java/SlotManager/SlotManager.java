package SlotManager;

import Models.Slot;

import java.util.*;

public class SlotManager implements ISlotManager {

    private TreeSet <Integer> emptySlotNos;
    private Map <Integer, Slot> slots;

    public SlotManager(int numSlots) {
        this.emptySlotNos = new TreeSet<>();
        this.slots = new TreeMap<>();

        this.createSlots(numSlots);
    }

    private void createSlots(int numSlots) {
        for (int i = 1; i <= numSlots; i++) {
            this.emptySlotNos.add(i);
            this.slots.put(i, new Slot(i, i));
        }
    }

    @Override
    public List<Slot> getAllSlots() {
        List <Slot> slotList = new ArrayList<>();

        for (Map.Entry<Integer, Slot> entry : this.slots.entrySet()) {
            slotList.add(entry.getValue());
        }

        return slotList;
    }

    @Override
    public boolean slotsAvailable() {
        return !this.emptySlotNos.isEmpty();
    }

    @Override
    public Slot getNearestEmptySlot() {
        return this.slots.get(this.emptySlotNos.first());
    }

    @Override
    public boolean isAvailable(int slotNo) {
        return this.emptySlotNos.contains(slotNo);
    }

    @Override
    public void setAvailable(int slotNo) {
        this.emptySlotNos.add(slotNo);
        this.slots.get(slotNo).setAvailable();
    }

    @Override
    public void setUnavailable(int slotNo) {
        this.emptySlotNos.remove(slotNo);
        this.slots.get(slotNo).setUnavailable();
    }
}
