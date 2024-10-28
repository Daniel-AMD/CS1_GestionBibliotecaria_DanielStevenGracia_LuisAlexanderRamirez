
package library;

import java.io.Serializable;


public class Material extends LibraryItem implements Loanable, Serializable {
    private String registrationDate;
    private int totalQuantity;
    private int currentQuantity;

    public Material(String id, String title, String registrationDate, int totalQuantity) {
        super(id, title);
        this.registrationDate = registrationDate;
        this.totalQuantity = totalQuantity;
        this.currentQuantity = totalQuantity;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }
    
    public void increaseQuantity(int amount) {
        currentQuantity += amount;
    }
    
    
    public void decreaseQuantity() {
        if (currentQuantity > 0) {
            currentQuantity--;
        } else {
            System.out.println("No hay unidades disponibles para prestamo.");
        }
    }

    @Override
    public void loan() {
        decreaseQuantity();
    }

    @Override
    public void returnItem() {
        increaseQuantity(1);
    }

    @Override
    public String getItemInfo() {
        return "Material ID: " + getId() + ", Título: " + getTitle() + ", Registrado en: " + registrationDate;
    }
}