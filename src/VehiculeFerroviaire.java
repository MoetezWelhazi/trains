
public abstract class VehiculeFerroviaire {

    boolean matiereDangereuse;

    double poidsAVide;

    double vitessemaximale;

    double chargeMaximale;

    double longueur;

    double hauteur;

    public abstract boolean estValideSur(TypeTrain typeTrain);

    public double getPoidsAVide() {
        return poidsAVide;
    }

    public double getVitessemaximale() {
        return vitessemaximale;
    }

    public double getChargeMaximale() {
        return chargeMaximale;
    }

    public double getLongueur() {
        return longueur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public boolean isMatiereDangereuse() {
        return matiereDangereuse;
    }

    public VehiculeFerroviaire(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur) {
        this.matiereDangereuse = matiereDangereuse;
        this.poidsAVide = poidsAVide;
        this.vitessemaximale = matiereDangereuse ? 40 : vitessemaximale;
        this.chargeMaximale = chargeMaximale;
        this.longueur = longueur;
        this.hauteur = hauteur;
    }



}
