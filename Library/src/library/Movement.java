
package library;

import java.io.Serializable;
import java.util.Date;

public class Movement implements Serializable {
    private String materialId;
    private String movementType;
    private String personId;
    private Date date;

    public Movement(String materialId, String movementType, String personId) {
        this.materialId = materialId;
        this.movementType = movementType;
        this.personId = personId;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Material ID: " + materialId + ", Movimiento: " + movementType + ", Persona ID: " + personId + ", Fecha: " + date;
    }
}
