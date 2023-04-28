public class LocomotiveDieselElectrique extends Locomotive{

    private int capaciteReservoir;

    public int getCapaciteReservoir() {
        return capaciteReservoir;
    }

    @Override
    public boolean estValideSur(TypeTrain typeTrain) {
        return true;
    }

    @Override
    public double getCapaciteRestante() {
        return 0;
    }

    public LocomotiveDieselElectrique(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double capaciteTraction, int capaciteReservoir) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur, capaciteTraction);
        this.capaciteReservoir = capaciteReservoir;
        this.type = TypeWagon.LOCO;
    }
}
