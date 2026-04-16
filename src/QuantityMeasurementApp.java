class QuantityMeasurementApp {

    // ---------------- INNER CLASS ----------------
    static class Feet {

        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        // ---------------- EQUALS METHOD ----------------
        @Override
        public boolean equals(Object obj) {

            // Same reference check (reflexive)
            if (this == obj) {
                return true;
            }

            // Null check + type check
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            // Safe casting
            Feet other = (Feet) obj;

            // Compare using Double.compare()
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        boolean result = f1.equals(f2);

        System.out.println("Are both values equal? " + result);
    }
}
