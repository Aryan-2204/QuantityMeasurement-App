class Quantity {

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
        return unit.toInches(value);
    }

    // ✅ UC6 method (unchanged)
    public Quantity add(Quantity other) {
        if (other == null) {
            throw new IllegalArgumentException("Other quantity cannot be null");
        }

        double sumInBase = this.toBaseUnit() + other.toBaseUnit();
        double resultValue = this.unit.fromInches(sumInBase);

        return new Quantity(resultValue, this.unit);
    }

    // 🔥 UC7 method (NEW)
    public Quantity add(Quantity other, LengthUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double sumInBase = this.toBaseUnit() + other.toBaseUnit();

        // Convert to EXPLICIT target unit
        double resultValue = targetUnit.fromInches(sumInBase);

        return new Quantity(resultValue, targetUnit);
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

        // ✅ Target = FEET
        System.out.println(q1.add(q2, LengthUnit.FEET));   // 2 FEET

        // ✅ Target = INCHES
        System.out.println(q1.add(q2, LengthUnit.INCHES)); // 24 INCHES

        // ✅ Target = YARDS
        System.out.println(q1.add(q2, LengthUnit.YARDS));  // ~0.667 YARDS

        // ✅ Different case
        Quantity q3 = new Quantity(36.0, LengthUnit.INCHES);
        Quantity q4 = new Quantity(1.0, LengthUnit.YARDS);

        System.out.println(q3.add(q4, LengthUnit.FEET));   // 6 FEET

        // ✅ CM example
        Quantity q5 = new Quantity(2.54, LengthUnit.CENTIMETERS);
        Quantity q6 = new Quantity(1.0, LengthUnit.INCHES);

        System.out.println(q5.add(q6, LengthUnit.CENTIMETERS)); // ~5.08 CM
    }
}
