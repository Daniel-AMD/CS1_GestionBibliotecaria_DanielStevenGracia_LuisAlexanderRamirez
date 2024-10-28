package library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable{
    private List<Person> people; // Lista de personas
    private List<Material> materials; // Lista de materiales
    private List<Movement> history; // Historial de movimientos

    public Library() {
        people = new ArrayList<>();
        materials = new ArrayList<>();
        history = new ArrayList<>();
    }

    // Registrar una nueva persona en la biblioteca
    public void registerPerson(Person person) {
        people.add(person);
    }
    
    // Permite eliminar a una persona
     public void deletePerson(String id) {
        Person person = findPersonById(id);
        if (person != null && person.getCurrentLoans() == 0) {
            people.remove(person);
            System.out.println("Persona eliminada exitosamente");
        } else {
            System.out.println("No se puede eliminar a la persona porque tiene prestamos pendientes.");
        }
    }
    
    // Registrar un nuevo material en el catralogo
     public void registerMaterial(Material material) {
        materials.add(material);
    }
     
     
     public void addMaterialQuantity(String materialId, int amount) {
        Material material = findMaterialById(materialId);
        if (material != null) {
            material.increaseQuantity(amount);
            System.out.println("Cantidad incrementada exitosamente.");
        } else {
            System.out.println("Material no encontrado.");
        }
    }

    public void loanMaterial(String personId, String materialId) {
        Person person = findPersonById(personId);
        Material material = findMaterialById(materialId);

        if (person != null && material != null) {
            if (person.canLoan() && material.getCurrentQuantity() > 0) {
                person.addLoan();
                material.decreaseQuantity();
                history.add(new Movement(materialId, "Prestamo", personId));
                System.out.println("Prestamo realizado exitosamente.");
            } else {
                System.out.println("No se puede realizar el prestamo.");
            }
        } else {
            System.out.println("Persona o material no encontrado.");
        }
    }

    public void renewMaterial(String personId, String materialId) {
        Person person = findPersonById(personId);
        if (person != null && person.canRenew()) {
            history.add(new Movement(materialId, "Renovacion", personId));
            person.renewLoan();
            System.out.println("Renovacion realizada exitosamente.");
        } else {
            System.out.println("No se puede renovar el prestamo.");
        }
    }

    public void returnMaterial(String personId, String materialId) {
        Person person = findPersonById(personId);
        Material material = findMaterialById(materialId);

        if (person != null && material != null) {
            person.returnLoan();
            material.increaseQuantity(1);
            history.add(new Movement(materialId, "Devolucion", personId));
            System.out.println("Devolucion realizada exitosamente.");
        } else {
            System.out.println("Persona o material no encontrado.");
        }
    }

    public void showHistory() {
        for (Movement movement : history) {
            System.out.println(movement);
        }
    }

    public Person findPersonById(String id) {
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    private Material findMaterialById(String id) {
        for (Material material : materials) {
            if (material.getId().equals(id)) {
                return material;
            }
        }
        return null;
    }
}

     
     
     
     
     
