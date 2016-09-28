import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Import {
	
	private String sAmount, sPrice, sTax;
	private double amountD, priceD, taxD;

	public Import(String path) throws FileNotFoundException {

		SAXBuilder builder = new SAXBuilder();
		try {
			Document readDoc = builder.build(new File(path));
			
			sAmount = readDoc.getRootElement().getChildText("amount");
			System.out.println("Amount: " + readDoc.getRootElement().getChildText("amount"));
			amountD = Double.parseDouble(sAmount);
			Frame.amountP = (int) amountD;
			
			sPrice = readDoc.getRootElement().getChildText("price");
			System.out.println("Price: " + readDoc.getRootElement().getChildText("price"));
			priceD = Double.parseDouble(sPrice);
			Frame.priceP = (int) priceD;
			
			sTax = readDoc.getRootElement().getChildText("tax");
			System.out.println("Tax: " + readDoc.getRootElement().getChildText("tax"));
			taxD = Double.parseDouble(sTax);
			Frame.taxP = (int) taxD;
			
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

			// File file = new File(path);
			// Scanner in = new Scanner(file);
			// String st = in.nextLine();
			// System.out.println(st);
			// Frame.catcher = st;

		}
	}
}
