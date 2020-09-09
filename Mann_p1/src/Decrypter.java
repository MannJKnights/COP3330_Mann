public class Decrypter
{
    public StringBuilder decrypt(String x)  // Instance method
    {
        int[] startDec = new int[4];
        char[] charTemp = x.toCharArray();
        int i = 0;
        for(char c : charTemp)  // Takes a string and converts it into an int array
        {
            startDec[i++] = Character.digit(c,10);
        }

        int temp0 = startDec[0];
        startDec[0] = startDec[2];
        startDec[2] = temp0;

        temp0 = startDec[1];  // Switches the numbers around to the correct order
        startDec[1] = startDec[3];
        startDec[3] = temp0;

        int[] decFin = new int[4];
        for(int f = 0; f < 4; f++)  // Moves through the 4 digits and reverses the remainder and removes the added 7
        {
            switch (startDec[f])
            {
                case 7 -> decFin[f] = 0;
                case 8 -> decFin[f] = 1;
                case 9 -> decFin[f] = 2;
                case 0 -> decFin[f] = 3;
                case 1 -> decFin[f] = 4;
                case 2 -> decFin[f] = 5;
                case 3 -> decFin[f] = 6;
                case 4 -> decFin[f] = 7;
                case 5 -> decFin[f] = 8;
                case 6 -> decFin[f] = 9;
            }
        }

        StringBuilder decString = new StringBuilder();
        for(int w : decFin)
        {
            decString.append(w);  // Converts int array back into a string and returns it to be printed;
        }

        return decString;
    }
}
