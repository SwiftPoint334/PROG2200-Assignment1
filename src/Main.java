import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Coach> coaches = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        String teamName;

        System.out.println("== Team Management System ==");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter team name: ");
        teamName = scanner.nextLine();

        while (true) {
            int choice = printMenu();

            switch (choice) {
                case 1:
                    System.out.println("== Add Player ==");
                    try {
                        System.out.print("Enter name: ");
                        String nameChoice = scanner.nextLine();
                        System.out.print("Enter age: ");
                        int ageChoice = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Select position: 1. Goalkeeper 2. Defender 3. Center 4. Forward");
                        int positionChoice = scanner.nextInt();
                        scanner.nextLine();
                        PlayerPosition position;
                        switch (positionChoice) {
                            case 1:
                                position = PlayerPosition.GOALKEEPER;
                                break;
                            case 2:
                                position = PlayerPosition.DEFENDER;
                                break;
                            case 3:
                                position = PlayerPosition.CENTER;
                                break;
                            case 4:
                                position = PlayerPosition.FORWARD;
                                break;
                            default:
                                System.out.println("Invalid position choice.");
                                continue;
                        }
                        System.out.print("Enter jersey number: ");
                        int jerseyNumberChoice = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter ice time (minutes): ");
                        double iceTimeChoice = scanner.nextDouble();
                        scanner.nextLine();
                        Player newPlayer = new Player(nameChoice, ageChoice, position, jerseyNumberChoice, iceTimeChoice);
                        players.add(newPlayer);
                        System.out.println("Player added.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    System.out.println("== Add Coach ==");
                    try {
                        System.out.println("Enter name: ");
                        String nameChoice = scanner.nextLine();
                        System.out.println("Enter age: ");
                        int ageChoice = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Select role: 1. Head Coach 2. Assistant Coach 3. Physiotherapist 4. Manager");
                        int  roleChoice = scanner.nextInt();
                        scanner.nextLine();
                        CoachRole coachRole;
                        switch (roleChoice) {
                            case 1:
                                coachRole = CoachRole.HEAD_COACH;
                                break;
                            case 2:
                                coachRole = CoachRole.ASSISTANT_COACH;
                                break;
                            case 3:
                                coachRole = CoachRole.PHYSIOTHERAPIST;
                                break;
                            case 4:
                                coachRole = CoachRole.MANAGER;
                                break;
                            default:
                                System.out.println("Invalid role choice.");
                                continue;
                        }
                        Coach newCoach = new Coach(nameChoice, ageChoice, coachRole);
                        coaches.add(newCoach);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                    }
                    break;
                case 3:
                    System.out.println("== View Team ==");
                    System.out.println("Team Name: " + teamName);
                    System.out.println("Players: " );
                    for (Player player : players) {
                        System.out.println(player.toString());
                    }
                    System.out.println("Coaches: ");
                    for (Coach coach : coaches) {
                        System.out.println(coach.toString());
                    }
                    break;
                case 4:
                    System.out.println("== Delete Player ==");
                    System.out.println("Enter jersey number of player to remove: ");
                    int playerToRemove = scanner.nextInt();
                    scanner.nextLine();
                    for (Player player : players) {
                        if (player.getJerseyNumber() == playerToRemove) {
                            players.remove(player);
                            System.out.println("Player removed.");
                        } else {
                            System.out.println("Player not found.");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
                }
            }

        }

    static int printMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add player\n2. Add Coach\n3. View Team\n4. Remove Player\n5. Exit");
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new RuntimeException(e);
        }
    }

}
