package org.example.Value;

public class value {

    public Boolean Validar(String nombre, String telefono, String parentesco) {
        if (nombre == null || nombre.isBlank()) {
            System.out.println("Error: El campo de nombre no puede estar vacío.");
            return false;
        }
        if (telefono == null || telefono.isBlank() || !telefono.matches("\\d+") || telefono.length() < 10) {
            System.out.println("Error: El número telefónico es inválido. Debe contener al menos 10 dígitos numéricos.");
            return false;
        }
        if (parentesco == null || parentesco.isBlank()) {
            System.out.println("Error: Debe seleccionar un parentesco de la lista.");
            return false;
        }
        return true;
    }
}

