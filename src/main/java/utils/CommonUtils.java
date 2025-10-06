package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CommonUtils {

	public static String generateEmail() {
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";
	}

	public static boolean comapreThreeScreenshots(String actualImagePath, String expectedImagePath1,
			String expectedImagePath2) throws IOException {
		BufferedImage actualImage1 = ImageIO.read(new File(actualImagePath));
		BufferedImage expectedImage1 = ImageIO.read(new File(expectedImagePath1));
		BufferedImage expectedImage2 = ImageIO.read(new File(expectedImagePath2));

		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDifference1 = imgDiffer.makeDiff(actualImage1, expectedImage1);
		ImageDiff imgDifference2 = imgDiffer.makeDiff(actualImage1, expectedImage2);

		return !imgDifference1.hasDiff() || !imgDifference2.hasDiff();
	}

	public static boolean comapreTwoScreenshots(String actualImagePath, String expectedImagePath1) throws IOException {
		BufferedImage actualImage1 = ImageIO.read(new File(actualImagePath));
		BufferedImage expectedImage1 = ImageIO.read(new File(expectedImagePath1));

		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDifference1 = imgDiffer.makeDiff(actualImage1, expectedImage1);

		return imgDifference1.hasDiff();
	}
	
	public static Properties loadProperties()
	{
		Properties prop = new Properties();
		try {
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\propertiesData.properties");
		prop.load(file);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
