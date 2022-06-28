/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.artsmia;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.artsmia.model.ArtObject;
import it.polito.tdp.artsmia.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxLUN"
    private ChoiceBox<?> boxLUN; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcolaComponenteConnessa"
    private Button btnCalcolaComponenteConnessa; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaOggetti"
    private Button btnCercaOggetti; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalizzaOggetti"
    private Button btnAnalizzaOggetti; // Value injected by FXMLLoader

    @FXML // fx:id="txtObjectId"
    private TextField txtObjectId; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    
    
    @FXML
    void doAnalizzaOggetti(ActionEvent event) {
    	txtResult.clear();
    	this.model.creaGrafo();
    	txtResult.appendText("Grafo creato!\n");
    	txtResult.appendText("#VERTICI: "+this.model.nVertici()+"\n");
    	txtResult.appendText("#VERTICI: "+this.model.nArchi()+"\n");

    }

    @FXML
    void doCalcolaComponenteConnessa(ActionEvent event) {
    	txtResult.clear();
    	int objectId;
    	try {
    		objectId=Integer.parseInt(txtObjectId.getText());
    	}catch(NumberFormatException e) {
    		txtResult.clear();
    		txtResult.appendText("Deve essere un codice numerico!");
    		return;
    	}
    	//TODO controllare che l'Id corrisponda ad un vertice
    	ArtObject vertice = this.model.getObject(objectId);
    	if(vertice == null)
    	{
    		txtResult.clear();
    		txtResult.appendText("Oggetto inesistente");
    		return;
    	}
    	int size = this.model.getComponenteConnessa(vertice);
    	txtResult.appendText("SIZE componente connessa: "+size);

    }

    @FXML
    void doCercaOggetti(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxLUN != null : "fx:id=\"boxLUN\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaComponenteConnessa != null : "fx:id=\"btnCalcolaComponenteConnessa\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaOggetti != null : "fx:id=\"btnCercaOggetti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnalizzaOggetti != null : "fx:id=\"btnAnalizzaOggetti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtObjectId != null : "fx:id=\"txtObjectId\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
