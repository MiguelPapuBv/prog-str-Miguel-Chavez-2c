package org.example.demolistviewfile.services;

import org.example.demolistviewfile.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result= new ArrayList<>();
        for(String line : lines){
            if(line==null || line.isBlank()) continue;

            String[] parts= line.split(",");
            String name=parts[0];
            String email=parts[1];
            result.add(name+"-"+email);
        }
        return result;
    }

    public void addPerson(String name, String email) throws IOException {
        repo.addNewLine(name+","+email);
    }
    private void validate(String name, String email){
        if(name==null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("EL nombre es incorrecto");
        }
        String em = (email==null) ? ""  : email.trim();
        if(em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email no es valido");
        }
    }
}
