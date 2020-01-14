package someTasks.tojson.objectexample;

import lombok.Builder;

@Builder
public class ArtifactDto {
    private Long id;
    private String artifactUrl;
    private String fileName;
    private long fileSize;
}
