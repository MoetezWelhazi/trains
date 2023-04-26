
public abstract class Locomotive extends VehiculeFerroviaire{

    double capaciteTraction;

    public double getCapaciteTraction() {
        return capaciteTraction;
    }

    public Locomotive(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double capaciteTraction) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur);
        this.capaciteTraction = capaciteTraction;
    }
}
