public class WagonFrigorifique extends WagonMarchandises{

    int tempMinimale;

    public WagonFrigorifique(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double chargeActuelle, int tempMinimale) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur, chargeActuelle);
        this.tempMinimale = tempMinimale;
        this.type = TypeWagon.FRIGO;

    }

    @Override
    public void charger(double poids) {
        this.chargeActuelle += poids;
    }

    @Override
    public void decharger(double poids) {
        double newCharge = this.chargeActuelle - poids;
        this.chargeActuelle =  (newCharge < 0) ? 0 : newCharge ;
    }

}
