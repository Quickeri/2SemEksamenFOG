package FunctionLayer;

/**
 The purpose of SVGUtil is to...

 @author kasper
 */
public class SVGUtil {

    /**
     Draw a carport from the long side (that is, width is unused)
 
     @param length
     @param width (unused)
     @param height
     @return SVG string which draws the house
     */
    
    /**
     * The distance between the beams of the carport on each drawing.
     */
    private final int distanceRoof = 60;
    private final int distanceFront = 240;
    private final int distanceSide = 120;
    private final int standardWidth = 15;
    private int roofPartQuantity;
    private int frontPartQuantity;
    private int sidePartQuantity;
    
    public String carport(Order order, String side) {
        StringBuilder sb = new StringBuilder();
        
        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();
        
        switch (side) {
            
            case "roof":
                for (int i = 0; i < 1 + order.getLength() / distanceRoof; i++) {
                    sb.append(carportPart(side, width, standardWidth, 0, length));
                    length -= distanceRoof;
                    roofPartQuantity = i + 1;
                }
                break;
            
            case "front":
                for (int i = 0; i < 1 + order.getWidth() / distanceFront; i++) {
                    sb.append(carportPart(side, height, standardWidth, width, 0));
                    width -= distanceFront;
                    frontPartQuantity = i + 1;
                }
                break;
            
            case "side":
                for (int i = 0; i < 1 + order.getLength() / distanceSide; i++) {
                    sb.append(carportPart(side, height, standardWidth, length, 0));
                    length -= distanceSide;
                    sidePartQuantity = i + 1;
                }
                break;
        }
        return sb.toString();
    }
    
    private static final String[] CARPORTPART_COL = { "none", "#5555FF", "#00DD00", "none", "#FF0000" };

    private String carportPart( String side, int partLength, int partWidth, int xPos, int yPos ) {
        // A one-brick is drawn as a 100x100 rectangle. A four-brick as a 400x100 rectangle
        // The excessive scaling is done to prevent the lines around the bricks to become
        // wery thick when scaled 
        // The colors are based on size, and stored in the static array above
        
        int SVGWidth = 0;
        int SVGHeight = 0;
        
        switch(side){
        
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
                + "style=\"stroke: #000000; fill: " + CARPORTPART_COL[ 2 ] + "\"/>";
        
//        res += "<text x='" + ( xPos * 100 + ( size * 100 ) / 2 ) + "' y='" + ( yPos * 100 + 50 ) + "' "
//                + "font-family=\"Verdana\" font-size=\"50px\""
//                + "text-anchor=\"middle\" alignment-baseline=\"middle\">"
//                + size + "</text>\n";
        return res;
    }

    public int getPartQuantity(String side) {
        int partQuantity = 0;
        
        switch(side){
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
