import java.util.*;

public abstract class Chart implements MyObserver {
  private Store store;

  protected Chart(Store store) {
    this.store = store;
  }

  @Override
  public void update(MyObservable observable) {
    display(store.getItemValueByNameEntries());
  }

  public abstract void display(List<? extends Map.Entry<String, Integer>> itemValueByNameEntries);
}
