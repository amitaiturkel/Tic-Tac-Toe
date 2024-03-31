
public class RendererFactory {
    public static Renderer buildRenderer(String type, int size) {
        Renderer renderer = null;
        switch (type.toLowerCase()) {
            case "console":
                renderer = new ConsoleRenderer(size);
                break;
            case "none":
                renderer = new VoidRenderer();
                break;
            default:
                System.out.println("Invalid renderer type: " + type);
                break;
        }
        return renderer;
    }
}
