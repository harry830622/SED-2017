import java.util.*;

public class BarChart extends Chart {
  public BarChart(Store store) {
    super(store);
  }

  @Override
  public void display(List<? extends Map.Entry<String, Integer>> itemValueByNameEntries) {
    for (Map.Entry<String, Integer> entry : itemValueByNameEntries) {
      for (int i = 0; i < entry.getValue(); ++i) {
        System.out.printf("=");
      }
      System.out.printf(" %s\n", entry.getKey());
    }
  }
}
