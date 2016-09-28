import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Text;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Save {
	public Save(String path) throws FileNotFoundException {

		PrintWriter save = new PrintWriter(path);
		save.println("Bad File");
		save.close();

	}

	public Save(String path, double amount, double price, double tax) throws FileNotFoundException {

		try {
			Document doc = new Document();

			Element theRoot = new Element("Variables");
			doc.setRootElement(theRoot);

			Element eAmount = new Element("amount");
			String sAmount = String.valueOf(amount);
			eAmount.addContent(new Text(sAmount));
			theRoot.addContent(eAmount);

			Element ePrice = new Element("price");
			String sPrice = String.valueOf(price);
			ePrice.addContent(new Text(sPrice));
			theRoot.addContent(ePrice);

			Element eTax = new Element("tax");
			String sTax = String.valueOf(tax);
			eTax.addContent(new Text(sTax));
			theRoot.addContent(eTax);

			// theRoot.addContent(eAmount);
			// theRoot.addContent(ePrice);
			// theRoot.addContent(eTax);

			XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileOutputStream(new File(path)));

		} catch (IOException e) {
			e.printStackTrace();
		}

		// PrintWriter save = new PrintWriter(path);
		// save.println("amount + + price + + tax");
		// save.close();

	}
}
