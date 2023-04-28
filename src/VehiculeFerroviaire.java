
public abstract class VehiculeFerroviaire {

    private boolean matiereDangereuse;

    private double poidsAVide;

    private double vitessemaximale;

    private double chargeMaximale;

    private double longueur;

    private double hauteur;

    TypeWagon type;

    public abstract boolean estValideSur(TypeTrain typeTrain);

    public double getPoidsAVide() { return poidsAVide; }

    public double getVitesseMaximale() { return vitessemaximale; }

    public double getChargeMaximale() { return chargeMaximale; }

    public double getLongueur() {
        return longueur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public TypeWagon getType() { return type;}

    public boolean isMatiereDangereuse() {
        return matiereDangereuse;
    }

    public abstract double getPoidsTotale();

    public abstract double getTraction();

    public abstract double getSurcapacite();

    public abstract double getCapaciteRestante();

    public VehiculeFerroviaire(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur) {
        this.matiereDangereuse = matiereDangereuse;
        this.poidsAVide = poidsAVide;
        this.vitessemaximale = matiereDangereuse ? 40 : vitessemaximale;
        this.chargeMaximale = chargeMaximale;
        this.longueur = longueur;
        this.hauteur = hauteur;
    }



}
