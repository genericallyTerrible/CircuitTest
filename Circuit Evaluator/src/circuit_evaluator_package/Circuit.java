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
            nodes.add(new Node(term1, term2));
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
        nodes.add(new Node(term1, term2));
    }
    
    void connectElementsAsReference(Terminal term1, Terminal term2) {
        System.out.println("\nTerminals connected\n\t" + term1.toString() + "\n\t" + term2.toString() + '\n');
        if(nodes.isEmpty()) {
            nodes.add(new Node(term1, term2, true));
            return;
        }
        boolean madeReferenceNode = false;
        for(Node n: nodes) {
            if(n.isGroundNode()){
                n.setAsGroundNode(false);
                System.out.println("Overwrote previous reference node with ID = " + n.getID());
            }
            if(n.contains(term1)) {
                n.addConnections(term2);
                n.setAsGroundNode(true);
                madeReferenceNode = true;
            } else if(n.contains(term2)) {
                n.addConnections(term1);
                n.setAsGroundNode(true);
                madeReferenceNode = true;
            }
        }
        if(!madeReferenceNode)
            nodes.add(new Node(term1, term2, true));
    }
    
    void printNodes(){
        System.out.println("\n--------------------------------------\n");
        for(Node n : nodes){
           System.out.println("\nNode " + n.getID());
           if(n.isGroundNode()) System.out.println("Is Reference Node");
            n.printTerminals();
        }
    }
}