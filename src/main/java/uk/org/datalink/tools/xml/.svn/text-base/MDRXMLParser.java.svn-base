package uk.org.datalink.tools.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class MDRXMLParser {

	private final DocumentBuilder documentBuilder = makeDocumentBuilderFactory();
	private final Transformer transformer = makeTransmformer();
	protected final Log logger = LogFactory.getLog(getClass());

	private static DocumentBuilder makeDocumentBuilderFactory()
	{
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      dbf.setNamespaceAware(true);
	      try
	      {
	         return dbf.newDocumentBuilder();
	      }
	      catch(ParserConfigurationException e)
	      {
	         throw new Error(e);
	      }
	 }

	   private static Transformer makeTransmformer()
	   {
	      TransformerFactory tf = TransformerFactory.newInstance();
	     try
	      {
	         return tf.newTransformer();
	      }
	      catch(TransformerConfigurationException e)
	      {
	         throw new Error(e);
	      }
	   }
	   public Document parse(File file) throws IOException, SAXException
	   {
	      FileInputStream fis = new FileInputStream (file);
	      Document doc;
	      try
	      {
	         doc = parse(fis);
	      }
	      finally
	      {
	         fis.close();
	      }
	      return doc;
	   }

	   public synchronized void write(Document doc, OutputStream outputStream) throws TransformerException
	   {
	      DOMSource domSource = new DOMSource(doc);
	      StreamResult streamResult = new StreamResult(outputStream);
	      this.write(domSource, streamResult);
	   }


	   public synchronized Document parse(InputStream inputStream) throws IOException, SAXException
	   {
		  if (inputStream!=null){
			  return documentBuilder.parse(inputStream);
		  }else{
			  logger.info("inputStream IS NULL");
	          return null;
		  }
	   }


	   public Document makeDocument()
	   {
	      return documentBuilder.newDocument();
	   }

	   public void write(Document doc, Writer out) throws TransformerException
	   {
	      StreamResult streamResult = new StreamResult(out);
	      this.write(doc, streamResult);
	   }

	   public void write(DOMSource domSource, StreamResult streamResult) throws TransformerException
	   {
	      transformer.transform(domSource, streamResult);
	   }
	   
	   public void write(Document doc, StreamResult streamResult) throws TransformerException
	   {
	      DOMSource domSource = new DOMSource(doc);
	      transformer.transform(domSource, streamResult);
	   }
}
