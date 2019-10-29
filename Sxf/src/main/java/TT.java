public class TT {
    public static void main(String[] args) {
        int intSize = Integer.SIZE;

        System.out.println("    int size: " + (intSize/8) + "Byte" );



        int shortSize = Short.SIZE;

        System.out.println("  short size: " + (shortSize/8) + "Byte" );



        int longSize = Long.SIZE;

        System.out.println("   long size: " + (longSize/8) + "Byte" );


        int byteSize = Byte.SIZE;

        System.out.println("   byte size: " + (byteSize/8) + "Byte" );



        int floatSize = Float.SIZE;

        System.out.println("  float size: " + (floatSize/8) + "Byte" );



        int doubleSize = Double.SIZE;

        System.out.println(" double size: " + (doubleSize/8) + "Byte" );

    }
}
