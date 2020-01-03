package videoHandlingUsingXuggler;

import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import videoHandlingUsingXuggler.tools.MyVideoListener;
import videoHandlingUsingXuggler.tools.Resizer;

public class VideoFileResizing {
    public static void resizeFile(String inputFile, String outputFile, Integer newHeight, Integer newWidth){
        // create custom listeners
        MyVideoListener myVideoListener = new MyVideoListener(newWidth, newHeight);
        Resizer resizer = new Resizer(newWidth, newHeight);

        // reader
        IMediaReader reader = ToolFactory.makeReader(inputFile);
        reader.addListener(resizer);

        // writer
        IMediaWriter writer = ToolFactory.makeWriter(outputFile, reader);
        resizer.addListener(writer);
        writer.addListener(myVideoListener);


        // show video when encoding
        //reader.addListener(ToolFactory.makeViewer( true));

        while (reader.readPacket() == null) {
            System.out.println("coding...");
            // continue coding
        }
    }
}
