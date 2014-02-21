/**
 * Created by Xelnect on 2/19/14.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

    public static int i=0;

    public static void main(String[] args) {
        jsonObjectExtractor(jsonFileReader());
    }

    public static JSONObject jsonFileReader() {
        JSONParser parser = new JSONParser();
        Object objToBeParsedFromFile = null;
        JSONObject jsonObjectFromObj = null;

        try {
            objToBeParsedFromFile = parser.parse(new FileReader("C:\\Users\\Xelnect\\Desktop\\JSonWritten.json"));
            jsonObjectFromObj = (JSONObject) objToBeParsedFromFile;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObjectFromObj;
    }

    public static void jsonObjectExtractor(JSONObject objToBeParsedFromFile) {
        JSONObject questionNumber;
        do{
        i++;
        String questionNumberIndex = "question number ".concat(Integer.toString(i));

        questionNumber = (JSONObject) objToBeParsedFromFile.get(questionNumberIndex);
        System.out.println(questionNumber);

        readQuestionType(questionNumber);
        readQuestionText(questionNumber);
        readAnswerText(questionNumber);

        System.out.println( readQuestionType(questionNumber));
        System.out.println(readQuestionText(questionNumber));
        System.out.println(readAnswerText(questionNumber));
        }
        while(!questionNumber.equals("null"));
    }
    public static ArrayList readAnswerText(JSONObject obj) {
        JSONArray answerTextJsonArray = (JSONArray) obj.get("answerText");
        ArrayList answerTextArray = new ArrayList();
        Iterator<String> iterator = answerTextJsonArray.iterator();
        while (iterator.hasNext()) {
            answerTextArray.add(iterator.next());
        }
        return answerTextArray;
    }
    public static String readQuestionText(JSONObject obj) {
        String questionText = (String) obj.get("questionText");
        return questionText;
    }
    public static String readQuestionType(JSONObject obj) {
        String questionType = (String) obj.get("questionType");
        return questionType;
    }
}