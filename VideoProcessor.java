import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VideoProcessor {

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java VideoProcessor <outputFileName> <inputFile1> <inputFile2> <startTime1> <endTime1> <startTime2> <endTime2> ...");
            return;
        }

        String outputFileName = args[0];
        StringBuilder commandBuilder = new StringBuilder("ffmpeg");

        // Append input files and trim options
        for (int i = 1; i < args.length; i += 4) {
            commandBuilder.append(" -i ").append(args[i]);
            commandBuilder.append(" -ss ").append(args[i + 1]);
            commandBuilder.append(" -to ").append(args[i + 2]);
        }

        // Append filter_complex for merging
        commandBuilder.append(" -filter_complex \"");
        for (int i = 1; i < args.length / 4; i++) {
            commandBuilder.append("[").append(i - 1).append(":v:0][").append(i - 1).append(":a:0]");
        }
        commandBuilder.append("concat=n=").append(args.length / 4).append(":v=1:a=1[v][a]\"");

        // Append output file name
        commandBuilder.append(" -map \"[v]\" -map \"[a]\" ").append(outputFileName);

        String command = commandBuilder.toString();

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
            reader.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
