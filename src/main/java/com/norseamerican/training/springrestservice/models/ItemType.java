
package com.norseamerican.training.springrestservice.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(catalog = "item", schema = "dbo", name = "ItemTypes")
public class ItemType implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int itemTypeId;
    
    private String name;

    public int getItemTypeId()
    {
        return itemTypeId;
    }

    public String getName()
    {
        return name;
    }
        
}
