
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

    @Override
    public double getSurcapacite(){
        double x = this.getNombrePassagersTotales() - this.getNombrePlacesAssises();
        return x < 0 ? 0 : x;
    }

    @Override
    public double getCapaciteRestante(){
        if (this.getSurcapacite() > 0)
            return 0;
        return this.getNombrePlacesAssises() - this.getNombrePassagersTotales();
    }

    public void modifierNombrePassagers(int x) {
        int newNbr = this.nombrePassagersTotales + x;
        this.nombrePassagersTotales = (newNbr < 0) ? 0 : newNbr;
    }

    @Override
    public boolean estValideSur(TypeTrain typeTrain) {
        return typeTrain == TypeTrain.PASSAGERS;
    }

    public Voiture(boolean matiereDangereuse, double poidsAVide, double vitessemaximale, double chargeMaximale, double longueur, double hauteur, double chargeActuelle, int nombrePlacesAssises, int nombrePassagersTotales) {
        super(matiereDangereuse, poidsAVide, vitessemaximale, chargeMaximale, longueur, hauteur, chargeActuelle);
        this.nombrePlacesAssises = nombrePlacesAssises;
        this.nombrePassagersTotales = nombrePassagersTotales;
        this.type  = TypeWagon.VOITURE;
    }
}
