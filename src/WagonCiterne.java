public class WagonCiterne extends WagonMarchandises{

    String typeProduit;

    public String getTypeProduit() {
        return typeProduit;
    }

    public WagonCiterne(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double chargeActuelle, String typeProduit) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur, chargeActuelle);
        this.typeProduit = typeProduit;
        this.type = TypeWagon.CITERNE;

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
