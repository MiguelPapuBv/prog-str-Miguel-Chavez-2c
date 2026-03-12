package org.example.demolistviewfile.services;

import org.example.demolistviewfile.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();
        for(String line : lines){
            if(line == null || line.isBlank()) continue;

            String[] parts = line.split(",");

            if (parts.length >= 3) {
                String name = parts[0];
                String email = parts[1];
                String edad = parts[2];
                result.add(name + " - " + email +    edad +  "años");
            }
        }
        return result;
    }

    public void addPerson(String name, String email, String edadStr) throws IOException {
        validate(name, email, edadStr);
        repo.addNewLine(name.trim() + "," + email.trim() + "," + edadStr.trim());
    }

    private void validate(String name, String email, String edadStr) {
        if(name == null || name.isBlank() || name.length() < 3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }

        String em = (email == null) ? ""  : email.trim();
        if(em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email no es valido");
        }

        if (edadStr == null || edadStr.isBlank()) {
            throw new IllegalArgumentException("La edad no puede estar vacía");
        }

        try {
            int edad = Integer.parseInt(edadStr.trim());

            if (edad < 0) {
                throw new IllegalArgumentException("La edad no puede ser negativa");
            }
            if (edad < 18) {
                throw new IllegalArgumentException("Debe ser mayor de edad (18+)");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La edad debe ser un número válido");
        }
    }
}