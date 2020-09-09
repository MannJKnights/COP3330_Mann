public class Encrypter
{
    public StringBuilder encrypt(String x)  // Instance method
    {
        int[] startEnc = new int[4];
        char[] charTemp = x.toCharArray();  // Creates a new integer array and converts the string into it
        int i = 0;
        for(char c : charTemp)
        {
            startEnc[i++] = Character.digit(c,10);
        }

        int[] halfEnc = new int[4];
        for(int f = 0; f < 4; f++)  // Takes each digit and adds 7 to it
        {
            halfEnc[f] = startEnc[f] + 7;
        }

        int[] encFin = new int[4];
        for(int j = 0; j < 4; j++)  // Takes the digits and grabs the remainder for it
        {
            encFin[j] = halfEnc[j] % 10;
        }

        int temp0 = encFin[0];
        encFin[0] = encFin[2];
        encFin[2] = temp0;

        temp0 = encFin[1];  // Switches the digits around
        encFin[1] = encFin[3];
        encFin[3] = temp0;

        StringBuilder encString = new StringBuilder();
        for(int w : encFin)
        {
            encString.append(w);  // Converts the int array back into a string and prints it
        }

        return encString;
    }
}
