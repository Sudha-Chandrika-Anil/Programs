public class LabeledLoop {
    public static void main(String[] args) {
        outerLoop: // This is the label for the outer loop
        for (int i = 0; i < 5; i++) {
            innerLoop: // This is the label for the inner loop
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 1) {
                    // Break out of the outer loop when i is 2 and j is 1
                    break outerLoop;
                }
                if (i == 1 && j == 1) {
                    // Skip this iteration of the inner loop when i is 1 and j is 1
                    continue innerLoop;
                }
                System.out.println("i = " + i + ", j = " + j);
            }
        }
    }
}