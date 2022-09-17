package com.nmsmoviebookingsystem.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nmsmoviebookingsystem.model.Genre;



@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {
	List<Genre> findByName(@Param("genreName") String genre);
	
	Genre findByNameIgnoreCase(String genre);

	/*
	 * @Query(HQL - JOIN QUERY) 
	 * List<Movie> findByDirectorName();
	 */

}
