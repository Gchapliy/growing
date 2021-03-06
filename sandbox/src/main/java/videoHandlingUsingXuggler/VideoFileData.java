package videoHandlingUsingXuggler;

import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IContainer;
import com.xuggle.xuggler.IStream;
import com.xuggle.xuggler.IStreamCoder;

import java.util.concurrent.TimeUnit;

public class VideoFileData {
    public static void showVideoFileData(String filePath) {
        IContainer container = IContainer.make();

        int result = container.open(filePath, IContainer.Type.READ, null);

        int numStreams = container.getNumStreams();

        // query for the total duration

        long duration = container.getDuration();

        // query for the file size

        long fileSize = container.getFileSize();

        // query for the bit rate

        long bitRate = container.getBitRate();

        System.out.println("Number of streams: " + numStreams);

        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(duration),
                TimeUnit.MILLISECONDS.toMinutes(duration) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration)),
                TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));

        System.out.println("Duration: " + hms);

        System.out.println("File Size: " + fileSize / 1_048_576 + "mb");

        System.out.println("Bit Rate: " + bitRate / 1024);

        // iterate through the streams to print their meta data

        for (int i = 0; i < numStreams; i++) {

            // find the stream object

            IStream stream = container.getStream(i);

            // get the pre-configured decoder that can decode this stream;

            IStreamCoder coder = stream.getStreamCoder();

            System.out.println("*** Start of Stream Info ***");

            System.out.printf("stream %d: ", i);

            System.out.printf("type: %s; ", coder.getCodecType());

            System.out.printf("codec: %s; ", coder.getCodecID());

            System.out.printf("duration: %s; ", stream.getDuration());

            System.out.printf("start time: %s; ", container.getStartTime());

            System.out.printf("timebase: %d/%d; ",

                    stream.getTimeBase().getNumerator(),

                    stream.getTimeBase().getDenominator());

            System.out.printf("coder tb: %d/%d; ",

                    coder.getTimeBase().getNumerator(),

                    coder.getTimeBase().getDenominator());

            System.out.println();

            if (coder.getCodecType() == ICodec.Type.CODEC_TYPE_AUDIO) {

                System.out.printf("sample rate: %d; ", coder.getSampleRate());

                System.out.printf("channels: %d; ", coder.getChannels());

                System.out.printf("format: %s", coder.getSampleFormat());

            } else if (coder.getCodecType() == ICodec.Type.CODEC_TYPE_VIDEO) {

                System.out.printf("width: %d; ", coder.getWidth());

                System.out.printf("height: %d; ", coder.getHeight());

                System.out.printf("format: %s; ", coder.getPixelType());

                System.out.printf("frame-rate: %5.2f; ", coder.getFrameRate().getDouble());

            }

            System.out.println();

            System.out.println("*** End of Stream Info ***");

        }

    }
}
