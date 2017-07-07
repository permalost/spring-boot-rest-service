
package com.norseamerican.training.springrestservice.repositories;

import com.norseamerican.training.springrestservice.models.ItemType;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ItemTypeRepository extends PagingAndSortingRepository<ItemType, Integer> 
{
	List<ItemType> findByName(@Param(value = "name") String name);
}
