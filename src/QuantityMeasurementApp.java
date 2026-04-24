public class QuantityMeasurementApp {

    // 🔹 Method Overloading (as required)

    public static void demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to) {
        Quantity q = new Quantity(value, from);
        Quantity result = q.convertTo(to);
        System.out.println(value + " " + from + " = " + result);
    }

    public static void demonstrateLengthConversion(Quantity q, LengthUnit to) {
        Quantity result = q.convertTo(to);
        System.out.println(q + " = " + result);
    }

    public static void demonstrateLengthEquality(Quantity q1, Quantity q2) {
        System.out.println("Equal: " + q1.equals(q2));
    }

    public static void main(String[] args) {

        // 🔹 Conversion examples
        demonstrateLengthConversion(3.0, LengthUnit.FEET, LengthUnit.INCHES);
        demonstrateLengthConversion(1.0, LengthUnit.YARDS, LengthUnit.INCHES);

        // 🔹 Using overloaded method
        Quantity q = new Quantity(2.0, LengthUnit.YARDS);
        demonstrateLengthConversion(q, LengthUnit.FEET);

        // 🔹 Equality check
        Quantity q1 = new Quantity(1.0, LengthUnit.YARDS);
        Quantity q2 = new Quantity(3.0, LengthUnit.FEET);

        demonstrateLengthEquality(q1, q2);
    }
}