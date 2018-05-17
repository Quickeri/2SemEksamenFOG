package FunctionLayer;

/**
 * The purpose of SVGUtil is to...
 *
 * @author kasper
 */
public class SVGUtil {

    /**
     * Draw a carport from each side, using the length width and height, of an
     * Order, in different ways depending on which side is being drawn.
     *
     * @param length
     * @param width (unused)
     * @param height
     * @return SVG string which draws the carport
     */
    // The distance between the beams of the carport on each drawing.
    private final int distanceRoof = 60;
    private final int distanceFront = 240;
    private final int distanceSide = 120;

    // the thickness measurements: width, height, of the carportPart.
    private int sizeLength = 0;
    private int sizeWidth = 0;
    private int sizeHeight = 0;

    private int roofPartQuantity;
    private int frontPartQuantity;
    private int sidePartQuantity;

    public SVGUtil() {

    }

    public String carport(Order order, String side) {
        StringBuilder sb = new StringBuilder();

        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();

        switch (side) {

            case "roof":
                // 45 mm round up to 5 cm
                sizeWidth = 5;
                for (int i = 0; i < 1 + order.getLength() / distanceRoof; i++) {
                    sb.append(carportPart(side, width, sizeWidth, 0, length));
                    length -= distanceRoof;
                    roofPartQuantity = i + 1;
                }
                length = order.getLength();
                //creates longest 2 sides of roof frame.
                String frame = "front";
                for (int i = 0; i < 2; i++) {
                    sb.append(carportPart(frame, length, sizeWidth, width, sideRemnant(order, "roof")));
                    width -= width;
                }
                width = order.getWidth();
                // creates shortest 2 sides of roof frame
                for (int i = 0; i < 2; i++) {
                    sb.append(carportPart(side, width, sizeWidth, 0, length + sideRemnant(order, "roof")));
                    length -= (length + sizeWidth);
                }
                length = order.getLength();

                break;

            case "front":
                // 97 mm round up to 10 cm
                sizeWidth = 10;
                for (int i = 0; i < 1 + order.getWidth() / distanceFront; i++) {
                    sb.append(carportPart(side, height, sizeWidth, width, 0));
                    width -= distanceFront;
                    frontPartQuantity = i + 1;
                }
                width = order.getWidth();
                break;

            case "side":
                // 97 mm round up to 10 cm
                sizeWidth = 10;
                for (int i = 0; i < 1 + order.getLength() / distanceSide; i++) {
                    sb.append(carportPart(side, height, sizeWidth, length, 0));
                    length -= distanceSide;
                    sidePartQuantity = i + 1;
                }
                length = order.getLength();
                break;
        }
        return sb.toString();
    }

    private static final String[] CARPORTPART_COL = {"none", "#5555FF", "#00DD00", "none", "#FF0000"};

    private String carportPart(String side, int partLength, int partWidth, int xPos, int yPos) {

        int SVGWidth = 0;
        int SVGHeight = 0;

        switch (side) {

            case "roof":
                SVGWidth = partLength;
                SVGHeight = partWidth;
                break;

            case "front":
                SVGWidth = partWidth;
                SVGHeight = partLength;
                break;

            case "side":
                SVGWidth = partWidth;
                SVGHeight = partLength;
                break;
        }
        String res = "<rect x='" + xPos + "' y='" + yPos + "' width='" + SVGWidth + "' height='" + SVGHeight + "'"
                + "style=\"stroke: #000000; fill: " + CARPORTPART_COL[2] + "\"/>";
        
        return res;
    }

    public int sideRemnant(Order order, String side) {
        int remnant = 0;
        int remnantSW = sizeWidth / 2;
        switch (side) {
            case "roof":
                remnant = remnantSW + (order.getLength() % distanceRoof) / 2;
                break;
            case "front":
                remnant = remnantSW + (order.getWidth() % distanceFront) / 2;
                break;
            case "side":
                remnant = remnantSW + (order.getLength() % distanceSide) / 2;
                break;
        }
        return remnant;
    }

    public int getPartQuantity(String side) {
        int partQuantity = 0;

        switch (side) {
            case "roof":
                partQuantity = roofPartQuantity;
                break;
            case "front":
                partQuantity = frontPartQuantity;
                break;
            case "side":
                partQuantity = sidePartQuantity;
                break;
        }
        return partQuantity;
    }
}
