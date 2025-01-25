DNA Strand Manipulation (Java)
This project implements a DNA strand manipulation program in Java, focusing on recursion and linked lists. It includes features to analyze and generate DNA strands, catering to bioinformatics concepts like GC content, reverse complements, and self-complementarity.
Features:
GC Content Calculation
Recursively calculates the GC content (percentage of 'G' and 'C' bases) in a given DNA strand.
Reverse Complement
Finds the reverse complement of a DNA strand using recursion.
Strand Comparison
Compares two DNA strands to check if they are identical.
DNA Strand Generation
Generates all DNA strands of a given length and GC content, ensuring they are not self-complementary.
Self-Complementary Check
Identifies if a DNA strand is self-complementary (matches its reverse complement).
Input and Output
Reads input from a file for multiple test cases and generates results such as GC content, reverse complement, and self-complementary status.
Generates and prints valid DNA strands based on user-defined length and GC content.
Technical Details:
Data Structure: Single-linked list to represent DNA strands.
Recursion: Used extensively for strand manipulation and analysis.
File Handling: Reads input DNA strands and parameters from a file for processing.
Algorithms: Implements DNA strand generation in lexicographic order with recursion.
How to Use:
Input Format:
A text file (assn1in.txt) containing:
Number of test cases (t).
For each test case:
Strand length (n) and the DNA strand.
Parameters for DNA strand generation (length and GC content).
Output:
Displays GC content, reverse complement, and self-complementarity for each strand.
Prints all generated strands based on the given constraints.
