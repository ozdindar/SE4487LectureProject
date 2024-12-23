package chapter10.emails;

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// address: john@doe.com
/*
\b                 # word boundary
[A-Za-z0-9._%+-]+  # one or more alphanumeric or special characters in username
@                  # "@" symbol
[A-Za-z0-9.-]+     # one or more alphanumeric or special characters in domain name
\.                 # period
[A-Z|a-z]{2,}      # two or more letters for top-level domain
\b                 # word boundary
*/
public class FileExtractor {

  String regex ;


  public FileExtractor(String regex) {
    Objects.requireNonNull(regex);
    this.regex = regex;
  }

  public void extract( String inputFilePath, String outputFilePath)
  {
    try {
      FileReader inputFile = new FileReader(inputFilePath);
      BufferedReader bR = new BufferedReader(inputFile);

      FileWriter outputFile = new FileWriter(outputFilePath);
      BufferedWriter bW = new BufferedWriter(outputFile);

      Pattern pattern = Pattern.compile(regex);

      for(String line:bR.lines().toList()) {
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
          bW.write(matcher.group());
          bW.newLine();
        }
      }

      bR.close();
      bW.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
      String emailRX = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
      FileExtractor extractor = new FileExtractor(emailRX);

      extractor.extract("./data/enwik8","./data/output/emails.txt");
  }
}