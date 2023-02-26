import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a message to encode or decode:");
        String message1 = scan.nextLine();
        String message = "";
        for (int x = message1.length() - 1; x >= 0; x--) {
            message += message1.charAt(x);
        }
        String output = "";
        int keyVal = 0;
        while (keyVal==0) {
            System.out.println("Enter a secret key (-25 to 25):");
            try {
                keyVal = Integer.parseInt(scan.nextLine());
            }
            catch(Exception ex) {
                System.out.println("Enter the key!");
            }
        }
        char key = (char) keyVal;
        // Pętla for wyznaczająca przesunieta litere od a do z oraz od A do Z, w unicode.
        try {
            for (int x = 0; x < message.length(); x++) {
                char input = message.charAt(x);
                if (input >= 'A' && input <= 'Z') {
                    input += key;
                    if (input > 'Z')
                        input -= 26;
                    if (input < 'A')
                        input += 26;
                } else if (input >= 'a' && input <= 'z') {
                    input += key;
                    if (input > 'z')
                        input -= 26;
                    if (input < 'a')
                        input += 26;
                } else if (input >= '0' && input <= '9') {
                    input += (keyVal % 10);
                    if (input > '9')
                        input -= 10;
                    if (input < '0')
                        input += 10;
                }
                output += input;
            }
        } finally {

            System.out.println(output);
            scan.close();
        }
    }
}


