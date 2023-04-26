public class WagonFrigorifique extends WagonMarchandises{

    int tempMinimale;

    public WagonFrigorifique(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double chargeActuelle, int tempMinimale) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur, chargeActuelle);
        this.tempMinimale = tempMinimale;
    }

    @Override
    public void charger(double poids) {
        this.chargeActuelle += poids;
    }

    @Override
    public void decharger(double poids) {
        this.chargeActuelle -= poids;
    }

}
