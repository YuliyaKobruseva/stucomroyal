package stucomroyal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuli
 */
public class StucomRoyal {

    public static ArrayList<Card> cards = new ArrayList<>();
    public static ArrayList<Jugador> jugadores = new ArrayList<>();

    /**
     * @param args the command line arguments
     * @throws java.lang.CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        // TODO code application logic here  
        //creation of users
        jugadores.add(new Jugador("Yuliya", "1111"));
        jugadores.add(new Jugador("Marvin", "2222"));
        jugadores.add(new Jugador("Oriol", "3333"));
        jugadores.add(new Jugador("Mireia", "4444"));

        //creation of cards
        cards.add(new Troop(5, "FireTroop", 23, 12, 3, 56));
        cards.add(new Troop(2, "AirTroop", 10, 8, 1, 25));
        cards.add(new Troop(4, "AquaTroop", 18, 10, 2, 31));

        cards.add(new Structure(5, "Diamond", 24, 15, 4, 43));
        cards.add(new Structure(3, "Octagon", 17, 14, 2, 22));
        cards.add(new Structure(1, "Quadrate", 11, 9, 1, 15));

        cards.add(new Spell(8, "Witch", 12, 6, 3, 32));
        cards.add(new Spell(7, "Magic", 8, 10, 4, 77));
        cards.add(new Spell(10, "Venom", 13, 15, 5, 88));

        /**
         * @param option option of menu chosen by user
         */
        int option;
        do {
            menu();
            option = EntradaDatos.pedirEntero("Eligue una opcion:");
            switch (option) {
                case 1:
                    drawCards();
                    break;
                case 2:
                    battle();
                    break;
                case 3:
                    ranking();
                    break;
                case 4:
                    option = salir();
                    break;
                default:
                    System.out.println("Opcion incorrecta!");
                    break;
            }
        } while (option != 4);
        System.out.println("¡Hasta luego!");
    }

    /**
     * Menu of the program
     */
    public static void menu() {
        System.out.println("********************************");
        System.out.println("Bienvenido a StucomRoyal!!!!");
        System.out.println("********************************");
        System.out.println("1. Conseguir cartas");
        System.out.println("2. Batalla");
        System.out.println("3. Ranking de los jugadores");
        System.out.println("4. Salir");
        System.out.println("*********************************");
    }

    /**
     *
     * Method that allows to choose the cards for player
     *
     * @throws CloneNotSupportedException
     */
    public static void drawCards() throws CloneNotSupportedException {
        String name = EntradaDatos.pedirCadena("Nombre de usuario:");
        String psw = EntradaDatos.pedirCadena("Contrase\u00f1a:");
        Jugador user = user(name, psw);
        if (user == null) {
            System.out.println("Nombre de usuario y/o contrase\u00f1a incorrecta.");
        } else {
            System.out.println("Cartas disponibles:");
            showCardsGame();
            if (quantityCard(user) >= 6) {
                System.out.println("Tu cupo de cartas esta lleno");
            } else {
                System.out.println("Ahora tienes que elegir 6 cartas diferentes.");
                do {
                    int cardUser = EntradaDatos.pedirEntero("Escoge una carta(introduce un numero): ");
                    if (cardUser > 9 || cardUser < 1) {
                        System.out.println("Carta incorrecta");
                    } else {
                        if (checkCard(cards.get(cardUser - 1).getName(), user) != null) {
                            System.out.println("Ya dispones de esta carta.");
                        } else {
                            Card clone = (Card) cards.get(cardUser - 1).clone();
                            user.setCards(clone);
                            System.out.println("Carta añadida a tu cupo.");
                        }
                    }
                } while (quantityCard(user) < 6);
                System.out.println("Tu cupo de cartas esta lleno");
                System.out.println("Esto es tu cupo de cartas:");
                showCardUser(user);
            }
        }
    }

    /**
     * Method that allows to choose the cards for player
     *
     * @throws CloneNotSupportedException
     */
    public static void battle() throws CloneNotSupportedException {
        ArrayList<Card> cardsPl1 = new ArrayList<>();
        ArrayList<Card> cardsPl2 = new ArrayList<>();
        Jugador player1 = choosePlayersBattle(1);
        Jugador player2 = choosePlayersBattle(2);
        if (player1.equals(player2)) {
            System.out.println("No puedes combatir contigo mismo");
        } else {
            if (player1.getCards().isEmpty()) {
                System.out.println("Alguno o ambos de los dos jugadores no dispone de las cartas para batalla");
            } else {
                chooseCardBattle(player1, cardsPl1);
                chooseCardBattle(player2, cardsPl2);
                Jugador userStart = userStart(player1, player2);
                System.out.println("Empieza jugador: " + userStart.getName());
                if (userStart.getName().equals(player1.getName())) {
                    cardAction(player1, player2, cardsPl1, cardsPl2);
                } else {
                    cardAction(player2, player1, cardsPl2, cardsPl1);
                }

            }
        }
    }

    /**
     *
     * Method that creates three battle rounds
     *
     * @param player1 object player1
     * @param player2 object player2
     * @param cardsPL1 Card's ArrayLIst of player1
     * @param cardsPL2 Card's ArrayLIst of player2
     */
    public static void cardAction(Jugador player1, Jugador player2, ArrayList<Card> cardsPL1, ArrayList<Card> cardsPL2) {
        int cont = 1;
        System.out.print("Empieza la batalla!!!!!");
        System.out.print("***********************");
        for (int i = 0; i < 3; i++) {
            System.out.print("Round " + (cont) + " ");
            pause();
            cardAttack(player1, player2, cardsPL1, cardsPL2, i);
            cardAttack(player2, player1, cardsPL2, cardsPL1, i);
            cont++;
        }
        System.out.println("Batalla terminada!!");
        winner(player1, player2, cardsPL1, cardsPL2);
    }

    /**
     * Method that performs attacks of the cards in the round
     *
     * @param player1 Object player1 for battle
     * @param player2 Object player2 for battle
     * @param cardsPL1 Card's ArrayLIst of player1
     * @param cardsPL2 Card's ArrayLIst of player2
     * @param i number of round
     */
    public static void cardAttack(Jugador player1, Jugador player2, ArrayList<Card> cardsPL1, ArrayList<Card> cardsPL2, int i) {
        System.out.println("Ataca " + player1.getName() + " con carta: " + cardsPL1.get(i).getClass().getSimpleName() + ", " + cardsPL1.get(i).toString());
        System.out.println("vs " + player2.getName() + " con carta: " + cardsPL1.get(i).getClass().getSimpleName() + ", " + cardsPL2.get(i).toString());
        System.out.println("Ataque: " + cardsPL1.get(i).attack());
        System.out.println("Defensa: " + cardsPL2.get(i).defense());
        System.out.println("Resultado de ataque: " + (cardsPL1.get(i).attack() - cardsPL2.get(i).defense()));
        if ((cardsPL1.get(i).attack() - cardsPL2.get(i).defense()) < 0) {
            System.out.println("No has hecho ningun daño");
        } else {
            cardsPL2.get(i).setLifeLevel(cardsPL2.get(i).getLifeLevel() - (cardsPL1.get(i).attack() - cardsPL2.get(i).defense()));
        }
        System.out.println("Vida de " + cardsPL2.get(i).getName() + ": " + cardsPL2.get(i).getLifeLevel());
    }

    /**
     * Method to calculate the battle winner
     *
     * @param player1 Object player1
     * @param player2 Object player2
     * @param cardsPL1 Card's ArrayLIst of player1
     * @param cardsPL2 Card's ArrayLIst of player
     */
    public static void winner(Jugador player1, Jugador player2, ArrayList<Card> cardsPL1, ArrayList<Card> cardsPL2) {
        int lifeTotal1 = 0;
        int lifeTotal2 = 0;
        for (int i = 0; i < 3; i++) {
            lifeTotal1 += cardsPL1.get(i).getLifeLevel();
            lifeTotal2 += cardsPL2.get(i).getLifeLevel();
        }
        System.out.println("Vida de las cartas de " + player1.getName() + ": " + lifeTotal1);
        System.out.println("Vida de las cartas de " + player2.getName() + ": " + lifeTotal2);
        if (lifeTotal1 > lifeTotal2) {
            setProphyPlayer(player1, player2);
        } else if (lifeTotal2 > lifeTotal1) {
            setProphyPlayer(player2, player1);
        } else {
            System.out.println("Habeis empatado. Nadie ha consegido los trofeos");
        }
    }

    /**
     * Method that keeps number of trophies won player
     *
     * @param player1 object player1
     * @param player2 object player2
     */
    public static void setProphyPlayer(Jugador player1, Jugador player2) {
        player1.setTrophyNumber(player1.getTrophyNumber() + 5);
        player2.setTrophyNumber(player2.getTrophyNumber() + 1);
        System.out.println("Ganador " + player1.getName() + ". Tus trofeos son 5");
        System.out.println(player2.getName() + " has perdido. Tus trofeos son 1");
    }

    /**
     * Method that allows players to choose for battle
     *
     * @param num player number
     * @return object player
     */
    public static Jugador choosePlayersBattle(int num) {
        Jugador player;
        do {
            System.out.println("Jugador " + num + ":");
            String name = EntradaDatos.pedirCadena("Nombre de usuario:");
            String psw = EntradaDatos.pedirCadena("Contrase\u00f1a:");
            player = user(name, psw);
            if (player == null) {
                System.out.println("Nombre de usuario y/o contrase\u00f1a incorrecta.");
            }
        } while (player == null);
        return player;
    }

    /**
     * Method to choose three cards for the battle
     *
     * @param j object player
     * @param cards Card ArrayList of player
     * @throws CloneNotSupportedException
     */
    public static void chooseCardBattle(Jugador j, ArrayList<Card> cards) throws CloneNotSupportedException {
        System.out.println("Jugador " + j.getName() + " eligue tres cartas para batalla");
        do {
            cards.clear();
            do {
                showCardUser(j);
                int cardPl = EntradaDatos.pedirEntero("Eligue carta:");
                if (cardPl > 6 || cardPl < 1) {
                    System.out.println("Carta incorrecta");
                } else {
                    if (cards.isEmpty()) {
                        Card clone = (Card) j.getCards().get(cardPl - 1).clone();
                        cards.add(clone);
                        System.out.println("Carta añadida a la batalla");
                    } else {
                        Card card = null;
                        boolean existCard = false;
                        for (Card c : cards) {
                            if (c.getName().equalsIgnoreCase(j.getCards().get(cardPl - 1).getName())) {

                                existCard = true;
                            } else {
                                card = j.getCards().get(cardPl - 1);
                            }
                        }
                        if (existCard) {
                            System.out.println("Esta carta ya esta elegida");
                        } else {
                            Card clone = (Card) card.clone();
                            cards.add(clone);
                            System.out.println("Carta añadida a la batalla");
                        }
                    }
                }
            } while (cards.size() < 3);
            if (checkValueofElixirCards(cards) > 10) {
                System.out.println("El valor de elixir de tres cartas no puede superar 10. Vuelve a escoger las cartas");
                System.out.println(checkValueofElixirCards(cards));
            }
        } while (checkValueofElixirCards(cards) > 10);
        System.out.println(j.getName() + " esto son tus cartas para la batalla:");
        showCardBattle(cards);
        System.out.println("***********");
    }

    /**
     * Method to show available cards in battle
     *
     * @param cards Cards ArrayList of battle cards
     */
    public static void showCardBattle(ArrayList<Card> cards) {
        int cont = 1;
        for (Card c : cards) {
            System.out.println(cont + ". " + c.getClass().getSimpleName() + ": " + c);
            cont++;
        }
    }

    /**
     * Method that calculates and returns the player who starts the battle
     *
     * @param j1 object player1
     * @param j2 object player2
     * @return object player who strat the game
     */
    public static Jugador userStart(Jugador j1, Jugador j2) {
        if (j1.getTrophyNumber() > j2.getTrophyNumber()) {
            return j1;
        } else if (j1.getTrophyNumber() < j2.getTrophyNumber()) {
            return j2;
        } else {
            if (((new Random().nextInt(2)) + 1) == 1) {
                return j1;
            } else {
                return j2;
            }
        }
    }

    /**
     * Method that calculates and returns total value of the elixirs of three
     * cards
     *
     * @param cartas Card ArrayList of player in battle
     * @return Elixir total value of card
     */
    public static int checkValueofElixirCards(ArrayList<Card> cartas) {
        int totalValue = 0;
        for (Card c : cartas) {
            totalValue += c.getElixir();
        }
        return totalValue;
    }

    /**
     * Method that checks if the player exists
     *
     * @param name name of player
     * @param psw password of player
     * @return object player
     */
    public static Jugador user(String name, String psw) {
        Jugador user = null;
        for (Jugador j : jugadores) {
            if (j.getName().equalsIgnoreCase(name) && j.getPassword().equalsIgnoreCase(psw)) {
                user = j;
            }
        }
        return user;
    }

    /**
     * Method to show available cards in game
     */
    public static void showCardsGame() {
        int num = 1;
        for (Card c : cards) {
            System.out.println(num + ". " + c.getClass().getSimpleName() + ": " + c);
            num++;
        }
    }

    /**
     *
     * Method that returns the amount of the player's cards
     *
     * @param j object player
     * @return arrayList size
     */
    public static int quantityCard(Jugador j) {
        return j.getCards().size();
    }

    /**
     *
     * Method to check if the player has the card
     *
     * @param nameCard name of card
     * @param j object player
     * @return object card
     */
    public static Card checkCard(String nameCard, Jugador j) {
        Card cardPlayer = null;
        if (!j.getCards().isEmpty()) {
            for (Card c : j.getCards()) {
                if (c.getName().equals(nameCard)) {
                    cardPlayer = c;
                }
            }
        }
        return cardPlayer;
    }

    /**
     *
     * Method to show player's cards
     *
     * @param j object player
     */
    public static void showCardUser(Jugador j) {
        int num = 1;
        for (Card c : j.getCards()) {
            System.out.println(num + ". " + c.getClass().getSimpleName() + ": " + c);
            num++;
        }
    }

    /**
     * Method that orders the players in terms of trophies
     */
    public static void ranking() {
        int num = 1;
        //con la clase Collection de java ordeno los jugadores por trofeo
        Collections.sort(jugadores);
        System.out.println("Mejores jugadores");
        for (Jugador j : jugadores) {
            System.out.println("");
            System.out.println(num + ". " + j.getName() + "\t" + j.getTrophyNumber());
            num++;
        }
    }

    /**
     *
     * Method that allows to stop the application
     *
     * @return value for go out (4-true, 0-false)
     */
    public static int salir() {
        String verify = EntradaDatos.pedirCadena("¿Salir del juego?(Si/No): ");
        if (verify.equalsIgnoreCase("si")) {
            return 4;
        } else {
            return 0;
        }
    }

    /**
     * Method that allows to stop battle between the rounds
     */
    public static void pause() {
        System.out.print("empieza en: \n");
        for (int i = 3; i >= 0; i--) {
            System.out.println(i + "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(StucomRoyal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
