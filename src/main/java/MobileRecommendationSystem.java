import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.*;
import java.util.*;

public class MobileRecommendationSystem {
    private static final Map<Integer, String> mobileNames = new HashMap<>();

    public static void main(String[] args) {
        try {
            File file = new File("mobile_ratings.csv");
            if (!file.exists()) {
                createSampleCSV(file);
            }

            loadMobileNames(); // Load mobile names from predefined data

            DataModel model = new FileDataModel(file);
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);
            Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();
            scanner.close();

            // Get the best-rated mobiles for the given user
            List<String> bestMobiles = getBestRatedMobiles(file, userId);

            System.out.println("\n🔹 Best Recommended Mobile(s) for User " + userId + ":");
            if (bestMobiles.isEmpty()) {
                System.out.println("  No recommendations available.");
            } else {
                for (String mobileName : bestMobiles) {
                    System.out.println("  Mobile Name: " + mobileName);
                }
            }

            // Recommender Evaluation
            RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
            double score = evaluator.evaluate(
                    model1 -> new GenericUserBasedRecommender(model1, neighborhood, similarity),
                    null, model, 0.7, 1.0
            );
            System.out.println("\n🔹 Recommender Evaluation Score: " + score);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getBestRatedMobiles(File file, int userId) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        double maxRating = 0;
        List<String> bestMobiles = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length < 3) continue;

            int uId = Integer.parseInt(parts[0]);
            int mobileId = Integer.parseInt(parts[1]);
            double rating = Double.parseDouble(parts[2]);

            if (uId == userId) {
                String mobileName = mobileNames.getOrDefault(mobileId, "Unknown Mobile");
                if (rating > maxRating) {
                    maxRating = rating;
                    bestMobiles.clear();
                    bestMobiles.add(mobileName);
                } else if (rating == maxRating) {
                    bestMobiles.add(mobileName);
                }
            }
        }
        br.close();
        return bestMobiles;
    }

    private static void loadMobileNames() {
        // Mapping Mobile IDs to Mobile Names
        mobileNames.put(101, "Samsung Galaxy S23");
        mobileNames.put(102, "iPhone 14 Pro");
        mobileNames.put(103, "OnePlus 11");
        mobileNames.put(104, "Google Pixel 7");
        mobileNames.put(105, "Xiaomi Mi 12");
    }

    private static void createSampleCSV(File file) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("1,101,5");
            writer.println("1,102,3.5");
            writer.println("1,103,4.5");
            writer.println("2,101,4");
            writer.println("2,102,5");
            writer.println("2,103,3");
            writer.println("3,101,3.5");
            writer.println("3,104,4");
            writer.println("3,105,5");
            writer.println("4,102,4.5");
            writer.println("4,105,2");
            writer.println("5,101,4");
            writer.println("5,103,5");
            writer.println("6,104,3.5");
            writer.println("6,105,4.5");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
