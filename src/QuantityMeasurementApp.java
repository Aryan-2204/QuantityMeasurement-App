public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    // 🔥 Convert TO base unit (feet)
    public double convertToBaseUnit(double value) {
        return value * toFeetFactor;
    }

    // 🔥 Convert FROM base unit (feet)
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toFeetFactor;
    }
}public class Quantity {

    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {
        if (!Double.isFinite(value) || unit == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    // ✅ UC5 Conversion
    public Quantity convertTo(LengthUnit targetUnit) {
        double baseValue = this.toBaseUnit();
        double result = targetUnit.convertFromBaseUnit(baseValue);
        return new Quantity(result, targetUnit);
    }

    // ✅ UC6 Addition (first operand unit)
    public Quantity add(Quantity other) {
        double sum = this.toBaseUnit() + other.toBaseUnit();
        double result = this.unit.convertFromBaseUnit(sum);
        return new Quantity(result, this.unit);
    }

    // ✅ UC7 Addition (explicit target unit)
    public Quantity add(Quantity other, LengthUnit targetUnit) {
        double sum = this.toBaseUnit() + other.toBaseUnit();
        double result = targetUnit.convertFromBaseUnit(sum);
        return new Quantity(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity)) return false;

        Quantity other = (Quantity) obj;
        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCHES);

        // ✅ Conversion
        System.out.println(q1.convertTo(LengthUnit.INCHES)); // 12 inches

        // ✅ Equality
        System.out.println(q1.equals(q2)); // true

        // ✅ UC6 Add
        System.out.println(q1.add(q2)); // 2 feet

        // ✅ UC7 Add with target
        System.out.println(q1.add(q2, LengthUnit.YARDS)); // ~0.667 yards

        // ✅ CM test
        Quantity q3 = new Quantity(2.54, LengthUnit.CENTIMETERS);
        System.out.println(q3.convertTo(LengthUnit.INCHES)); // ~1 inch
    }
}