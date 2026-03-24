
package org.example.demolistviewfile.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.example.demolistviewfile.repositories.PersonFileRepository;

public class PersonService {
    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines = this.repo.readAllLines();
        List<String> result = new ArrayList();

        for(String line : lines) {
            if (line != null && !line.isBlank()) {
                String[] parts = line.split(",");
                String name = parts[0];
                String email = parts[1];
                String edad = parts[2];
                result.add(name + "-" + email + "-" + edad);
            }
        }

        return result;
    }

    public void addPerson(String name, String email, String edad) throws IOException {
        this.repo.addNewLine(name + "," + email+","+edad);
    }

    public void updatePerson(int index, String name, String email, String edad) throws IOException {

        validate(name, email, Integer.parseInt(edad));
        List<String > listaOriginal=repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for(String line : listaOriginal){

            if(line!=null && !line.isBlank()){
                cleanLines.add(line);

            }
        }
        cleanLines.set(index, name+","+email+","+edad);
        repo.saveFile(cleanLines);

    }

    public void onDelete(int index) throws IOException {
        List<String > listaOriginal=repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for(String line : listaOriginal){

            if(line!=null && !line.isBlank()){
                cleanLines.add(line);

            }
        }
        cleanLines.remove(index);
        repo.saveFile(cleanLines);
    }



    private void validate(String name, String email, int edad) {
        if (name != null && !name.isBlank() && name.length() >= 3) {
            String em = email == null ? "" : email.trim();
            if (!em.isBlank() && em.contains("@") && em.contains(".")) {
                if (edad <= 18 || edad < 0) {
                    throw new IllegalArgumentException("la edad es incorrecto");
                }
            } else {
                throw new IllegalArgumentException("El email no es valido");
            }
        } else {
            throw new IllegalArgumentException("EL nombre es incorrecto");
        }
    }
}

