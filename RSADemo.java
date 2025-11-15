import java.util.Scanner;

public class RSADemo {

    public static void main(String[] args) {

        String msg;
        int pt[] = new int[100];
        int ct[] = new int[100];
        int z, n, d = 0, e, p, q, mlen;

        Scanner in = new Scanner(System.in);

        // Get p and q (prime numbers)
        do {
            System.out.println("Enter the two large prime number for p and q");
            p = in.nextInt();
            q = in.nextInt();
        } while (prime(p) == 0 || prime(q) == 0);

        n = p * q;
        z = (p - 1) * (q - 1);

        System.out.println("n=" + n + " z=" + z);

        // Find e such that gcd(e,z)=1
        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1)
                break;
        }

        System.out.println("e=" + e + " n=" + n);

        // Find d such that (e*d) % z = 1
        for (d = 2; d < z; d++) {
            if ((e * d) % z == 1)
                break;
        }

        // Print correct d AFTER loop
        System.out.println("d=" + d + " n=" + n);

        in.nextLine();  // clear buffer

        // Input message
        System.out.println("Enter the message for encryption");
        msg = in.nextLine();
        mlen = msg.length();

        // Convert msg → ASCII
        for (int i = 0; i < mlen; i++)
            pt[i] = msg.charAt(i);

        System.out.println("ASCII Values of PT array is");
        for (int i = 0; i < mlen; i++)
            System.out.println(pt[i]);

        // Encrypt
        System.out.println("Encryption:Ciper Text Obtained:");
        for (int i = 0; i < mlen; i++)
            ct[i] = mult(pt[i], e, n);
        for (int i = 0; i < mlen; i++)
            System.out.println(ct[i] + "\t");

        // Decrypt
        System.out.println("\nDecryption:Plain Text Obtained:");
        for (int i = 0; i < mlen; i++)
            pt[i] = mult(ct[i], d, n);
        for (int i = 0; i < mlen; i++)
            System.out.println(pt[i] + "." + (char) pt[i]);

        // NOTE: in.close() removed as per your request
    }

    // GCD
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Check prime
    public static int prime(int num) {
        if (num <= 1) return 0;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return 0;
        }
        return 1;
    }

    // Modular exponentiation by repeated multiplication
    public static int mult(int base, int exp, int n) {
        int res = 1;
        for (int j = 1; j <= exp; j++)
            res = (res * base) % n;
        return res;
    }
}
