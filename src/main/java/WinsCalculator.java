import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WinsCalculator {
    private final GameSimulator gameSimulator;
    public int calculateWins(int totalGames, boolean changeDoor) {
        int wins = 0;
        for (int i = 0; i < totalGames; i++) {
            if (gameSimulator.simulateGame(changeDoor)) {
                wins++;
            }
        }
        return wins;
    }
}
