package Models;

public class Slot {

    private int slotNo;
    private int dist;
    private boolean available;

    public Slot(int slotNo, int dist) {
        this.slotNo = slotNo;
        this.dist = dist;
        this.available = true;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public int getDist() {
        return dist;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable() {
        this.available = true;
    }

    public void setUnavailable() {
        this.available = false;
    }
}
