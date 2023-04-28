public abstract class Wagon extends VehiculeFerroviaire{

    double chargeActuelle;

    public Wagon(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double chargeActuelle) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur);
        this.chargeActuelle = chargeActuelle;
    }

    public double getPoidsTotale(){
        return this.chargeActuelle + this.getPoidsAVide();
    }

    public double getTraction(){
        return 0;
    }

    public double getSurcapacite(){
        double surcharge = this.chargeActuelle - this.getChargeMaximale();
        return surcharge < 0 ? 0 : surcharge;
    }

    public double getCapaciteRestante(){
        if (getSurcapacite() > 0)
            return 0;
        return this.getChargeMaximale() - this.chargeActuelle;
    }

    public double getChargeActuelle() {
        return chargeActuelle;
    }

    public void setChargeActuelle(double chargeActuelle) {
        this.chargeActuelle = chargeActuelle;
    }
}
