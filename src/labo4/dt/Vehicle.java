package labo4.dt;

public class Vehicle {
    private String ownerName;
    private String ownerAddress;

    protected String brand;
    protected String model;
    protected String licencePlate;
    protected float value;


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    protected Vehicle(String ownerName, String ownerAddress, String brand, String model, String licencePlate, float value) throws VehicleException {
        if (ownerName.isEmpty()) {
            throw new VehicleException("ownerName");
        }
        if (ownerAddress.isEmpty()) {
            throw new VehicleException("ownerAddress");
        }
        if (brand.isEmpty()) {
            throw new VehicleException("brand");
        }
        if (model.isEmpty()) {
            throw new VehicleException("model");
        }
        if (licencePlate.isEmpty()) {
            throw new VehicleException("licencePlate");
        }

        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.brand = brand;
        this.model = model;
        this.licencePlate = licencePlate;
        this.value = value;
    }

    @Override
    public String toString() {
        return ownerName + ", " +
                ownerAddress + ", " +
                brand + ", " +
                model + ", " +
                licencePlate + ", " +
                value;
    }
}
