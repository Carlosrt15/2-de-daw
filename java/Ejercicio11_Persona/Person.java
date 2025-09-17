public class Person {
    private String name;
    private int years;

        // Constructor 

        public Person(String name, int years) {
            this.name = name;
            this.years = years;
        }

        // Getter
        public String getName() {
            return name;
        }

        public int getYears() {
            return years;
        }

        // Setters
        public void setName(String name) {
            this.name = name;
        }

        public void setYears(int years) {
            this.years = years;
        }

}
