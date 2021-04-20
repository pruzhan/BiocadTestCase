package ru.pruzhan.biocad;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class JSONTable {
    public static void printTable(String filename) throws IOException {
        try (InputStream input = new FileInputStream(filename)) {
            StringBuilder jsonString = new StringBuilder();
            int c;
            while ((c = input.read())!=-1) jsonString.append((char) c);
            Map<String, Object> map = new JSONObject(jsonString.toString()).toMap();
            String[] names = {"key", "value"};
            String[][] data = new String[map.size()][2];
            int i = 0;
            for (String s : map.keySet()) {
                data[i][0] = s;
                data[i++][1] = map.get(s).toString();
            }
            JFrame frame = new JFrame("Table");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTable table = new JTable(data, names);
            JScrollPane pane = new JScrollPane(table);
            frame.getContentPane().add(pane);
            frame.setPreferredSize(new Dimension(450, 200));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
}