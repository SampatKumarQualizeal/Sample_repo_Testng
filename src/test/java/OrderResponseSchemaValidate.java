package testobjects;

import org.apache.commons.io.FileUtils;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.util.regex.Pattern;

public class OrderResponseSchemaValidate {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean validateThatOrderResponseIsValid(String responseInString) {
        try {
            JSONObject jsonSchema = new JSONObject(
                    new JSONTokener(FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/OrderResponseSchema.json"), "UTF-8")));
            JSONObject jsonSubject = new JSONObject(
                    new JSONTokener(responseInString));
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean verifyContentOfOrderResponse(String responseInString, int expectedLineItems) {
        try {
            JSONObject jsonObject = new JSONObject(responseInString);
            JSONArray lineItems = jsonObject.getJSONArray("ebsOrderLineItems");
            if (lineItems.length() != expectedLineItems){
                return false;
            }
            for (int i = 0; i < expectedLineItems; i++) {
                if (!isNumeric(lineItems.getJSONObject(i).get("ecommOrderItemID").toString()))
                    return false;
                if (!isNumeric(lineItems.getJSONObject(i).get("ebsOrderLineId").toString()))
                    return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean verifyEbsOrderNumberInResponse(String responseInString, String ebsNumber) {
        try {
            JSONObject jsonObject = new JSONObject(responseInString);
            if (jsonObject.get("ebsOrderNumber").equals(ebsNumber))
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static JSONObject getJsonObjectForResponse(String responseInString) {
        try {
            return new JSONObject(responseInString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

}
