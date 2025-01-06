import java.util.ArrayList;
import java.util.Scanner;

public class Army {
    private String name;
    private int maxArmyPoints;
    private ArrayList<Group> groups;

    // Constructor
    public Army(String name, int maxArmyPoints) {
        this.name = name;
        this.maxArmyPoints = maxArmyPoints;
        this.groups = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxArmyPoints() {
        return maxArmyPoints;
    }

    public void setMaxArmyPoints(int maxArmyPoints) {
        this.maxArmyPoints = maxArmyPoints;
    }

     public void addGroup(Group group) {
        groups.add(group);
     }

     public void removeGroup(int index) {
        groups.remove(index);
     }

    // Method to display army details
    public void displayArmyInfo() {
        System.out.println("Armée : " + getName());
        System.out.println("Points max : " + maxArmyPoints);
        displayGroups();
            
    }

    public int getSize(){
        int sizeArmy = 0;
        for (int i = 0; i < groups.size(); i++) {
            Group group = groups.get(i);
            sizeArmy = sizeArmy + group.getPoints();
        }
        return sizeArmy;
    }

    
    public void displayGroups(){
        
        System.out.println("Groupes :");
        for (int i = 0; i < groups.size(); i++) {
            Group group = groups.get(i);
            System.out.println(i + ")  " + group.getName() + "        (" + group.getPoints() + " points)");
            displayUnits(i);
        }
    }

    public void deleteGroup(){

        System.out.print("Entrez le numéro du groupe à supprimer ('x' pour retour): ");
        int index = 0;
        int good = 0;
        while(good != 1){ // Check pour des erreurs de type de variable

            try {
                index = scanner.nextInt(); // Tente de lire un entier
                good = 1;
            } catch (Exception e) {
                System.out.println("Erreur : Vous devez entrer un nombre entier valide.");
                good = 0;
                break;
            } finally {
                scanner.nextLine(); // Consommer l'entrée incorrecte (ou le retour à la ligne)
            }
        }
        if (index >= 0 && index < groups.size()) {
            groups.remove(index);
            System.out.println("Groupe supprimé.");
        } else {
            System.out.println("Numéro invalide.");
        }
    }
    public void addToGroup(Unit unit){

        displayGroups();

        System.out.print("Entrez le numéro du groupe auquel l'ajouter : ");
        int index = 0;
        int good = 0;
        while(good != 1){ // Check pour des erreurs de type de variable

            try {
                index = scanner.nextInt(); // Tente de lire un entier
                good = 1;
            } catch (Exception e) {
                System.out.println("Erreur : Vous devez entrer un nombre entier valide.");
                good = 0;
            } finally {
                scanner.nextLine(); // Consommer l'entrée incorrecte (ou le retour à la ligne)
            }
        }
        if (index >= 0 && index < groups.size()) {
            groups.get(index).addUnit(unit);
            System.out.println("Ajouté au groupe " + index + ".");
        } else {
            System.out.println("Numéro invalide.");
        }
    }

    public void displayUnits(int index){
        
            for (int i = 0; i < groups.get(index).getUnits().size(); i++) {
                Unit unit = groups.get(index).getUnits().get(i);
                if (unit instanceof Infantry) {
                    System.out.println("    (" + i + ") Infantry : "+ ((Infantry) unit).getTypeName() +" - " + unit.getName() + " (" + unit.getCost() + " pts)");
                }
                else if (unit instanceof Vehicle) {
                    System.out.println("    (" + i + ") Vehicle : Transport - " + unit.getName() + " (" + unit.getCost() + " pts, capacité: "+((Vehicle) unit).getCapacity()+")");
                }
            }
        
    }

    public void deleteUnit(){

       
            displayGroups();
            System.out.print("Entrez le numéro du groupe  : ");
            int indexgrp = 0;
            int indexunit = 0;
            int good = 0;
            while(good != 1){ // Check pour des erreurs de type de variable
    
                try {
                    indexgrp = scanner.nextInt(); // Tente de lire un entier
                    good = 1;
                } catch (Exception e) {
                    System.out.println("Erreur : Vous devez entrer un nombre entier valide.");
                    good = 0;
                    break;
                } finally {
                    scanner.nextLine(); // Consommer l'entrée incorrecte (ou le retour à la ligne)
                }
            }
            if (indexgrp >= 0 && indexgrp < groups.size()) {
                
                displayUnits(indexgrp);
                
                System.out.println("Entrez le numéro de l'unité :");
                good = 0;
                while(good != 1){ // Check pour des erreurs de type de variable
    
                    try {
                        indexunit = scanner.nextInt(); // Tente de lire un entier
                        good = 1;
                    } catch (Exception e) {
                        System.out.println("Erreur : Vous devez entrer un nombre entier valide.");
                        good = 0;
                        break;
                    } finally {
                        scanner.nextLine(); // Consommer l'entrée incorrecte (ou le retour à la ligne)
                    }
                }
                if (indexunit >= 0 && indexunit < groups.get(indexgrp).getSize()) {
                    groups.get(indexgrp).removeUnit(indexunit);
                    System.out.println("Unité supprimée.");
                }
            } else {
                System.out.println("Numéro invalide.");
            }
        
    }
    

    

    private static Scanner scanner = new Scanner(System.in);
    // Main method for basic testing
    public static void main(String[] args) {
        boolean continuer = true;
        Army army = new Army("", 2500);
        while(continuer){
        
        int good = 0;
        int choix = 0;
        int getOut = 0;
        String name = "";
            while(good != 1){ // Check pour des erreurs de type de variable
                try {
                    System.out.println("\n===== Menu Armée =====");
                    System.out.println("1. Nouvelle armée");
                    System.out.println("2. Ajouter un groupe");
                    System.out.println("3. Supprimer un groupe"); //afficher les points d'armée utilisés etc
                    System.out.println("4. Voir l'armée");
                    System.out.println("5. Ajouter une unité");
                    System.out.println("6. Supprimer une unité");
                    System.out.println("7. Quitter");
                    System.out.print("Choisissez une option : ");
                    choix = scanner.nextInt(); // Tente de lire un entier
                    good = 1;
                } catch (Exception e) {
                    System.out.println("Erreur : Vous devez entrer un nombre entier valide.");
                    good = 0;
                } finally {
                    scanner.nextLine(); // Consommer l'entrée incorrecte (ou le retour à la ligne)
                
                }
            }

            System.out.println("\n");

            switch(choix){

                case 1:
                
                good = 0;
                
                while(good != 1){ // Check pour des erreurs de type de variable
                try {
                    System.out.println("Donnez un nom:");
                    name = scanner.nextLine(); // Tente de lire un entier
                    good = 1;
                } catch (Exception e) {
                    System.out.println("Erreur : Vous devez entrer un nombre entier valide.");
                    good = 0;
                }
                }
                army = new Army(name,0);
                
                good = 0;
                choix = 0;
                while(good != 1){ // Check pour des erreurs de type de variable
                try {
                    System.out.println("Points d'armée max:");
                    choix = scanner.nextInt(); // Tente de lire un entier
                    if(choix < 0){
                        System.out.println("Erreur: valeur négative entrée");
                        break;
                    }
                    good = 1;
                } catch (Exception e) {
                    System.out.println("Erreur : Vous devez entrer un nombre entier valide.");
                    good = 0;
                } finally {
                    scanner.nextLine(); // Consommer l'entrée incorrecte (ou le retour à la ligne)
                }
                }
                army.setMaxArmyPoints(choix);
                System.out.println("Armée ajoutée");
                break;



                case 2:
                
                good = 0;
                while(good != 1){ // Check pour des erreurs de type de variable
                try {
                    System.out.println("Donnez un nom:");
                    name = scanner.nextLine(); // Tente de lire un string
                    good = 1;
                } catch (Exception e) {
                    System.out.println("Erreur : Vous devez entrer un nom valide.");
                    good = 0;
                }
                }
                Group group = new Group(name);
                army.addGroup(group);
                group.setArmy(army);
                System.out.println("Groupe ajouté.");
                    break;



                case 3:
                    army.displayGroups();
                    army.deleteGroup();
                    break;



                case 4:
                    army.displayArmyInfo();
                    break;



                case 5:
                
                good = 0;
                choix = 0;
                getOut = 0;
                while(good != 1){ // Check pour des erreurs de type de variable
                try {
                    System.out.println("Infanterie ou véhicule ?");
                    System.out.println("1. Infanterie");
                    System.out.println("2. Véhicule");
                    choix = scanner.nextInt(); // Tente de lire un entier
                    good = 1;
                } catch (Exception e) {
                    System.out.println("Erreur : Vous devez entrer un nombre entier valide.");
                    good = 0;
                } finally {
                    scanner.nextLine(); // Consommer l'entrée incorrecte (ou le retour à la ligne)
                
                }
                }
                switch(choix) {
                    case 1:

                        good = 0;
                        while (good != 1) { // Check pour des erreurs de type de variable
                            try {
                                System.out.println("Donnez un nom à l'unité :");
                                name = scanner.nextLine(); // Tente de lire un string
                                good = 1;
                            } catch (Exception e) {
                                System.out.println("Erreur : Vous devez entrer un nom valide.");
                                good = 0;
                            }
                        }

                        good = 0;
                        choix = 0;
                        getOut = 0;
                        while (good != 1) { // Check pour des erreurs de type de variable
                            try {
                                System.out.println("Points de l'unité :");
                                choix = scanner.nextInt(); // Tente de lire un entier
                                if (choix < 0) {
                                    System.out.println("Erreur: valeur négative entrée");
                                    break;
                                }
                                if (army.getSize() + choix > army.getMaxArmyPoints()) {
                                    System.out.println("Erreur: créer cette unité dépasserait la taille maximale de l'armée.");
                                    getOut = 1;
                                    break;
                                }
                                good = 1;
                            } catch (Exception e) {
                                System.out.println("Erreur : Vous devez entrer un nombre entier valide.");
                                good = 0;
                            } finally {
                                scanner.nextLine(); // Consommer l'entrée incorrecte (ou le retour à la ligne)
                            }
                        }
                        good = 0;
                        int type = 0;
                        while (good!=1) { // Check pour des erreurs de type de variable
                            try {
                                System.out.println("Type de l'unité :");
                                System.out.println("1. Soldat");
                                System.out.println("2. Lourd");
                                System.out.println("3. Spécial");
                                System.out.println("4. Chef");
                                type = scanner.nextInt(); // Tente de lire un entier
                                if (type < 1 || type>4) {
                                    System.out.println("Erreur: valeur incorrecte");
                                    break;
                                }
                                good = 1;
                            } catch (Exception e) {
                                System.out.println("Erreur : Vous devez entrer un nombre entier valide.");
                                good = 0;
                            } finally {
                                scanner.nextLine(); // Consommer l'entrée incorrecte (ou le retour à la ligne)
                            }
                        }

                        if (getOut == 0) {
                            Infantry infantry = new Infantry(name, choix, type);
                            army.addToGroup(infantry);
                        }
                        break;


                    case 2:

                        good = 0;
                        getOut = 0;
                        while (good != 1) { // Check pour des erreurs de type de variable
                            try {
                                System.out.println("Donnez un nom à l'unité :");
                                name = scanner.nextLine(); // Tente de lire un string
                                good = 1;
                            } catch (Exception e) {
                                System.out.println("Erreur : Vous devez entrer un nom valide.");
                                good = 0;
                            }
                        }

                        good = 0;
                        choix = 0;
                        while (good != 1) { // Check pour des erreurs de type de variable
                            try {
                                System.out.println("Points de l'unité :");
                                choix = scanner.nextInt(); // Tente de lire un entier
                                if (choix < 0) {
                                    System.out.println("Erreur: valeur négative entrée");
                                    break;
                                }
                                if (army.getSize() + choix > army.getMaxArmyPoints()) {
                                    System.out.println("Erreur: créer cette unité dépasserait la taille maximale de l'armée.");
                                    getOut = 1;
                                    break;
                                }
                                good = 1;
                            } catch (Exception e) {
                                System.out.println("Erreur : Vous devez entrer un nombre entier valide.");
                                good = 0;
                            } finally {
                                scanner.nextLine(); // Consommer l'entrée incorrecte (ou le retour à la ligne)

                            }
                        }

                        good = 0;
                        int capa = 0;
                        if (getOut == 0) {
                            while (good != 1) { // Check pour des erreurs de type de variable
                                try {
                                    System.out.println("Capacité du véhicule :");
                                    capa = scanner.nextInt(); // Tente de lire un entier
                                    if (capa < 0) {
                                        System.out.println("Erreur: valeur négative entrée");
                                        break;
                                    }
                                    good = 1;
                                } catch (Exception e) {
                                    System.out.println("Erreur : Vous devez entrer un nombre entier valide.");
                                    good = 0;
                                } finally {
                                    scanner.nextLine(); // Consommer l'entrée incorrecte (ou le retour à la ligne)

                                }
                            }
                        }
                        if (getOut == 0) {
                            Vehicle vehicle = new Vehicle(name, choix, capa);
                            army.addToGroup(vehicle);
                        }
                        break;
                }
                break;
                case 6:
                army.deleteUnit();
                break;
                case 7:
                    continuer = false;
                    System.out.println("Fin du programme. Merci !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }


        Army myArmy = new Army("Salamanders", 2000);

        Group TacticalSquad = new Group("Tactical Squad");
        Infantry Firedrakes = new Infantry("Firedrakes", 10);
        Vehicle Redeemer = new Vehicle("Redeemer", 50, 10);
        TacticalSquad.addUnit(Firedrakes);
        TacticalSquad.addUnit(Redeemer);
        myArmy.addGroup(TacticalSquad);

        myArmy.displayArmyInfo();

    }
}

class Unit {
    private String name;
    private int cost;

    // Constructor
    public Unit(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    // Getters and Setters
    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Infantry extends Unit {
    private int type; // 1:Soldier / 2:Heavy / 3:Special / 4:Chef

    // Constructors
    public Infantry(String name, int cost) {
        super(name, cost);
        this.type = 1;
    }
    public Infantry(String name, int cost, int type) {
        super(name, cost);
        this.type = type;
    }

    // Getters and Setters
    public int getType() {
        return type;
    }
    public String getTypeName() {
        return switch (type) {
            case 1 -> "Soldat";
            case 2 -> "Lourd";
            case 3 -> "Spécial";
            case 4 -> "Chef";
            default -> "Soldat"; // On met soldier dans le cas où le type n'est pas défini
        };
    }
    public void setType(int type) {
        this.type = type;
    }
}

class Vehicle extends Unit {
    private int capacity;

    // Constructors
    public Vehicle(String name, int cost, int capacity) {
        super(name, cost);
        this.capacity = capacity;
    }

    // Getters and Setters
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}

class Group {
    private String name;
    private int points;
    private ArrayList<Unit> units;
    private Army army;

    // Constructor
    public Group(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    // Setters and Getters
    public String getName() {
        return name;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void addUnit(Unit unit) {
        /*
        System.out.println("Max Army size : " + army.getMaxArmyPoints());
        System.out.println("Used army space" + army.getSize());
        System.out.println("Unit cost" + unit.getCost());
        */
        if (army.getSize()+unit.getCost() <= army.getMaxArmyPoints()) {
            units.add(unit);
            points += unit.getCost();
        } else {
            System.out.println("L'unité a un coût trop élevé pour être ajoutée au groupe !");
        }

    }

    public void removeUnit(int index) {
        units.remove(index);
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public int getSize(){
        return units.size();
    }
    
}