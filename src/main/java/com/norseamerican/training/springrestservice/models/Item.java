
package com.norseamerican.training.springrestservice.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Entity
@Table(catalog = "item", schema = "dbo", name = "items")
public class Item implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemId;
	
	@Valid
    @ManyToOne
    @JoinColumn(name="itemTypeId", nullable=false, updatable=false)
    private ItemType itemType;
	
	@Size(min=3, max=5)
	private String prefix;
	
	private String name;

	public int getItemId()
	{
		return itemId;
	}

	public String getPrefix()
	{
		return prefix;
	}

	public String getName()
	{
		return name;
	}

    public ItemType getItemType()
    {
        return itemType;
    }
	
}
