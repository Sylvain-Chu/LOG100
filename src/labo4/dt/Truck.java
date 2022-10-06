package labo4.dt;

public final class Truck extends Vehicle{

    private String[] materials;
    private long permit;
    private String company;

    public String[] getMaterials() {
        return materials;
    }

    public void setMaterials(String[] materials) {
        String[] tmpMaterials = new String[5];

        int length = materials.length;

        if (length >= 5){
            System.arraycopy(materials, 0, tmpMaterials, 0, 5);
        }else {
            for (int i = 0; i < 5 ; i++){
                if (i < length){
                    tmpMaterials[i] =  materials[i];
                }else {
                    tmpMaterials[i] = null;
                }
            }
        }
        this.materials = tmpMaterials;
    }

    public long getPermit() {
        return permit;
    }

    public void setPermit(long permit) {
        this.permit = permit;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Truck(String[] materials, long permit, String company, String ownerName, String ownerAddress, String brand, String model, String licencePlate, float value) throws VehicleException {
        super(ownerName, ownerAddress, brand, model, licencePlate, value);

        if (company.isEmpty()) {
            throw new TruckException("company");
        }

        if (materials == null){
            throw new TruckException("materials");
        }

        if (materials.length > 5){
            throw new TruckException("materials");
        }

        int err = 0;
        for(String m : materials){
            if (!m.isEmpty()){
                err ++;
            }
        }

        if (err == 0){
            throw new TruckException("materials");
        }

        this.materials = materials;
        this.permit = permit;
        this.company = company;
        this.setMaterials(materials);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());

        s.append(", [");
        for (String material :this.materials) {
            if (material != null){
                s.append("/").append(material).append("/");
            }
        }
        s.append("], ").append(permit).append(", ").append(company);

        return s.toString();
    }
}
