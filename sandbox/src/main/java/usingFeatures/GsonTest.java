package usingFeatures;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GsonTest {
    public static void main(String[] args){
        String json = "{\n" +
                "      \"goodsId\": \"52550\",\n" +
                "      \"goods_name\": \"Санітар спрей дез.засіб д/рук фл. 100мл\",\n" +
                "      \"count\": \"20.000\",\n" +
                "      \"tax_group\": 2,\n" +
                "      \"incom_price\": \"31.42000\",\n" +
                "      \"outcom_price\": \"40.40\",\n" +
                "      \"serial\": \"003\",\n" +
                "      \"shipment_1s_code\": \"1\",\n" +
                "      \"expirationDate_1c\": \"01.08.2023 0:00:00\",\n" +
                "      \"provider_name\": \"test_provider\",\n" +
                "      \"certificates\": \n" +
                "      [\"https://www.konex.com.ua/konex24/goods/46521/46521_0_l.jpg\",\n" +
                "      \"https://www.konex.com.ua/konex24/goods/46/46_0_s.jpg?ver=0.49541605613513573\",\n" +
                "      \"https://www.konex.com.ua/konex24/goods/87/87_0_s.jpg?ver=0.2649434261671071\"]\n" +
                "    }";
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        for (JsonElement element : jsonObject.get("certificates").getAsJsonArray()){
            System.out.println(element.getAsString());
        };
    }
}
