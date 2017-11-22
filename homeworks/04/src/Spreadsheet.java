import java.util.*;

public class Spreadsheet extends Chart {
  public Spreadsheet(Store store) {
    super(store);
  }

  @Override
  public void display(List<? extends Map.Entry<String, Integer>> itemValueByNameEntries) {
    for (Map.Entry<String, Integer> entry : itemValueByNameEntries) {
      System.out.printf("%s %d\n", entry.getKey(), entry.getValue());
    }
  }
}
