package nclan.ac.cs.topic5;

import com.google.genai.types.*;
import com.google.genai.Client;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.swing.*;
import java.util.Scanner;

/**
 * Class to demonstrate simple AI char functionality with Gemini 2.5 Flash.
 * API key should <strong>not be shared or stored in GitHub</strong>. Instead, it should be stored in a local
 * environment variable. For Google this is,
 * GOOGLE_API_KEY
 * Use the environment dialogue control to add this for the current user only or use PowerShell.
 * <pre>{@code
 * [System.Environment]::SetEnvironmentVariable("GOOGLE_API_KEY", "AItherestgoeshere", "User")
 * }</pre>
 * Close the console, reopen it and check it is present with,
 * <pre>{@code
 * Get-ChildItem env:/GOOGLE_API_KEY
 * }</pre>
 * From within the code you could run the following to check that the code is reading the API correctly
 * <pre>{@code
 * System.out.println("API KEY FROM JVM: " + System.getenv("GOOGLE_API_KEY"));}</pre>
 */
public class AIGemini {
    public static void main(String[] args) {
        AIGemini myApp = new AIGemini();
        myApp.runTest();
    }

    // Contextual configuration for the responses
    private final GenerateContentConfig config;
    // Client
    private final Client client;

    /**
     * Constructor. Set up the context for the AI and create a client instance.
     */
    public AIGemini() {
        try {
            client = new Client();
            // Bad practice but if hard coding the key then comment out line above and use this instead.
            //client = Client.builder().apiKey("AI your key here").build();
            String guardrails = readResource("guardrails.txt");
            String unitNotes = readResource("base_knowledge.txt");

            // using clear separators is meant to be more efficient for the AI to handle.
            String combinedSystemPrompt = String.format(
                    "### IDENTITY AND RULES ###\n%s\n\n### KNOWLEDGE BASE ###\n%s",
                    guardrails,
                    unitNotes
            );

            // Set the ground rules for the model. This is used as reference, place this outside of any chat loop.
            // Create the context as a System Instruction.
            // systemInstruction is persistent and hard for AI to ignore.
            // Other parts could be
            // Content.fromParts(Part.fromInlineData(<mimetype>,data))
            // Content.fromParts(Part.fromFunctionCall())
            // temperature of 0 is deterministic(ideal for education answers!), 1.0 is more creative!
            // could also use topP(float)
            config = GenerateContentConfig.builder()
                    .systemInstruction(
                            Content.fromParts(Part.fromText(combinedSystemPrompt))
                    ).temperature(0.0f)
                    .build();
        } catch (Exception e) {
            System.err.println("Files not found!");
            throw new RuntimeException(e);
        }
    }

    /**
     * Exercise the code.
     */
    public void runTest() {
        System.out.println("Hello, Gemini AI!");
        System.out.println("You have 3 questions");
        for(int i = 0; i < 3; i++) {
            System.out.println("Enter a question please...");
            Scanner readIn = new Scanner(System.in);
            String question = readIn.nextLine();

            String ans = askQuestion(question);
            System.out.println(ans);
        }
        System.out.println("All questions asked.");
    }

    /**
     * Simple ask a question
     *
     * @param question Question to ask
     * @return the answer returned from the AI
     */
    private String askQuestion(String question) {
        try {
            // Generate content with the question and the config
            GenerateContentResponse response = client.models.generateContent(
                    "gemini-2.5-flash",
                    question,
                    config
            );

            // accurate count of tokens used
            // usageMetadata contains prompt, candidate, and total counts
//            response.usageMetadata().ifPresent(meta -> {
//                System.out.println("Prompt tokens: " + meta.promptTokenCount());
//                System.out.println("Response tokens: " + meta.candidatesTokenCount());
//            });

            return response.text();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to help!", "AI not available", JOptionPane.WARNING_MESSAGE);
        }
        return "";
    }

    /**
     * Read contents of file resources.
     * @param fileName filename to read
     * @return contents of file or empty string if not found.
     */
    public String readResource(String fileName) {
        // Use the ClassLoader to find the file in the resources folder
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (is == null) {
                throw new IllegalArgumentException("File not found: " + fileName);
            }

            // Read the InputStream into a String using a Scanner yes
            try (Scanner scanner = new Scanner(is, StandardCharsets.UTF_8)) {
                return scanner.useDelimiter("\\A").next(); // \A means "beginning of input" (read all)
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public String aiAnswer(String question){
        String ans = askQuestion(question);
        return ans;
    }
}
