package com.nmsmoviebookingsystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nmsmoviebookingsystem.model.Movie;
import com.nmsmoviebookingsystem.model.Seats;
import com.nmsmoviebookingsystem.model.Show;
import com.nmsmoviebookingsystem.repository.MovieRepository;
import com.nmsmoviebookingsystem.repository.SeatRepository;
import com.nmsmoviebookingsystem.repository.ShowRepository;





@Service
public class ShowService {

	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	SeatRepository seatRepository;
	
	public void saveShow(Show show) {
		
		
		
		    Movie movie=show.getMovie();
			
			Movie movies= movieRepository.findByMovienameIgnoreCase(movie.getMoviename());
			
			show.setMovie(movies); 
		
		
		showRepository.save(show);
	}
	
	public List<Show> listShow() {
		List<Show> shows = new ArrayList<Show>();
		showRepository.findAll().forEach(show -> shows.add(show));
		return shows;
	}
	
    public List<Show> getShowsByMovie(String name){
 			
		return showRepository.findByMovieAndSort(name,Sort.by(Sort.Direction.ASC,"showname"));
		
		}
	
	public Optional<Show> getShow(int id) { 
		return showRepository.findById(id);
	}
	
	public void deleteShow(int id) {
		
		
		showRepository.deleteById(id);
		
	}
	
	public Show updateShow(int id) {
		
		return showRepository.findById(id).get();
				
	}
	
	public List<Seats> getSeats(){	
		
	    List<Seats> seats = new ArrayList<Seats>();
		//movieRepository.findAll().forEach(movie -> movies.add(movie));
		//return movies;
	     seatRepository.findAll().forEach(seat -> seats.add(seat));
		return seats;
	}
	
	public List<Seats> getSeatsByShowId(int id){	
		
	   	    List<Seats> seats =seatRepository.findSeatByShowId(id);
		return seats;
	}
	

	
	public Seats saveSeats(Seats seat) {
		
		return seatRepository.save(seat);
	}
	
	
}
