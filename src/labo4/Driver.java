package labo4;

import labo4.dt.*;

public class Driver {

    public static float sumValues(Vehicle[] vehicles){
        float sum = 0;
        if (vehicles != null){
            for(Vehicle v : vehicles){
                sum += v.getValue();
            }
        }
        return sum;
    }

    public static void testTruck() throws VehicleException {
        String[] m1 = new String[]{};
        String[] m2 = new String[]{"sand", "traffic cones", "concrete", "trees", "flowers"};
        String[] m3 = new String[]{"traffic cones", "sand", "wood", "furniture", "food", "ice "};

        try {
            Truck t1 = new Truck(m1, 1001, "Ville de Montreal", "dfdf", "City Hall", "Chevrolet", "Silverado", "MTL 001", 40000.f);
            Truck t2 = new Truck(m2, 2001, "sfs", "dfd", "sfs", "sfs", "sfs", "sfs", 27000.f);
            Truck t3 = new Truck(m3, 3003, "Griffintown", "Jean Montagne", "1122 Peel", "Toyota", "Tundra", "RST 002", 45000.f);

            System.out.println(t1);
            System.out.println(t2);
            System.out.println(t3);
        } catch (TruckException te){
            System.out.println("Error with Truck constructor parameter " + te.getParameter());
        } catch (VehicleException ve) {
            //throw new VehicleException("Error with Vehicle constructor parameter " + ve.getParameter());
            System.out.println("Error with Vehicle constructor parameter " + ve.getParameter());
        }
    }

    public static void testSuv() throws VehicleException {

        try {
            Suv s1 = new Suv((byte) 12, (byte)4, (byte)2, "Jeanne Tremblay", "1100 Notre-Dame", "Fiat", "500X", "ABC 123", 25000.f);
            Suv s2 = new Suv((byte) 7, (byte)2, (byte)2, "Pierre Maisonneuve", "", "Honda", "Odyssey", "FHG 789", 36000.f);
            Suv s3 = new Suv((byte) 8, (byte)2, (byte)2, "Justin Levesque", "1400 McGill", "BMW", "X6", "", 74000.f);
        }catch (VehicleException ve) {
            //throw new VehicleException("Error with Vehicle constructor parameter " + ve.getParameter());
            System.out.println("Error with Vehicle constructor parameter " + ve.getParameter());
        }
    }

    public static void main(String[] args) throws VehicleException {

        if (args[0].equals("truck")){
            testTruck();
        } else if (args[0].equals("suv")) {
            testSuv();
        }
    }
}
