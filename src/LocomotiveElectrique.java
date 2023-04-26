public class LocomotiveElectrique extends Locomotive {

    int chargeElectrique;

    public int getChargeElectrique() {
        return chargeElectrique;
    }

    @Override
    public boolean estValideSur(TypeTrain typeTrain) {
        return true;
    }

    public LocomotiveElectrique(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double capaciteTraction, int chargeElectrique) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur, capaciteTraction);
        this.chargeElectrique = chargeElectrique;
    }
}