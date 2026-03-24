public class Alumnos {
        public int id;
        private String name;
        private boolean isActive;
        private double promedio;

        public Alumnos() {
        }
        public Alumnos(int id, String name, boolean isActive, double promedio) {
            this.id = id;
            this.name = name;
            this.isActive = isActive;
            this.promedio = promedio;
        }

        public double getPromedio() {
            return promedio;
        }

        public void setPromedio(double promedio) {
            this.promedio = promedio;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setActive(boolean active) {
            isActive = active;
        }


    }



