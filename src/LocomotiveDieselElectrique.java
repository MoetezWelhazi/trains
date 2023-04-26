public class LocomotiveDieselElectrique extends Locomotive{

    int capaciteReservoir;

    public int getCapaciteReservoir() {
        return capaciteReservoir;
    }

    @Override
    public boolean estValideSur(TypeTrain typeTrain) {
        return true;
    }

    public LocomotiveDieselElectrique(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double capaciteTraction, int capaciteReservoir) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur, capaciteTraction);
        this.capaciteReservoir = capaciteReservoir;
    }
}
