
public abstract class Locomotive extends VehiculeFerroviaire{

    double capaciteTraction;

    TypeWagon type;

    public double getCapaciteTraction() {
        return capaciteTraction;
    }

    public double getPoidsTotale(){
        return this.poidsAVide;
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
        this.type = TypeWagon.LOCO;
    }
}
