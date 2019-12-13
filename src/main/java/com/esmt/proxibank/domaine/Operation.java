
package com.esmt.proxibank.domaine;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author TOSHIBA
 */
@Entity
public class Operation implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    private long montant;
    private String dates;
    
    @ManyToOne()
    private Client client;

    public Operation() {
    }
    
    public Operation(String type, long montant, String date, Client client) {
        this.type = type;
        this.montant = montant;
        this.dates = date;
        this.client = client;
    }
    

    public Operation(long id, String type, long montant, String dates, Client client) {
        this.id = id;
        this.type = type;
        this.montant = montant;
        this.dates = dates;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public long getMontant() {
        return montant;
    }

    public String getDate() {
        return dates;
    }

    public Client getClient() {
        return client;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMontant(long montant) {
        this.montant = montant;
    }

    public void setDate(String dates) {
        this.dates = dates;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
