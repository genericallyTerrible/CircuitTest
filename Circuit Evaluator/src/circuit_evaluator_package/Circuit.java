/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package circuit_evaluator_package;

import java.util.ArrayList;

/**
 *
 * @author mtbjj
 */

public class Circuit {
    ArrayList<Node> nodes;
    ArrayList<Element> elements;
    
    Circuit() {
        nodes = new ArrayList<>();
        elements = new ArrayList<>();
    }
    
    void addElement(Element element) {
        elements.add(element);
    }
    
    void connectElements(Terminal term1, Terminal term2) {
        System.out.println("\nTerminals connected\n\t" + term1.toString() + "\n\t" + term2.toString() + '\n');
        if(nodes.isEmpty()) {
            nodes.add(new Node(term1,term2));
            return;
        }
        for(Node n: nodes) {
            if(n.contains(term1)) {
                n.addConnections(term2);
                return;
            } else if(n.contains(term2)) {
                n.addConnections(term1);
                return;
            }
        }
        nodes.add(new Node(term1,term2));
    }
    
    void printNodes(){
        for(Node n : nodes){
           System.out.println("Node");
            n.printTerminals();
        }
    }
}

/*
void createNodes(Terminal[] terminals) {
        for(Terminal t: terminals) {
           
        }
    }
*/