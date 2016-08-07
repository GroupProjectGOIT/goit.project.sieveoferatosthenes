package com.goit.project.sieveoferatosthenes;


import java.io.*;

public class FileEditor {
    private static File file;
    private String nameForTextFile;

    @Override
    public String toString() {
        return "Enter name(only letters) for your file where I record the result : ";
    }

    public void setNameForTextFile(String name) throws WrongNameFileException {
        for (char letter : name.toCharArray()) {
            if (!Character.isLetter(letter)) {
                throw new WrongNameFileException("You must enter only letters for name!Try again");
            }
        }
        name += ".txt";
        this.nameForTextFile = name;
    }

    public void writeTextFile(String[] text) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            file = new File(nameForTextFile);
            if (file.createNewFile()) System.out.println("File created successfully!");

            bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            for (String s : text) {
                bufferedWriter.write(s + "\n");
            }
            bufferedWriter.close();
            System.out.println("\nYou file was written successful!\nPath for your file: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) bufferedWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void readFile() {
        BufferedReader bufferedReader = null;
        try {
            String textLine;
            bufferedReader = new BufferedReader(new FileReader(file));
            while ((textLine = bufferedReader.readLine()) != null) {
                System.out.println(textLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}


