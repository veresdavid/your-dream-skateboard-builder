package dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import dao.SkateboardDAO;
import models.Skateboard;
import saxhandlers.SkateboardHandler;

public class SkateboardDAOXMLImpl implements SkateboardDAO {

	public List<Skateboard> getAllSkateboards() {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try {
			
			SAXParser parser = spf.newSAXParser();
			
			SkateboardHandler handler = new SkateboardHandler();
			
			Path path = Paths.get(System.getProperty("user.home"), ".your-dream-skateboard-builder", "skateboards.xml");
			
			File file = path.toFile();
			
			if(!file.exists()){
				return new ArrayList<>();
			}
			
			InputStream is = new FileInputStream(file);
			
			parser.parse(is, handler);
			
			return handler.getSkateboards();
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insert(Skateboard skateboard) {
		
		List<Skateboard> skateboards = getAllSkateboards();
		
		if(skateboards==null){
			skateboards = new ArrayList<>();
		}
		
		skateboards.add(skateboard);
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		try {
			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc = dBuilder.newDocument();
			
			Element rootElement = doc.createElement("skateboards");
			doc.appendChild(rootElement);
			
			for (Skateboard sktbrd : skateboards) {
				
				Element sktbrdElement = doc.createElement("skateboard");
				
				rootElement.appendChild(sktbrdElement);
				
				Element nameElement = doc.createElement("name");
				nameElement.appendChild(doc.createTextNode(sktbrd.getName()));
				sktbrdElement.appendChild(nameElement);
				
				Element bearingIdElement = doc.createElement("bearingId");
				bearingIdElement.appendChild(doc.createTextNode(sktbrd.getBearing().getId()));
				sktbrdElement.appendChild(bearingIdElement);
				
				Element deckIdElement = doc.createElement("deckId");
				deckIdElement.appendChild(doc.createTextNode(sktbrd.getDeck().getId()));
				sktbrdElement.appendChild(deckIdElement);
				
				Element griptapeIdElement = doc.createElement("griptapeId");
				griptapeIdElement.appendChild(doc.createTextNode(sktbrd.getGriptape().getId()));
				sktbrdElement.appendChild(griptapeIdElement);
				
				Element truckIdElement = doc.createElement("truckId");
				truckIdElement.appendChild(doc.createTextNode(sktbrd.getTruck().getId()));
				sktbrdElement.appendChild(truckIdElement);
				
				Element wheelIdElement = doc.createElement("wheelId");
				wheelIdElement.appendChild(doc.createTextNode(sktbrd.getWheel().getId()));
				sktbrdElement.appendChild(wheelIdElement);
				
			}
			
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			DOMSource source = new DOMSource(doc);
			
			Path dirPath = Paths.get(System.getProperty("user.home"), ".your-dream-skateboard-builder");
			Path filePath = Paths.get(System.getProperty("user.home"), ".your-dream-skateboard-builder", "skateboards.xml");
			
			if(!dirPath.toFile().exists()){
				dirPath.toFile().mkdir();
			}
			
			File file = filePath.toFile();
			
			if(!file.exists()){
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			StreamResult result = new StreamResult(file);
			
			t.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
