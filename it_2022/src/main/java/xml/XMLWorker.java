package xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import repositories.Repository;

public class XMLWorker {
	
	public void writeToXmlFile(String pathToXMLFile, Repository instance) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Repository.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(instance, new File(pathToXMLFile));
	}
	
	public Repository readFromXmlFile(String pathToXMLFile, String schemaFilePath) throws JAXBException, FileNotFoundException, UnsupportedEncodingException, SAXException {
		JAXBContext context = JAXBContext.newInstance(Repository.class);
		Unmarshaller um = context.createUnmarshaller();
		
		SchemaFactory sf =SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File(schemaFilePath));
		um.setSchema(schema);
		
		InputStream inputStream = new FileInputStream(pathToXMLFile);
		Reader reader = new InputStreamReader(inputStream, "UTF-8");
		
		Repository instance = (Repository) um.unmarshal(reader);
		return instance;	
	}

}
