enum LengthUnit {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toInches(double value) {
        return value * conversionFactor;
    }

    public double fromInches(double inches) {
        return inches / conversionFactor;
    }
}
enum LengthUnit {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toInches(double value) {
        return value * conversionFactor;
    }

    public double fromInches(double inches) {
        return inches / conversionFactor;
    }
}
public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // ✅ Same unit
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(2.0, LengthUnit.FEET);
        System.out.println(q1.add(q2)); // 3 FEET

        // ✅ Cross unit
        Quantity q3 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q4 = new Quantity(12.0, LengthUnit.INCHES);
        System.out.println(q3.add(q4)); // 2 FEET

        // ✅ Reverse case
        System.out.println(q4.add(q3)); // 24 INCHES

        // ✅ Yards
        Quantity q5 = new Quantity(1.0, LengthUnit.YARDS);
        Quantity q6 = new Quantity(3.0, LengthUnit.FEET);
        System.out.println(q5.add(q6)); // 2 YARDS

        // ✅ Centimeters
        Quantity q7 = new Quantity(2.54, LengthUnit.CENTIMETERS);
        Quantity q8 = new Quantity(1.0, LengthUnit.INCHES);
        System.out.println(q7.add(q8)); // ~5.08 CM

        // ✅ Zero
        Quantity q9 = new Quantity(5.0, LengthUnit.FEET);
        Quantity q10 = new Quantity(0.0, LengthUnit.INCHES);
        System.out.println(q9.add(q10)); // 5 FEET
    }
}