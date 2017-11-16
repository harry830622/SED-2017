import java.util.*;

public class Composition {
  private List<Component> components;
  private Map<Integer, Component> componentById;

  public Composition() {
    components = new ArrayList<Component>();
    componentById = new HashMap<Integer, Component>();
  }

  public List<Component> getComponents() {
    return new ArrayList<Component>(components);
  }

  public Component getComponentById(int componentId) {
    return componentById.get(componentId);
  }

  public void addComponent(Component component) {
    components.add(component);
    componentById.put(component.getId(), component);
  }

  public void render(Compositor compositor) {
    compositor.compose(components);
  }
}
