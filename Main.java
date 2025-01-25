import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        DnaStrands dnaStrands = new DnaStrands('A');
        try (Scanner sc = new Scanner(new File("ass1nin.txt"))) {
            int t = Integer.parseInt(sc.nextLine().trim());
            for (int i = 0; i < t; i++) {
                String[] line = sc.nextLine().trim().split("\\s+");
                int n = Integer.parseInt(line[0]);

                DnaStrands head = null;
                for (int j = n; j > 0; j--) {
                    DnaStrands newNode = new DnaStrands(line[j].charAt(0));
                    newNode.next = head;
                    head = newNode;
                }
                System.out.println( joinstrand(head) +"GC Content:"+dnaStrands.gcContent(head)
                +"ReverseComplement:"+joinstrand(dnaStrands.reverseComplement(head))
                +"Self-complementary:"+dnaStrands.isSelfComplimentary(head));

                }
            String[] generateParameters = sc.nextLine().trim().split("\\s+");
            int length = Integer.parseInt(generateParameters[0]);
            int gc= Integer.parseInt(generateParameters[1]);
            dnaStrands.generateStrands(length,0,gc,null,0);


            }catch (FileNotFoundException e){
            System.out.println("Invalid File");
        }
        }

    private static String joinstrand(DnaStrands head) {
        StringBuilder str = new StringBuilder();
        while (head!= null) {
            str.append(head.bases);
            head = head.next;
        }
        return str.toString();
    }
}