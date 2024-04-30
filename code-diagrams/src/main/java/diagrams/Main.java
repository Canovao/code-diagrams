package diagrams;

import javax.swing.*;

import diagrams.diagrams.impl.Fluxogram;

public class Main {
    public static void main(String[] args) {
        String code = "package diagrams;\n" +
                "\n" +
                "public class TestClass {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello\");\n" +
                "\n" +
                "        int i = 0;\n" +
                "\n" +
                "        if(i == 2) {\n" +
                "            System.out.println(\"Nice\");\n" +
                "        } else {\n" +
                "            System.out.println(\"Great\");\n" +
                "        }\n" +
                "    }\n" +
                "}";

        for(var item : Fluxogram.getFluxogramFromCode(code)){
            System.out.println(item);
        }

        JFrame frame = new JFrame("Code Diagrams");
        JPanel panel = new JPanel();
        
        panel.setSize(300, 300);
        frame.setSize(500,300); 
        frame.add(panel);

        frame.setVisible(true);
    }
}