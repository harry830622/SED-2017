import java.util.*;

public class PieChart extends Chart {
  public PieChart(Store store) {
    super(store);
  }

  @Override
  public void display(List<? extends Map.Entry<String, Integer>> itemValueByNameEntries) {
    double sum = 0.0;
    for (Map.Entry<String, Integer> entry : itemValueByNameEntries) {
      sum += entry.getValue();
    }
    for (Map.Entry<String, Integer> entry : itemValueByNameEntries) {
      System.out.printf("%s %.1f%%\n", entry.getKey(), entry.getValue() / sum * 100);
    }
  }
}
