/**
 * Created by Xelnect on 2/19/14.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        i++;
        String questionNumberIndex = "question number ".concat(Integer.toString(i));
        
        JSONObject questionNumber = (JSONObject) objToBeParsedFromFile.get(questionNumberIndex);
        System.out.println(questionNumber);

    }

}