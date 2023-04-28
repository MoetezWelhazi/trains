public class LocomotiveElectrique extends Locomotive {

    private int chargeElectrique;

    public int getChargeElectrique() {
        return chargeElectrique;
    }

    @Override
    public boolean estValideSur(TypeTrain typeTrain) {
        return true;
    }

    @Override
    public double getCapaciteRestante() {
        return 0;
    }

    public LocomotiveElectrique(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double capaciteTraction, int chargeElectrique) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur, capaciteTraction);
        this.chargeElectrique = chargeElectrique;
        this.type = TypeWagon.LOCO;
    }
}
