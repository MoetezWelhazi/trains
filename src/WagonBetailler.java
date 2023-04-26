public class WagonBetailler extends WagonMarchandises {

    String typeAnimal;

    public WagonBetailler(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double chargeActuelle, String typeAnimal) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur, chargeActuelle);
        this.typeAnimal = typeAnimal;
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
