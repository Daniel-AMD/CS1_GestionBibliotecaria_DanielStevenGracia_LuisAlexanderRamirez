
package library;

public abstract class LibraryItem { // Clase abstracta para otros elementos de la biblioteca.
    private String id;
    private String title;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getItemInfo();
    
}
