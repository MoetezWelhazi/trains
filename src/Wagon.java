public abstract class Wagon extends VehiculeFerroviaire{

    double chargeActuelle;

    public Wagon(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double chargeActuelle) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur);
        this.chargeActuelle = chargeActuelle;
    }

    public double getChargeActuelle() {
        return chargeActuelle;
    }

    public void setChargeActuelle(double chargeActuelle) {
        this.chargeActuelle = chargeActuelle;
    }
}
