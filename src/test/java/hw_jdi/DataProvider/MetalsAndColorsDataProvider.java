package hw_jdi.DataProvider;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

public class MetalsAndColorsDataProvider {

    @DataProvider(name = "Metals And Colors Data Provider")
    public Object[] DataProvider() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("src/test/resources/MetalsAndColorsData.json")) {

            Type type = new TypeToken<Map<String, Data>>() {
            }.getType();
            Map<String, Data> parsedMap = gson.fromJson(reader, type);
            return parsedMap.values().toArray();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[]{};
    }
}


