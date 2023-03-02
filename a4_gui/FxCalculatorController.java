/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a4_gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import wk03_calc_v3.AstNode;

import wk03_calc_v3.Lexer;

/**
 * FXML Controller class
 *
 * @author Peter
 */
public class FxCalculatorController implements Initializable {

    @FXML
    private Button btnevaluate;
    @FXML
    private TextField txtexpression;
    @FXML
    private TextField txtresult;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onclickevaluate(ActionEvent event) {
        StringBuilder input = new StringBuilder(txtexpression.getText());
        Lexer lexer = new Lexer(input);
        AstNode result = lexer.startRule();
        if (result.type == AstNode.ERROR) {
        txtresult.setText(result.value);
        } else {
            try{
        txtresult.setText(Double.toString(result.evaluate(0)));
            } catch (ArithmeticException ex) {
                txtresult.setText(ex.getMessage());
            }
        }
            
    }

}
