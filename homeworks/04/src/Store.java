import java.util.*;

public class Store extends MyObservable {
  private Map<String, Integer> itemValueByName;

  public Store() {
    super();
    itemValueByName = new LinkedHashMap<String, Integer>();
  }

  public List<? extends Map.Entry<String, Integer>> getItemValueByNameEntries() {
    return new ArrayList<Map.Entry<String, Integer>>(itemValueByName.entrySet());
  }

  public void setItemValue(String itemName, int itemValue) {
    itemValueByName.put(itemName, itemValue);
  }
}
