
package com.norseamerican.training.springrestservice.repositories;

import com.norseamerican.training.springrestservice.models.Item;
import com.norseamerican.training.springrestservice.models.ItemType;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends PagingAndSortingRepository<Item, Integer> 
{
	List<Item> findByItemType(@Param(value = "itemTypeId") ItemType itemTypeId);
	List<Item> findByItemId(@Param(value = "itemId") int itemId);
}
