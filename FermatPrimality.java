package crypto.projet;

/**
 ** Programme Java pour implémenter l'algorithme de test de primalité de Fermat
 **/
import java.util.Scanner;
import java.util.Random;

/** La Classe FermatPrimality **/
public class FermatPrimality
{
    /** Fonction pour vérifier si le nombre est premier ou pas **/
    public boolean isPrime(long n, int iteration)
    {
        /** cas de base **/
        if (n == 0 || n == 1)
            return false;
        /** cas de base - 2 est premier **/
        if (n == 2)
            return true;
        /** Un nombre pair autre que 2 est composé **/
        if (n % 2 == 0)
            return false;

        Random rand = new Random();
        for (int i = 0; i < iteration; i++)
        {
            long r = Math.abs(rand.nextLong());
            long a = r % (n - 1) + 1;
            if (modPow(a, n - 1, n) != 1)
                return false;
        }
        return true;
    }
    /** Function to calculate (a ^ b) % c **/
    public long modPow(long a, long b, long c)
    {
        long res = 1;
        for (int i = 0; i < b; i++)
        {
            res *= a;
            res %= c;
        }
        return res % c;
    }
    /** Fonction Main **/
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Test d'Algorithme de Primalité de Fermat\n");
        /** Faire un objet de la classe FermatPrimality **/
        FermatPrimality fp = new FermatPrimality();
        /** Accepter le numéro **/
        System.out.println("Entrer un nombre\n");
        long num = scan.nextLong();
        /** Accepter le nombre d'itérations **/
        System.out.println("\nEntrer le nombre d'itérations");
        int k = scan.nextInt();
        /** Vérifie si c'est premier **/
        boolean prime = fp.isPrime(num, k);
        if (prime)
            System.out.println("\n"+ num +" est premier");
        else
            System.out.println("\n"+ num +" est composé");
    }
}
