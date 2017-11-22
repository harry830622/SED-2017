import java.util.*;

public class DataCommandHandler implements CommandHandler {
  private App app;

  public DataCommandHandler(App app) {
    this.app = app;
  }

  @Override
  public void execute(List<String> tokens) {
    String itemName = tokens.get(1);
    int itemValue = Integer.parseInt(tokens.get(2));
    app.performDataCommand(itemName, itemValue);
  }
}
