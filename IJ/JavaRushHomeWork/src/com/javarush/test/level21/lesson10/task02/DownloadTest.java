package com.javarush.test.level21.lesson10.task02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by Dima on 27.06.2016.
 */
public class DownloadTest
{

    public static void main(String[] args) throws IOException
    {
        URL website = new URL("http://www.dvblogic.com/download/installations/qnap-linux-arm-x19/dvblink-epgdata-qnap-linux-arm-x19-5.5.0.dlp");
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("D:\\installation.dlp");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }
}
