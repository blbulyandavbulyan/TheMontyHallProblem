import java.util.Random;

public class GameSimulator {
    private final Random random = new Random();
    public boolean simulateGame(boolean changeDoor) {
        int carDoor = random.nextInt(3) + 1;
        int chosenDoor = random.nextInt(3) + 1;
        int openedDoor;
        do {
            openedDoor = random.nextInt(3) + 1;
        } while (openedDoor == chosenDoor || openedDoor == carDoor);
        if (changeDoor) {
            int finalChoice;
            do {
                finalChoice = random.nextInt(3) + 1;
            } while (finalChoice == chosenDoor || finalChoice == openedDoor);
            chosenDoor = finalChoice;
        }
        // Определение результата игры
        return (chosenDoor == carDoor);
    }
}
