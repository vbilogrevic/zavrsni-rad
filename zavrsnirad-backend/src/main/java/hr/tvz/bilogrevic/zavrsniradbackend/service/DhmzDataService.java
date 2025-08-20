package hr.tvz.bilogrevic.zavrsniradbackend.service;

import hr.tvz.bilogrevic.zavrsniradbackend.model.DhmzData;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;

@Service
public class DhmzDataService {

    private static final String dhmzApi = "https://vrijeme.hr/hrvatska1_n.xml";

    public DhmzData getZagrebMaksimir() {
        try {
            Document document = DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .parse(new URL(dhmzApi).openStream());

            NodeList gradImeNodes = document.getElementsByTagName("GradIme");

            for (int i = 0; i < gradImeNodes.getLength(); i++) {
                Node gradNode = gradImeNodes.item(i);

                if (gradNode.getTextContent().trim().equals("Zagreb-Maksimir")) {
                    Node parent = gradNode.getParentNode();

                    if (parent.getNodeType() == Node.ELEMENT_NODE) {
                        Element parentElement = (Element) parent;

                        String temp = parentElement.getElementsByTagName("Temp").item(0).getTextContent();
                        String vlaga = parentElement.getElementsByTagName("Vlaga").item(0).getTextContent();
                        String weather = parentElement.getElementsByTagName("Vrijeme").item(0).getTextContent();

                        return new DhmzData(temp, vlaga, weather);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new DhmzData("-", "-", "-");
    }

}
