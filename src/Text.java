import org.apache.poi.hslf.extractor.PowerPointExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xslf.usermodel.XSLFSlideShow;
import org.apache.xmlbeans.XmlException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Text
{
    public static String extract(File f)
    {
        String text = "";
        try
        {
            if(f.getName().matches(".*\\.ppt$"))
            {
                System.out.println("正在提取文字 ： " + f.getName());
                PowerPointExtractor ppt = new PowerPointExtractor(new FileInputStream(f));
                text = ppt.getText();
                return text;
            }
            if(f.getName().matches(".*\\.pptx$"))
            {
                System.out.println("正在提取文字 ： " + f.getName());
                XSLFPowerPointExtractor ppt = new XSLFPowerPointExtractor(new XSLFSlideShow(f.getAbsolutePath()));
                text = ppt.getText();
                return text;
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return "error";
        }
        catch (XmlException e)
        {
            e.printStackTrace();
        }
        catch (OpenXML4JException e)
        {
            e.printStackTrace();
        }
        return text;
    }
}
