package company.smarsh;

import java.util.*;

public class ResumeKeywordSearch {

    public static void main(String[] args) {
        // List of resumes (simulated as strings)
        List<String> resumes = Arrays.asList(
            "Experienced in JAVA JAVA and SPRING framework, with Oracle database management skills.",
            "Proficient in Python, Machine Learning, and JAVA. Hands-on with SPRING Boot.",
            "Strong expertise in Oracle database and SQL, with limited knowledge of JAVA and SPRING."
        );

        // Keywords to search for
        List<String> keywords = Arrays.asList("JAVA", "SPRING", "Oracle");

        // Search and count occurrences of keywords in resumes
        List<Map<String, Integer>> result = countKeywordOccurrences(resumes, keywords);

        // Display results
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Resume " + (i + 1) + ": " + result.get(i));
        }
    }

    /**
     * Counts the occurrences of specified keywords in each resume.
     *
     * @param resumes  List of resumes (text)
     * @param keywords List of keywords to search
     * @return A list of maps where each map corresponds to a resume and contains keyword counts
     */
    public static List<Map<String, Integer>> countKeywordOccurrences(List<String> resumes, List<String> keywords) {
        // Prepare a result list to store counts for each resume
        List<Map<String, Integer>> result = new ArrayList<>();

        // Convert keywords to a set for faster lookup
        Set<String> keywordSet = new HashSet<>(keywords);

        // Process each resume
        for (String resume : resumes) {
            // Initialize a map to store keyword counts for the current resume
            Map<String, Integer> keywordCounts = new HashMap<>();

            // Split resume text into words and process
            // \w matches word character
            // Think of \W as [^a-zA-Z0-9_],
            String[] words = resume.split("\\W+");
            for (String word : words) {
                // Normalize the word to match keywords case-insensitively
                String normalizedWord = word.toUpperCase();
                if (keywordSet.contains(normalizedWord)) {
                    keywordCounts.put(normalizedWord, keywordCounts.getOrDefault(normalizedWord, 0) + 1);
                }
            }

            // Add the keyword counts for this resume to the result
            result.add(keywordCounts);
        }

        return result;
    }
}
