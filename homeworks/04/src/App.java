import java.util.*;

public class App {
  private Store store;
  private List<Chart> charts;

  public App() {
    store = new Store();
    charts = new ArrayList<Chart>();
  }

  public void performDataCommand(String itemName, int itemValue) {
    store.setItemValue(itemName, itemValue);
  }

  public void performAddChartCommand(String chartType) {
    Chart chart = null;
    if (chartType.equals("Spreadsheet")) {
      chart = new Spreadsheet(store);
    } else if (chartType.equals("BarChart")) {
      chart = new BarChart(store);
    } else if (chartType.equals("PieChart")) {
      chart = new PieChart(store);
    } else {
      // TODO: Throw error
    }
    charts.add(chart);
    store.attachObserver(chart);
  }

  public void performChangeCommand(String chartType, String itemName, int itemValue) {
    System.out.printf("%s change %s %d.\n", chartType, itemName, itemValue);
    store.setItemValue(itemName, itemValue);
    store.notifyObservers();
  }
}
