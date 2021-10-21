import classes.Document;
import java.util.Scanner;

/**
 * @(#)DocumentAnalyzer.java
 * Main class to analyze {@link classes.Document}s
 *
 * @author Berke Gokmen
 * @date 2021/10/21
 */
public class DocumentAnalyzer {

  /**
   * Static method that calculates the Tf-idf
   *
   * @param word word to check for
   * @param document document to search
   * @param documents documents array to compare other documents
   * @return {@link Double} result
   */
  public static double calcTfidf(
    String word,
    Document document,
    Document[] documents
  ) {
    return tf(word, document) * idf(word, documents);
  }

  /**
   * Static helper method that calculates the term frequency
   *
   * @param word word to check for
   * @param document document to search
   * @return {@link Double} result
   */
  public static double tf(String word, Document document) {
    int count = document.getCount(word) < 0 ? 0 : document.getCount(word);

    return count * 1.0 / document.getTotalWordCount();
  }

  /**
   * Static method that calculates the idf
   *
   * @param word word to check for
   * @param documents documents array to compare other documents
   * @return {@link Double} result
   */
  public static double idf(String word, Document[] documents) {
    int numOfDocsContainingWord = 0;

    for (Document d : documents) {
      if (d.getCount(word) != -1) {
        numOfDocsContainingWord += 1;
      }
    }

    if (numOfDocsContainingWord == 0) {
      return 0;
    }

    return Math.log(documents.length * 1.0 / numOfDocsContainingWord);
  }

  public static void main(String[] args) throws Exception {
    final Scanner scanner = new Scanner(System.in);

    int numOfDocuments;
    Document[] documents;

    int option;

    System.out.print("Enter the number of documents: ");
    numOfDocuments = scanner.nextInt();
    documents = new Document[numOfDocuments];

    String currentFileName;
    for (int i = 1; i <= numOfDocuments; i++) {
      System.out.print("Enter the name of the document " + i + ": ");
      currentFileName = scanner.next();
      documents[i - 1] = new Document(currentFileName);
    }

    do {
      System.out.println(
        "\n1- Display the frequency of a word\n" +
        "2- Find the most frequent terms\n" +
        "3- Calculate tf-idf for each document"
      );
      System.out.print("Enter an option (x to quit): ");
      option = scanner.nextInt();
      System.out.println();

      if (option == 1) {
        // Display the frequency of a user entered word
        System.out.print(
          "Enter the word for which you want to find the frequency: "
        );
        String wordToProcess = scanner.next();

        for (int i = 1; i <= documents.length; i++) {
          Document d = documents[i - 1];
          double tf = tf(wordToProcess, d);
          System.out.println(
            (("Document (" + i + ") ") + d.getFileName()) +
            ("\n\tWord: " + wordToProcess) +
            ("\n\tTermFrequency: " + tf)
          );
        }

        System.out.println("");
      } else if (option == 2) {
        // Find the most frequent terms in each document
        for (int i = 1; i <= documents.length; i++) {
          Document d = documents[i - 1];
          String mostFrequentWord = d.getMostFrequentWord();
          System.out.println(
            (("Document (" + i + ") ") + d.getFileName()) +
            ("\n\tWord: " + mostFrequentWord) +
            ("\n\tNumber of appearance: " + d.getCount(mostFrequentWord))
          );
        }

        System.out.println("");
      } else if (option == 3) {
        // Calculate the tf-idf of user entered word
        System.out.print(
          "Enter the word for which you want to calculate tf-idf: "
        );

        String wordToProcess = scanner.next();

        for (int i = 1; i <= documents.length; i++) {
          Document d = documents[i - 1];
          double tfidf = calcTfidf(wordToProcess, d, documents);

          System.out.println(
            (("Document (" + i + ") ") + d.getFileName()) +
            ("\n\tWord: " + wordToProcess) +
            ("\n\tf-idf: " + tfidf)
          );
        }

        System.out.println("");
      } else {
        System.out.println("Invalid option.");
      }
    } while (option != 'x');

    scanner.close();
  }
}
