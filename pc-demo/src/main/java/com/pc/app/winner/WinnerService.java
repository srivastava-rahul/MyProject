package com.pc.app.winner;

import java.util.List;

import com.pc.app.model.winner.Winner;

public interface WinnerService {


	/**
	 * Get the list Of Winner of the day 
	 * @return List Winner of the day
	 */
	public List<Winner> listwinnerinfo();
	
	/*==================================delete the function after use it is demo purpose only===================================*/
	
	/**
	 * Add Winner of the day 
	 * @return message of success or failure
	 */
	 public String addwinner(Winner winuser ); 
}
