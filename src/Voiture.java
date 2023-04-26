
public class Voiture extends Wagon{

    int nombrePlacesAssises;

    int nombrePassagersTotales;

    public int getNombrePlacesAssises() {
        return nombrePlacesAssises;
    }

    public int getNombrePassagersTotales() {
        return nombrePassagersTotales;
    }

    public void setNombrePassagersTotales(int nombrePassagersTotales) {
        this.nombrePassagersTotales = nombrePassagersTotales;
    }

    public void modifierNombrePassagers(int x) {
        this.nombrePassagersTotales += x;
    }

    @Override
    public boolean estValideSur(TypeTrain typeTrain) {
        return typeTrain == TypeTrain.PASSAGERS;
    }

    public Voiture(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double chargeActuelle, int nombrePlacesAssises, int nombrePassagersTotales) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur, chargeActuelle);
        this.nombrePlacesAssises = nombrePlacesAssises;
        this.nombrePassagersTotales = nombrePassagersTotales;
    }
}
