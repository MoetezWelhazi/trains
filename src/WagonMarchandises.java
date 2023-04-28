
public abstract class WagonMarchandises extends Wagon{

    public WagonMarchandises(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double chargeActuelle) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur, chargeActuelle);
    }

    public abstract void charger(double poids);

    public abstract void decharger(double poids);

    @Override
    public boolean estValideSur(TypeTrain typeTrain){
        return typeTrain == TypeTrain.MARCHANDISES;
    };


}
