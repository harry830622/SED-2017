import java.util.*;

public class RequireCommandHandler implements CommandHandler {
  private Composition composition;
  private static Map<String, Compositor> compositorByStrategyName;

  static {
    compositorByStrategyName = new HashMap<String, Compositor>();
    compositorByStrategyName.put("SimpleComposition", new SimpleCompositor());
    compositorByStrategyName.put("TexComposition", new TexCompositor());
    compositorByStrategyName.put("ArrayComposition", new ArrayCompositor());
  }

  public RequireCommandHandler(Composition composition) {
    this.composition = composition;
  }

  public void execute(List<String> tokens) {
    String strategyName = tokens.get(1);
    compositorByStrategyName.get(strategyName).compose(composition.getComponents());
  }
}
