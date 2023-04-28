public class WagonPorteConteneur extends WagonMarchandises{

    int longueurConteneur;

    public int getLongueurConteneur() {
        return longueurConteneur;
    }

    public WagonPorteConteneur(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double chargeActuelle, int longueurConteneur) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur, chargeActuelle);
        this.longueurConteneur = longueurConteneur;
        this.type = TypeWagon.CONTENEUR;

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
