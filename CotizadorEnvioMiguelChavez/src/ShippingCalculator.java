public class ShippingCalculator {
    public ShippingCalculator(){

    }
    public final double IVA = 0.16;
    private final double PRECIO_EXPRESS=50;
    private final double PRECIO_ESTANDAR=50;
    private double pesoKg;
    private int distanciaKm;
    private int tipoServicio;
    private boolean zonaRemota;

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public int getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(int distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public boolean isZonaRemota() {
        return zonaRemota;
    }

    public void setZonaRemota(boolean zonaRemota) {
        this.zonaRemota = zonaRemota;
    }
}
