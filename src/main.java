import java.lang.reflect.Array;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        LocomotiveElectrique loco1 = new LocomotiveElectrique(false,15,59,25, 19.5,3.5, 20,55);
        WagonPorteConteneur wagon1 = new WagonPorteConteneur(false,10,50,35,15,2.5,0,10);
        Voiture v1 = new Voiture(false, 10, 60, 35, 35,4, 35,100,50);

        ArrayList<Locomotive> locos = new ArrayList<Locomotive>();
        locos.add(loco1);
        locos.add(new LocomotiveElectrique(false,18,70,25, 15.5,3.75, 60,55));
        locos.add(new LocomotiveDieselElectrique(false,20,90,30, 22.5,3.25, 80,55));

        ArrayList<Wagon> wagons1 = new ArrayList<Wagon>();
        wagons1.add(new WagonCiterne(true,10,50,30,15,2.5,26,"nitrogen"));
        wagons1.add(new WagonCiterne(false,10,50,30,15,2.5,0,"oxygene liquide"));
        wagons1.add(wagon1);
        wagons1.add(new WagonFrigorifique(false,10,50,35,15,2.5,30,10));
        wagons1.add(new WagonBetailler(false,10,50,35,15,2.5,0,"moutons"));
        wagons1.add(new WagonTremie(false,10,50,35,15,2.5,14,"charbon"));

        ArrayList<Wagon> voitures = new ArrayList<Wagon>();
        voitures.add(v1);
        voitures.add(new Voiture(false, 10, 60, 35, 35,3.75, 15,100,100));

        ArrayList<Wagon> mixte = new ArrayList<Wagon>();
        mixte.add(new Voiture(false, 10, 50, 35, 35,3.75, 15,100,50));
        mixte.add(new WagonPorteConteneur(false,10,75,35,15,2.5,150,10));

        Train T1 = new Train(locos,wagons1,TypeTrain.MARCHANDISES);
        Train T2 = new Train(locos,voitures,TypeTrain.PASSAGERS);
        Train T3 = new Train(locos,mixte,TypeTrain.PASSAGERS);

        System.out.println("\n****************** Affichage ******************");
        T1.affichage();
        System.out.println("\n");
        T2.affichage();
        System.out.println("\n");
        T3.affichage();

        System.out.println("\n****************** Validité des trains ******************");
        System.out.println("T1 valide ?");
        T1.estValide();
        System.out.println("T2 valide ?");
        T2.estValide();
        System.out.println("T3 valide ?");
        T3.estValide();

        System.out.println("\n****************** Vitesse Maximale des trains ******************");
        System.out.println("T1 : "+T1.getVitesseMaximale());
        System.out.println("T2 : "+T2.getVitesseMaximale());
        System.out.println("T3 : "+T3.getVitesseMaximale());

        System.out.println("\n****************** Hauteur des trains ******************");
        System.out.println("T1 : "+T1.getHauteurTrain());
        System.out.println("T2 : "+T2.getHauteurTrain());
        System.out.println("T3 : "+T3.getHauteurTrain());

        System.out.println("\n****************** longueur des trains ******************");
        System.out.println("T1 : "+T1.getLongueurTotale());
        System.out.println("T2 : "+T2.getLongueurTotale());
        System.out.println("T3 : "+T3.getLongueurTotale());

        System.out.println("\n****************** Test Tunnel (4) ******************");
        System.out.println("T1 : "+T1.verifierHauteur(4));
        System.out.println("T2 : "+T2.verifierHauteur(4)); // echec car l'hauteur de v1 = 4
        System.out.println("T3 : "+T3.verifierHauteur(4));

        // Modification du T2 pour qu'il peut passer par le tunnel

        T2.modifierTunnel(4);
        T2.affichage();
        System.out.println("T2 modifier : "+T2.verifierHauteur(4)); // echec car l'hauteur de v1 = 4

        System.out.println("\n****************** Ajout du V1 au T2 ******************");
        T2.ajoutWagon(v1);
        T2.affichage();

        System.out.println("\n****************** Test Pont (225) ******************");
        System.out.println("T1 (Poids Total  = "+T1.getPoidsTotal()+") : "+T1.verifierPoids(225));
        System.out.println("T2 (Poids Total = "+T2.getPoidsTotal()+") : "+T2.verifierPoids(225));
        System.out.println("T3 (Poids Total = "+T3.getPoidsTotal()+") : "+T3.verifierPoids(225));

        //T3 ne peut pas passer par le pont (poids = 238), donc on le modifie.
        T3.modifierPont(225);
        T3.affichage(); //T1 contient seulement 1 wagon maintenant. Le conteneur n'a pas été decharger car le train est du type passagers, donc la methode a enlevé la voiture
        System.out.println(T3.getPoidsTotal());

        System.out.println("\n****************** Places Restantes (Passagers) ******************");
        System.out.println("T1 : ");
        System.out.println(T1.getPlacesRestantes());
        System.out.println("T2 : ");
        System.out.println(T2.getPlacesRestantes());

        System.out.println("\n****************** Ajout et Enlevement des Passagers ******************");
        T1.

        System.out.println("\n****************** Verifier Liquide ******************");
        System.out.println("T1 : "+T1.verifierLiquide());
        System.out.println("T2 : "+T2.verifierLiquide());

        System.out.println("\n****************** Verifier Betailler ******************");
        System.out.println("T1 : "+T1.verifierBetailler());
        System.out.println("T2 : "+T2.verifierBetailler());

        System.out.println("\n****************** Verifier Conteneur ******************");
        T1.verifierConteneur(); //donne 0 car meme s'il ya de capacite en terme de charge dans le conteneur, il n'est pas possible d'ajouter de poids car la traction du train n'est pas suffisante.
        T2.verifierConteneur(); //pas de conteneur
        T3.verifierConteneur(); //conteneur est plein et surcapacité

        System.out.println("\n****************** Verifier Frigo ******************");
        T1.verifierFrigo();
        T2.verifierFrigo();
        T3.verifierFrigo();

        System.out.println("\n****************** Enlever Locomotive ******************");//Cette operation demontre aussi l'ajout.
        ArrayList<Wagon> mixte2 = new ArrayList<Wagon>();
        mixte2.add(new Voiture(false, 10, 50, 35, 35,3.75, 15,100,50));
        mixte2.add(new WagonPorteConteneur(false,10,75,35,15,2.5,15,10));

        Train T4 = new Train(locos,mixte2, TypeTrain.PASSAGERS);
        try{
            T4.affichage();
            T4.supprimerLocomotive(loco1);
            T4.affichage();
        } catch(Exception e){
            System.out.println(e.toString());
        }


    }

}
