public class ShippingCalculator {

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {
        double costo = 0.0;

        if (tipoServicio == 1) {
            costo = 50.0;
        } else {
            costo = 90.0;
        }


        costo += (pesoKg * 12.0);

        if (distanciaKm <= 50) {
            costo += 20.0;
        } else if (distanciaKm <= 200) {
            costo += 60.0;
        } else {
            costo += 120.0;
        }

        if (zonaRemota) {
            costo = costo * 1.10;
        }

        return costo;
    }

    public double calcularIVA(double subtotal) {
        return subtotal * 0.16;
    }

    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}