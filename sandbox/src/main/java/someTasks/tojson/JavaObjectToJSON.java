package someTasks.tojson;

import com.google.gson.Gson;
import someTasks.tojson.objectexample.ArtifactDto;

public class JavaObjectToJSON {
    public static void main(String[] args) {
        ArtifactDto artifactDto = ArtifactDto.builder()
                .fileName("testName")
                .artifactUrl("https://youtube.com")
                .build();


        Gson gson = new Gson();

        System.out.println(gson.toJson(artifactDto));
    }
}
