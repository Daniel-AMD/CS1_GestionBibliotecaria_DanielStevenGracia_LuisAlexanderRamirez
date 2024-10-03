
package library;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Agregar personas
        Person student = new Student("123", "Alexander", "Ramirez");
        Person teacher = new Teacher("456", "Daniel", "Gracia");
        library.registerPerson(student);
        library.registerPerson(teacher);

        // Agregar materiales
        Material book = new Material("AU12468", "Construccion del Software I", "22/07/2024", 5);
        library.registerMaterial(book);

        // Prestamo de material
        library.loanMaterial("123", "AU12468");

        // Mostrar historial
        library.showHistory();
    }
}