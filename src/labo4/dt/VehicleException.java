package labo4.dt;

public class VehicleException extends Exception{
    private String parameter;

    public String getParameter() {
        return parameter;
    }

    public VehicleException(String parameter) {
        this.parameter = parameter;
    }
}
