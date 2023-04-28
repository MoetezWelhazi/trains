import java.util.ArrayList;

public class Train {

    ArrayList<VehiculeFerroviaire> vehicules;

    TypeTrain typeDeTrain;

    int nbLocomotive;

    public TypeTrain getTypeTrain() {
        return typeDeTrain;
    }

    public Train(ArrayList<Locomotive> locomotiveArrayList,ArrayList<Wagon> wagonArrayList){
        for (int i = 0; i < locomotiveArrayList.size()/2; i++){
            vehicules.add(locomotiveArrayList.get(i));
        }

        this.nbLocomotive = locomotiveArrayList.size();

        for (Wagon wagon : wagonArrayList) {
            vehicules.add(wagon);
        }

        for (int i = locomotiveArrayList.size()/2; i < locomotiveArrayList.size(); i++){
            vehicules.add(locomotiveArrayList.get(i));
        }
    }

    //diviser le train en 2 puis l'ajout en milieu
    public void ajoutWagon(Wagon wagon){
        int position = (int) Math.floor(this.vehicules.size());
        this.vehicules.add(position,wagon);
    }

    public void supprimerWagon(Wagon wagon){
        for (int i = 0; i < vehicules.size(); i++){
            if ((vehicules.get(i) instanceof Wagon)&&(vehicules.get(i).equals(wagon))){
                vehicules.remove(i);
            }
        }
    }

    public void ajoutLocomotive(Locomotive locomotive){
        if (nbLocomotive % 2 == 1){
            for (int i = 0; i < vehicules.size(); i++){
                if (vehicules.get(i) instanceof Wagon){
                    vehicules.add(i,locomotive);
                }
            }
        }else{
            vehicules.add(vehicules.size()-1,locomotive);
        }
    }

    public void supprimerLocomotive(Locomotive locomotive) throws Exception {
        ArrayList<Locomotive> locomotiveArrayList = new ArrayList<>();

        for (int i = 0; i < vehicules.size(); i++){
            if (vehicules.get(i) instanceof Locomotive){
                break;
            }
        }

        while (vehicules.get(0) instanceof Locomotive){
            if(!vehicules.get(0).equals(locomotive))
                locomotiveArrayList.add((Locomotive) vehicules.get(0));
            vehicules.remove(0);
        }

        for (Locomotive locomotive1 : locomotiveArrayList) {
            locomotiveArrayList.add(locomotive1);
        }

        if (this.getCapaciteTractionTotale() < this.getPoidsTotal()) {
            this.ajoutLocomotive(locomotive);
            throw new Exception("il n'est pas possible de supprimer cette locomotive tout en gardant le train valide");
        }

        this.nbLocomotive -=1;
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

    public double getPoidsAVideTotale(){
        double poidsTotal = 0.0;
        for (VehiculeFerroviaire vehicule : vehicules) {
            poidsTotal += vehicule.getPoidsAVide();
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

    public double getPlacesRestantes(){
        double places = 0;
        for (VehiculeFerroviaire vehicule : vehicules) {
            if(vehicule instanceof Voiture )
                places += vehicule.getCapaciteRestante();
        }
        return places;
    }

    //verifier s'il est possible de passer par un tunnel
    public boolean verifierHauteur(double hauteurLibre){
        return hauteurLibre > this.getHauteurTrain();
    }

    //verifier s'il est possible de passer par un pont
    public boolean verifierPoids(double chargeMaximale){
        return chargeMaximale > this.getPoidsTotal();
    }

    //Si la capacite totale est egale a la poids à vide, la citerne est vide, donc on peut ajouter un liquide
    public boolean verifierLiquide(){
        for (VehiculeFerroviaire vehicule : vehicules) {
            if(vehicule instanceof WagonCiterne )
                if (((WagonCiterne) vehicule).chargeActuelle == 0)
                    return true;
        }
        return false;
    }

    //Si la capacite totale est egale a la poids à vide, la wagon est vide, donc on peut ajouter un autre type d'animale
    public boolean verifierBetailler(){
        for (VehiculeFerroviaire vehicule : vehicules) {
            if(vehicule instanceof WagonBetailler )
                if (((WagonBetailler) vehicule).chargeActuelle == 0)
                    return true;
        }
        return false;
    }

    //Si la capacite totale est egale a la poids à vide, la vrac est vide, donc on peut ajouter un liquide
    public boolean verifierVrac(){
        for (VehiculeFerroviaire vehicule : vehicules) {
            if(vehicule instanceof WagonTremie )
                if (((WagonTremie) vehicule).chargeActuelle == 0)
                    return true;
        }
        return false;
    }

    public void verifierConteneur(){
        int nbCont = 0;
        double poidSupp = 0;
        for (VehiculeFerroviaire vehicule : vehicules) {
            if(vehicule instanceof WagonPorteConteneur ){
                if (((WagonPorteConteneur) vehicule).chargeActuelle == 0){
                    if(this.getCapaciteTractionTotale() - this.getPoidsTotal() - poidSupp - ((WagonPorteConteneur) vehicule).chargeActuelle < 0 ){
                        System.out.println("nombre de conteneur supplementaire : "+nbCont + " ; poids supplémentaire possible (avec traction) : "+poidSupp);
                        return;
                    }
                    nbCont++;
                    poidSupp += vehicule.chargeMaximale;
                }
            }
        }
        System.out.println("nombre de conteneur supplementaire : "+nbCont + " ; poids supplémentaire possible (avec traction) : "+poidSupp);
    }

    //Si la capaciteRestante = 0 a la fin de l'execution traitement du methode le train ne peut pas accepter des produits réfrigérés supplémentaires
    public void verifierFrigo(){
        double capaciteRestante = 0;
        for (VehiculeFerroviaire vehicule : vehicules) {
            if(vehicule instanceof WagonFrigorifique )
                capaciteRestante += vehicule.getCapaciteRestante();
        }
        double x = this.getCapaciteTractionTotale() - this.getPoidsTotal() - capaciteRestante;
        System.out.println("poids supplémentaire possible (avec traction) : "+ (x < 0 ? 0 : x));
    }

    public void affichage(){
        System.out.print("Sommaire :");
        for (VehiculeFerroviaire vehiculeFerroviaire : vehicules) {
            System.out.print(vehiculeFerroviaire.type);
            System.out.print("-");
        }

        System.out.println("Complete :");
        for (VehiculeFerroviaire vehiculeFerroviaire : vehicules) {
            System.out.println(vehiculeFerroviaire.type+" " +vehiculeFerroviaire.toString());
        }
    }

    //Decharge fait d'une maniere equitable
    public void decharger(double charge){
        if(typeDeTrain == TypeTrain.PASSAGERS)
            return; // on decharge pas les passagers.
        int nbWagons = this.vehicules.size() - this.nbLocomotive;
        double poidsParWagon = charge / nbWagons;
        for(VehiculeFerroviaire vehicule : vehicules){
            if( vehicule instanceof WagonMarchandises)
                ((WagonMarchandises) vehicule).decharger(poidsParWagon);
        }
        System.out.println("Le train est decharger, modification du nombre des locomotives pour optimiser la composition du train...");
        int x = 0;
        try{
            while(this.getCapaciteTractionTotale() > this.getPoidsTotal()){
                for(VehiculeFerroviaire vehicule : vehicules){
                    if( vehicule instanceof Locomotive){
                        this.supprimerLocomotive((Locomotive) vehicule);
                        x++;
                        break;
                    }
                }
            }

        } catch(Exception e){
            System.out.println("Nombre de locomotives enlever: "+x);
        }
    }

    //Je n'est pas prix en consideration la capacite de traction apres la modification
    public void modifierTunnel(double hauteur)  {
        while(!this.verifierHauteur(hauteur)){
            for(VehiculeFerroviaire vehicule : vehicules){
                if(vehicule.getHauteur() > hauteur){
                    if(vehicule instanceof Wagon)
                        this.supprimerWagon((Wagon) vehicule);
                    else
                    {
                        try{
                            this.supprimerLocomotive((Locomotive) vehicule);
                        }catch (Exception e){

                        }

                    }
                    break;
                }
            }
        }
    }

    public void modifierPont(double chargeMaximale){
        double poidsADecharger = this.getPoidsTotal() - chargeMaximale;
        this.decharger(poidsADecharger);
        //Si le decharge du train n'est pas suffisant, on enleve des wagons/locomotives.
        while(!this.verifierPoids(chargeMaximale)){
            for(VehiculeFerroviaire vehicule : vehicules){
                if(this.nbLocomotive == this.vehicules.size()){
                    this.supprimerLocomotive((Locomotive) vehicule);
                }
                else if(vehicule instanceof Wagon){
                    this.supprimerWagon((Wagon) vehicule);
                }
            }
        }
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
