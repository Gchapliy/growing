package videoHandlingUsingXuggler;

public class VideoProcessing {
    private static final String INPUT_FILE = "sandbox\\src\\main\\resources\\test.mp4";
    private static final String OUTPUT_FILE = "sandbox\\src\\main\\resources\\testNewSize.mp4";

    private static final Integer NEW_HEIGHT = 640;
    private static final Integer NEW_WIDTH = 360;

    public static void main(String[] args) {

        VideoFileData.showVideoFileData(INPUT_FILE);
    }
}