import java.io.*;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        String file = args[0];
        String cid = args[1];

        File rootDir = new File("classes");
        String rootDirPath = rootDir.getAbsolutePath();

        String classDirPath = rootDirPath + File.separator + cid;
        File classDir = new File(classDirPath);
        if(!classDir.exists())
        {
            if(!classDir.mkdir())
            {
                System.out.println("创建目录失败 ： " + classDirPath);
                System.exit(-1);
            }
        }

        File jsonFile = new File(classDirPath + File.separator + "index.json");

        String jsonText = "[";
        String textType = "\"type\":\"text\"";
        String imgType = "\"type\":\"img\"";

        File pptFile = new File(file);

        List pictureNames = Image.extract(pptFile,classDirPath);
        for(Object picture : pictureNames)
        {
            jsonText += "{";
            jsonText += imgType;
            jsonText += ",\"url\":\"";
            jsonText += picture.toString();
            jsonText += "\"},";
        }

        String text = Text.extract(pptFile);
        for(String line : text.split("(\\r|\\n)+"))
        {
            if(!line.matches("\\s*"))
            {
                jsonText += "{";
                jsonText += textType;
                jsonText += ",\"content\":\"";
                jsonText += line;
                jsonText += "\"},";
            }
        }

        jsonText = jsonText.substring(0,jsonText.length()-1);
        jsonText += "]";

        FileWriter fw = new FileWriter(jsonFile);
        fw.write(jsonText);
        fw.close();
    }
}
