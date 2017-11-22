import java.util.*;

public class AddChartCommandHandler implements CommandHandler {
  private App app;

  public AddChartCommandHandler(App app) {
    this.app = app;
  }

  @Override
  public void execute(List<String> tokens) {
    String chartType = tokens.get(1);
    app.performAddChartCommand(chartType);
  }
}
