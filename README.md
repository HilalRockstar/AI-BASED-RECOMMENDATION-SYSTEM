# AI-BASED-RECOMMENDATION-SYSTEM

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: HAMEED HILAL

*INTERN ID*: CT04XHI

*DOMAIN*: JAVA

*DURATION*: 4 WEEKS

*MENTOR*: NEELA SANTOSH

# Mobile Recommendation System using Apache Mahout
In today's technology-driven world, personalized recommendations have become an essential feature of e-commerce platforms. Whether it’s suggesting a product, a movie, or a mobile phone, recommendation systems play a crucial role in enhancing user experience. The Mobile Recommendation System is a Java-based project that uses Apache Mahout to provide personalized mobile phone suggestions based on user preferences. The system applies User-Based Collaborative Filtering, a widely used recommendation technique, to analyze user ratings and recommend the best mobile phones accordingly.

This project works with a CSV-based dataset containing user ratings for different mobile phones. Instead of using mobile IDs, the system displays mobile names for better clarity. By analyzing user behavior and preferences, the recommendation engine helps users discover the most suitable mobile phone based on ratings given by others with similar tastes. Additionally, the project incorporates an evaluation mechanism using Apache Mahout’s Recommender Evaluator, which measures the accuracy of recommendations.

# Technology Stack
The system is developed using Java and utilizes Apache Mahout for implementing the recommendation algorithm. The data is stored in a CSV file, making it easy to manage and extend. The recommendation engine is built using User-Based Collaborative Filtering, with Pearson Correlation Similarity as the similarity measurement method. This ensures that users receive accurate recommendations based on their previous interactions.

# Features of the System
One of the key features of the system is its ability to analyze user preferences and suggest mobile phones that best match their interests. Unlike traditional search-based suggestions, this system learns from user interactions and provides personalized recommendations.

1. User-Based Collaborative Filtering
The system identifies users with similar preferences and suggests mobile phones that have been highly rated by users with comparable tastes. This technique ensures that recommendations are based on real-world user behavior rather than random selections.

2. Best-Rated Mobile Suggestion
Instead of displaying random recommendations, the system identifies the highest-rated mobile phone(s) for a specific user and presents them as recommendations. This makes the system more relevant and user-friendly.

3. CSV-Based Data Storage
The system reads user ratings from a CSV file, which contains three key columns: User ID, Mobile Name, and Rating. The use of mobile names instead of IDs improves clarity and enhances the user experience.

4. Recommender Evaluation
The system uses Apache Mahout’s Recommender Evaluator to assess the accuracy of recommendations. The evaluation score provides a measure of how effective the recommendation engine is in predicting user preferences.

# How the System Works
The system follows a step-by-step process to generate recommendations. First, it prompts the user to enter their User ID. Once the input is provided, the system scans the dataset to identify the mobile phones rated by the user. It then determines the best-rated mobile(s) for that particular user and presents them as recommendations.

After displaying the recommendations, the system also evaluates its accuracy using Apache Mahout’s Average Absolute Difference Evaluator. This ensures that the recommendations are reliable and meaningful rather than being randomly generated.

# Future Enhancements
1.The project has significant potential for future enhancements. Some possible improvements include:

2.Larger Dataset: Expanding the dataset with real-world user ratings for a diverse range of mobile phones.

3.Database Integration: Replacing CSV file storage with MySQL or MongoDB for better scalability.

4.Hybrid Recommendation Model: Combining User-Based and Item-Based Filtering for more accurate suggestions.

5.Web-Based Interface: Developing a web application where users can input ratings and get real-time recommendations.
