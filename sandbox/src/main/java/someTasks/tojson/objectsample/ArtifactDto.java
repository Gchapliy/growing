package someTasks.tojson.objectsample;

import lombok.Builder;

@Builder
public class ArtifactDto {
    private Long id;
    private String artifactUrl;
    private String fileName;
    private long fileSize;
}
