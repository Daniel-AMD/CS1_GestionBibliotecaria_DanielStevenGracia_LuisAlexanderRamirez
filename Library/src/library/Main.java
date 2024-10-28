    
package library;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        // Se agregan algunos materiales de ejemplo
        Material book1 = new Material("AU12468", "Construccion del Software I", "22/07/2024", 5);
        Material book2 = new Material("AU22469", "Data Science", "27/09/2024", 3);
        library.registerMaterial(book1);
        library.registerMaterial(book2);
        
        // Se agregan algunas personas de ejemplo
        Person student1 = new Student("C1003", "Alexander", "Ramirez");
        Person teacher1 = new Teacher("I123", "Paula", "Correa");
        library.registerPerson(student1);
        library.registerPerson(teacher1);
        
        boolean running = true;
        while (running) {

      
            System.out.println("1. Prestamo de material");
            System.out.println("2. Renovacion de Material");
            System.out.println("3. Devolucion de material");
            System.out.println("4. Registro de material");
            System.out.println("5. Registro de persona");
            System.out.println("6. Eliminar persona");
            System.out.println("7. Incrementar cantidad de material");
            System.out.println("8. Consultar historial de movimientos");
            System.out.println("9. Exit");

            try {
                System.out.println("Seleccione una opcion:");
                int option = scanner.nextInt();
                scanner.nextLine(); 
            

                switch (option) {
                    case 1:
                        System.out.print("ID de la persona: ");
                        String loanPersonId = scanner.nextLine();
                        System.out.print("Ingrese Id de material: ");
                        String loanMaterialId = scanner.nextLine();
                        library.loanMaterial(loanPersonId, loanMaterialId);
                        break;
                
                    case 2:
                        System.out.print("Ingrese ID de persona: ");
                        String renewPersonId = scanner.nextLine();
                        System.out.print("Ingrese ID de material: ");
                        String renewMaterialId = scanner.nextLine();
                        library.renewMaterial(renewPersonId, renewMaterialId);
                        break;
                        
                    case 3:
                        System.out.print("Ingrese ID de persona: ");
                        String returnPersonId = scanner.nextLine();
                        System.out.print("Ingrese ID de material: ");
                        String returnMaterialId = scanner.nextLine();
                        library.returnMaterial(returnPersonId, returnMaterialId);
                        break;
                        
                    case 4:
                        System.out.print("Ingrese ID de material: ");
                        String registerMaterialId = scanner.nextLine();
                        System.out.print("Ingrese título de material: ");
                        String registerMaterialTitle = scanner.nextLine();
                        System.out.print("Ingrese fecha de registro: ");
                        String registerDate = scanner.nextLine();
                        System.out.print("Ingrese cantidad total: ");
                        int totalQuantity = scanner.nextInt();
                        Material newMaterial = new Material(registerMaterialId, registerMaterialTitle, registerDate, totalQuantity);
                        library.registerMaterial(newMaterial);
                        System.out.println("Material registrado exitosamente.");
                        break;
                        
                    case 5:
                        System.out.print("Ingrese ID de persona: ");
                        String registerPersonId = scanner.nextLine();
                        System.out.print("Ingrese nombre de persona: ");
                        String registerPersonFirstName = scanner.nextLine();
                        System.out.print("Ingrese apellido de persona: ");
                        String registerPersonLastName = scanner.nextLine();
                        System.out.println("Seleccione tipo de persona: 1. Estudiante, 2. Docente, 3. Administrativo");
                        int personType = scanner.nextInt();
                        Person newPerson = null;
                        
                        switch (personType) {
                            case 1:
                                newPerson = new Student(registerPersonId, registerPersonFirstName, registerPersonLastName);
                                break;
                            case 2:
                                newPerson = new Teacher(registerPersonId, registerPersonFirstName, registerPersonLastName);
                                break;
                            case 3:
                                newPerson = new Administrative(registerPersonId, registerPersonFirstName, registerPersonLastName);
                                break;
                            default:
                                System.out.println("Tipo de persona no valido.");
                                continue;
                        }
                        library.registerPerson(newPerson);
                        System.out.println("Persona registrada exitosamente.");
                        break;
                        
                    case 6:
                        System.out.print("Ingrese ID de persona a eliminar: ");
                        String deletePersonId = scanner.nextLine();
                        library.deletePerson(deletePersonId);
                        break;
                        
                    case 7:
                        System.out.print("Ingrese ID de material: ");
                        String increaseMaterialId = scanner.nextLine();
                        System.out.print("Ingrese cantidad a incrementar: ");
                        int incrementAmount = scanner.nextInt();
                        library.addMaterialQuantity(increaseMaterialId, incrementAmount);
                        break;

                    case 8:
                        library.showHistory();
                        break;

                    case 9:
                        running = false;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida. Por favor, intentelo de nuevo.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }

        scanner.close();
    }
}