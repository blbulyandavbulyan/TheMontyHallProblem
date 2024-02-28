import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final int countOfExperiments = 10;
        final int totalGames = 1000;
        final List<WinsHistory> history = new ArrayList<>(countOfExperiments);
        WinsCalculator winsCalculator = new WinsCalculator(new GameSimulator());
        for (int i = 0; i < countOfExperiments; i++) {
            final int winsWithoutChangingDoor = winsCalculator.calculateWins(totalGames, false);
            final int winsWithChangingDoor = winsCalculator.calculateWins(totalGames, true);
            history.add(new WinsHistory(winsWithoutChangingDoor, winsWithChangingDoor));
        }
        System.out.printf("Проведено %d экспериментов по %d игр\n", countOfExperiments, totalGames);
        for (int i = 0; i < history.size(); i++) {
            WinsHistory x = history.get(i);
            System.out.printf("Эксперимент %d\n", i+1);
            {
                final int winsWithoutChangingDoor = x.winsWithoutChangingDoor();
                System.out.printf("\tКоличество выигрышей, оставшись при первоначальном выборе: %d, количество поражений: %d, вероятность: %.2f\n",
                        winsWithoutChangingDoor, totalGames - winsWithoutChangingDoor, (double) winsWithoutChangingDoor / totalGames);
            }
            {
                int winsWithChangingDoor = x.winsWithChangingDoor();
                System.out.printf("\tКоличество выигрышей, изменив выбор: %d, количество поражений: %d, вероятность: %.2f\n",
                        winsWithChangingDoor, totalGames - winsWithChangingDoor, (double)winsWithChangingDoor/totalGames);
            }
        }
        double averageWinsWithoutChangingDoor = history.stream()
                .mapToInt(WinsHistory::winsWithoutChangingDoor)
                .average().orElseThrow();
        double averageWinsWithChangingDoor = history.stream()
                .mapToInt(WinsHistory::winsWithChangingDoor)
                .average().orElseThrow();
        System.out.printf("Среднее количество выигрышей при изначальном выборе: %.2f, вероятность: %.2f\n",
                averageWinsWithoutChangingDoor, averageWinsWithoutChangingDoor/totalGames);
        System.out.printf("Среднее количество выигрышей при изменении выбора: %.2f, вероятность: %.2f\n",
                averageWinsWithChangingDoor, averageWinsWithChangingDoor/totalGames);
    }
}
