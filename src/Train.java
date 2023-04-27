import java.util.ArrayList;

public class Train {

    ArrayList<VehiculeFerroviaire> vehicules;

    TypeTrain typeDeTrain;

    public TypeTrain getTypeTrain() {
        return typeDeTrain;
    }

    public double getLongueurTotale() {
        double longueurTotale = 0.0;
        for (VehiculeFerroviaire vehicule : vehicules) {
            longueurTotale += vehicule.getLongueur();
        }
        return longueurTotale;
    }

    public double getPoidsTotal() {
        double poidsTotal = 0.0;
        for (VehiculeFerroviaire vehicule : vehicules) {
            poidsTotal += vehicule.getPoidsTotale();
        }
        return poidsTotal;
    }

    public double getVitesseMaximale() {
        double vitesseMaximale = Double.MAX_VALUE;
        for (VehiculeFerroviaire vehicule : vehicules) {
            if (vehicule.getVitesseMaximale() < vitesseMaximale) {
                vitesseMaximale = vehicule.getVitesseMaximale();
            }
        }
        return vitesseMaximale;
    }

    public double getHauteurTrain() {
        double hauteurMaximale = 0.0;
        for (VehiculeFerroviaire vehicule : vehicules) {
            if (vehicule.getHauteur() > hauteurMaximale) {
                hauteurMaximale = vehicule.getHauteur();
            }
        }
        return hauteurMaximale;
    }

    public double getCapaciteTractionTotale(){
        double traction = 0.0;
        for (VehiculeFerroviaire vehicule : vehicules) {
            traction += vehicule.getTraction();
        }
        return traction;
    }

    //verifier s'il est possible de passer par un tunnel
    public boolean verifierHauteur(double hauteurLibre){
        return hauteurLibre < this.getHauteurTrain();
    }

    //verifier s'il est possible de passer par un pont
    public boolean verifiedPoids(double chargeMaximale){
        return chargeMaximale < this.getPoidsTotal();
    }

    public boolean estValide() {
        for (VehiculeFerroviaire vehicule : vehicules) {
            if (!vehicule.estValideSur(this.typeDeTrain))
                return false;
            if (vehicule.getSurcapacite() != 0)
                return false;
            if (this.getCapaciteTractionTotale() - this.getPoidsTotal() < 0) {
                return false;
            }
        }
        return true;
    }

}
