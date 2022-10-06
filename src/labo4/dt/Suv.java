package labo4.dt;

public final class Suv extends Vehicle{
    private byte capacity;
    private byte childSeatCount;
    private byte airbagCount;

    public byte getCapacity() {
        return capacity;
    }

    public void setCapacity(byte capacity) {
        this.capacity = capacity;
    }

    public byte getChildSeatCount() {
        return childSeatCount;
    }

    public void setChildSeatCount(byte childSeatCount) {
        this.childSeatCount = childSeatCount;
    }

    public byte getAirbagCount() {
        return airbagCount;
    }

    public void setAirbagCount(byte airbagCount) {
        this.airbagCount = airbagCount;
    }

    public Suv(byte capacity, byte childSeatCount, byte airbagCount, String ownerName, String ownerAddress, String brand, String model, String licencePlate, float value) throws VehicleException {
        super(ownerName, ownerAddress, brand, model, licencePlate, value);
        this.capacity = capacity;
        this.childSeatCount = childSeatCount;
        this.airbagCount = airbagCount;
    }

    @Override
    public String toString() {

        String s = super.toString() + ", " + capacity +
                ", " + childSeatCount +
                ", " + airbagCount;

        return s;
    }
}
