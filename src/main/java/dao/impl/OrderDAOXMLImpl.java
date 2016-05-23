package dao.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dao.OrderDAO;
import models.Order;

/**
 * Az {@link dao.OrderDAO} interfésznek egy XML feldolgozással történő megvalósítása.
 * Az XML íráshoz DOM-ot használ.
 */
public class OrderDAOXMLImpl implements OrderDAO {
	
	/**
	 * A naplózáshoz használt objektum.
	 */
	private static Logger logger = LoggerFactory.getLogger(OrderDAOXMLImpl.class);

	/**
	 * A függvény a paraméterként megkapott rendelést elmenti egy XML állományban,
	 * ami a felhasználó home könyvtárán belül a .your-dream-skateboard-builder
	 * nevű mappában lesz megtalálható. Amennyiben ez a mappa még nem létezik, a
	 * függvény létrehozza azt.
	 * 
	 * @param order az a rendelés, amit el szeretnénk menteni
	 */
	public void saveOrder(Order order) {
		
		if(order!=null){
		
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			
			try {
				
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				
				Document doc = dBuilder.newDocument();
				
				Element rootElement = doc.createElement("order");
				doc.appendChild(rootElement);
				
				// customerName
				Element customerNameElement = doc.createElement("customerName");
				customerNameElement.appendChild(doc.createTextNode(order.getCustomerName()));
				rootElement.appendChild(customerNameElement);
				
				// customerAddress
				Element customerAddressElement = doc.createElement("customerAddress");
				customerAddressElement.appendChild(doc.createTextNode(order.getCustomerAddress()));
				rootElement.appendChild(customerAddressElement);
				
				// customerPhone
				Element customerPhoneElement = doc.createElement("customerPhone");
				customerPhoneElement.appendChild(doc.createTextNode(order.getCustomerPhone()));
				rootElement.appendChild(customerPhoneElement);
				
				// customerEmail
				Element customerEmailElement = doc.createElement("customerEmail");
				customerEmailElement.appendChild(doc.createTextNode(order.getCustomerEmail()));
				rootElement.appendChild(customerEmailElement);
				
				// customerComment
				Element customerCommentElement = doc.createElement("customerComment");
				customerCommentElement.appendChild(doc.createTextNode(order.getCustomerComment()));
				rootElement.appendChild(customerCommentElement);
				
				// skateboard
				Element skateboardElement = doc.createElement("skateboard");
				rootElement.appendChild(skateboardElement);
				
				// name
				Element nameElement = doc.createElement("name");
				nameElement.appendChild(doc.createTextNode(order.getSkateboard().getName()));
				skateboardElement.appendChild(nameElement);
				
				// bearingId
				Element bearingIdElement = doc.createElement("bearingId");
				bearingIdElement.appendChild(doc.createTextNode(order.getSkateboard().getBearing().getId()));
				skateboardElement.appendChild(bearingIdElement);
				
				// deckId
				Element deckIdElement = doc.createElement("deckId");
				deckIdElement.appendChild(doc.createTextNode(order.getSkateboard().getDeck().getId()));
				skateboardElement.appendChild(deckIdElement);
				
				// griptapeId
				Element griptapeIdElement = doc.createElement("griptapeId");
				griptapeIdElement.appendChild(doc.createTextNode(order.getSkateboard().getGriptape().getId()));
				skateboardElement.appendChild(griptapeIdElement);
				
				// truckId
				Element truckIdElement = doc.createElement("truckId");
				truckIdElement.appendChild(doc.createTextNode(order.getSkateboard().getTruck().getId()));
				skateboardElement.appendChild(truckIdElement);
				
				// wheelId
				Element wheelIdElement = doc.createElement("wheelId");
				wheelIdElement.appendChild(doc.createTextNode(order.getSkateboard().getWheel().getId()));
				skateboardElement.appendChild(wheelIdElement);
				
				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer t = tf.newTransformer();
				t.setOutputProperty(OutputKeys.INDENT, "yes");
				t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
				
				DOMSource source = new DOMSource(doc);
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
				LocalDateTime now = LocalDateTime.now();
				
				Path dirPath = Paths.get(System.getProperty("user.home"), ".your-dream-skateboard-builder");
				String fileName = "order_" + formatter.format(now) + ".xml";
				Path filePath = Paths.get(System.getProperty("user.home"), ".your-dream-skateboard-builder", fileName);
				
				if(!dirPath.toFile().exists()){
					dirPath.toFile().mkdir();
					logger.info("A .your-dream-skateboard-builder nevű mappa még nem létezett, ezért létrehoztuk!");
				}
				
				File file = filePath.toFile();
				
				if(!file.exists()){
					try {
						file.createNewFile();
					} catch (IOException e) {
						logger.error("Kivétel: ", e);
					}
				}
				
				StreamResult result = new StreamResult(file);
				
				t.transform(source, result);
				
			} catch (ParserConfigurationException e) {
				logger.error("Kivétel: ", e);
			} catch (TransformerConfigurationException e) {
				logger.error("Kivétel: ", e);
			} catch (TransformerException e) {
				logger.error("Kivétel: ", e);
			}
		
		}
		
	}

}
