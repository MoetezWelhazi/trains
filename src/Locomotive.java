
public abstract class Locomotive extends VehiculeFerroviaire{

    private double capaciteTraction;

    public double getPoidsTotale(){
        return this.getPoidsAVide();
    }

    public double getTraction(){
        return this.capaciteTraction;
    }

    public double getSurcapacite(){
        return 0;
    }

    public Locomotive(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double capaciteTraction) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur);
        this.capaciteTraction = capaciteTraction;
    }
}
