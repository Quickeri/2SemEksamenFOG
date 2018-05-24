package FunctionLayer;

/**
 * The purpose of SVGUtil is to...
 *
 * @author Albert Scheel Vandel (AV98)
 */
public class SVGUtil {

    /**
     * Draw a carport from each side, using the length width and height, of an
     * Order, in different ways depending on which side is being drawn.
     */
    // The distance between the beams of the carport on each drawing, on the sides where this is constant.
    private final int distanceRoof = 55;
    private final int distanceSide = 200;
    
    // the offset on the drawing is used to make space for ruler lines.
    private final int xOffset = 50;
    private final int yOffset = 50;

    // the distance to the parralel sides.
    private final int distToSide = 30;

    // the thickness measurements: width, height, of the carportPart.
    private int sizeLength = 0;
    private int sizeWidth = 0;
    private int sizeHeight = 20;
    
    private int roofHeight = 20;
    
    
    private int frameThickness = 5;

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
                    sb.append(carportPart(side, width, sizeWidth, 0 + xOffset, length + yOffset));
                    length -= distanceRoof;
                    roofPartQuantity = i + 1;
                }
                length = order.getLength();
                //creates longest 2 sides of roof frame. "front" is used to set it to vertical direction.
                String frameVertical = "front";
                for (int i = 0; i < 2; i++) {
                    sb.append(carportPart(frameVertical, length, sizeWidth, width + xOffset, sideRemnant(order, "roof") + yOffset));
                    width -= width;
                }
                width = order.getWidth();
                // creates shortest 2 sides of roof frame, the horizontal ones on the drawing.
                for (int i = 0; i < 2; i++) {
                    sb.append(carportPart(side, width, sizeWidth, 0 + xOffset, length + sideRemnant(order, "roof") + yOffset));
                    length -= (length + sizeWidth);
                }
                length = order.getLength();
                String rim = "front";
                    for(int i = 0; i < 2; i++){
                    sb.append(carportPart(rim, length, sizeWidth, width - distToSide + xOffset, sideRemnant(order, "roof") + yOffset));
                    width -= width - distToSide * 2;
                    }
                  //The code below was to add more rims in case there were more front pillars due to a very wide carport.
                  //It was scrapped as it isn't found neccessary in the beginning.
//                width = order.getWidth();
//                    for(int i = 0; i < 1 + order.getWidth() / distanceFront; i++){
//                    sb.append(carportPart(rim, length, sizeWidth, width - distToSide, sideRemnant(order, "roof")));    
//                    width-= distanceFront;
//                    width-= distToSide/(1 + order.getWidth() / distanceFront);
//                    }
                width = order.getWidth();
                break;

            case "front":
                // 97 mm round up to 10 cm
                sizeWidth = 10;
                for (int i = 0; i < 2; i++) {
                    sb.append(carportPart(side, height, sizeWidth, width - distToSide + sideRemnant(order, side) + xOffset - 5, roofHeight + yOffset));
                    width -= width - distToSide * 2;
                    frontPartQuantity = i + 1;
                }
                // vertical rim
                width = order.getWidth();
                for (int i = 0; i < 2; i++) {
                    sb.append(carportPart(side, sizeHeight, sizeWidth, width - distToSide + sideRemnant(order, side) + xOffset - 5, roofHeight + yOffset));
                    width -= width - distToSide * 2;
                }
                width = order.getWidth();
                //roof
                sb.append(carportPart("roof", width, sizeHeight, sideRemnant(order, side) + xOffset, 0 + yOffset));
                break;
                
            case "side":
                // 97 mm round up to 10 cm
                sizeWidth = 10;
                for (int i = 0; i < 1 + order.getLength() / distanceSide; i++) {
                    sb.append(carportPart(side, height, sizeWidth, length + xOffset, roofHeight + yOffset));
                    length -= distanceSide;
                    sidePartQuantity = i + 1;
                }
                length = order.getLength();
                //horizontal rim
                sb.append(carportPart("roof", length, sizeHeight, sideRemnant(order, "side") + xOffset, roofHeight + yOffset));
                //roof
                sb.append(carportPart("roof", length + frameThickness*2, roofHeight, sideRemnant(order, "side") - frameThickness + xOffset, 0 + yOffset));
                break;
        }
        return sb.toString();
    }

    // an array of colors that can be picked for the carportPart.
    private static final String[] CARPORTPART_COL = {"none", "#5555FF", "#00DD00", "none", "#FF0000"};

    //the method that makes the SVG String for drawing the carport part.
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

    // used for centering the carportParts on the drawing. this is also used on the rectangles on the jsp page.
    public int sideRemnant(Order order, String side) {
        int remnant = 0;
        int remnantSW = sizeWidth / 2;
        switch (side) {
            case "roof":
                remnant = remnantSW + (order.getLength() % distanceRoof) / 2;
                break;
            case "front":
                remnant = remnantSW + (order.getWidth() % (order.getWidth() - distToSide * 2)) / 2;
                break;
            case "side":
                remnant = remnantSW + (order.getLength() % distanceSide) / 2;
                break;
        }
        return remnant;
    }

    // estimate of how many pole shapes there are on each drawing.
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
