import java.util.*;

public class ChangeCommandHandler implements CommandHandler {
  private App app;

  public ChangeCommandHandler(App app) {
    this.app = app;
  }

  @Override
  public void execute(List<String> tokens) {
    String chartType = tokens.get(1);
    String itemName = tokens.get(2);
    int itemValue = Integer.parseInt(tokens.get(3));
    app.performChangeCommand(chartType, itemName, itemValue);
  }
}
