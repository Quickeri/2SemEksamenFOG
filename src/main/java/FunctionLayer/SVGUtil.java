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
    private final int distanceSide = 300;
    
    
    public String carport( int length, int width, int height ) {
        StringBuilder sb = new StringBuilder();
        // creates new layer until height is reached.
        for ( int layer = 0; layer <= height; layer++ ) {
            sb.append( layer( length, layer ) );
        }
        return sb.toString();
    }

    /**
     Alternates between filling in left or right end, and if corner stone is in
     left or
     right end.

     @param length
     @param height
     @return SVG string which draws a layer
     */
    private String layer( int length, int height ) {
        //ensures the new layer is above the previous layers, and that there's space.
        switch ( height % 4 ) {
            case 0:
                return layerFront( length, height, true );
            case 1:
                return layerFront( length, height, false );
            case 2:
                return layerSide( length, height, true );
            case 3:
                return layerSide( length, height, false );
        }
        return "";
    }

    private String layerFront( int length, int yPos, boolean start ) {
        length = length - 2; // make room for a four brick seen from the end
        if ( start ) {
            return mainLayFront( length, 0, yPos ) + carportPart( 2, length, yPos );
        } else {
            return carportPart( 2, 0, yPos ) + mainLayFront( length, 2, yPos );
        }
    }

    private String layerSide( int length, int yPos, boolean start ) {
        length = length - 2;
        if ( start ) {
            return mainLaySide( length, 0, yPos ) + carportPart( 2, length, yPos );
        } else {
            return carportPart( 2, 0, yPos ) + mainLaySide( length, 2, yPos );
        }
    }

    private String mainLayFront( int length, int xPos, int yPos ) {
        StringBuilder sb = new StringBuilder();
        while ( length >= 4 ) { // Place all the 4-bricks
            sb.append( carportPart( 4, xPos, yPos ) );
            length = length - 4;
            xPos = xPos + 4;
        }
        if ( length >= 2 ) { // Place the 2 brick (if needed)
            sb.append( carportPart( 2, xPos, yPos ) );
            length = length - 2;
            xPos = xPos + 2;
        }
        if ( length == 1 ) { // Place the 1 brick (if needed)
            sb.append( carportPart( 1, xPos, yPos ) );
        }
        return sb.toString();
    }

    private String mainLaySide( int length, int xPos, int yPos ) {
        StringBuilder sb = new StringBuilder();
        if ( ( length % 2 ) == 1 ) {// Place the 1 brick (if needed)
            sb.append( carportPart( 1, xPos, yPos ) );
            length--;
            xPos++;
        }
        if ( length % 4 == 2 ) {// Place the 2 brick (if needed)
            sb.append( carportPart( 2, xPos, yPos ) );
            length = length - 2;
            xPos = xPos + 2;
        }
        while ( length >= distanceSide ) {// Place the 4 bricks
            sb.append( carportPart( 4, xPos, yPos ) );
            length = length - distanceSide;
            xPos = xPos + 4;
        }
        return sb.toString();
    }

//    collour brick sizes 1,2 and 4 differently:
    private static final String[] BRICK_COL = { "none", "#5555FF", "#00DD00", "none", "#FF0000" };

    private String carportPart( int size, int xPos, int yPos ) {
        // A one-brick is drawn as a 100x100 rectangle. A four-brick as a 400x100 rectangle
        // The excessive scaling is done to prevent the lines around the bricks to become
        // wery thick when scaled 
        // The colors are based on size, and stored in the static array above
        String res = "<rect x='" + xPos * 100 + "' y='" + yPos * 100 + "' width='" + size * 100 + "' height='100'"
                + "style=\"stroke: #000000; fill: " + BRICK_COL[ size ] + "\"/>";
        // Inside each brick is a text which says its size. The number must be placed in the middle
        // of the brick. The x coordinate is thus the same as the brick, plus 50% of the brick size
        // inaddition, I specify that the text is anchored in the middle.
        // The font size is set to 50px - which is half the height of the brick height
        // The y coordinate is then added 50 (to get to the middle, and the text baseline 
        // is specified to sit in the middle 
        res += "<text x='" + ( xPos * 100 + ( size * 100 ) / 2 ) + "' y='" + ( yPos * 100 + 50 ) + "' "
                + "font-family=\"Verdana\" font-size=\"50px\""
                + "text-anchor=\"middle\" alignment-baseline=\"middle\">"
                + size + "</text>\n";
        return res;
    }

}
