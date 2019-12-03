package com.cognizant.moviecru.dao;

import java.util.List;

import com.cognizant.moviecru.model.Movies;

/**
 * 
 * @author Prakash_K
 *
 */
public class FavoriteDaoSqlImplTest {
	public static void main(String args[]) throws FavoriteEmptyException {
		testAddFavorite();
		testgetAllFavorites();
		testRemoveFavorite();
	}

	private static void testRemoveFavorite() throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		FavoriteDaoSqlImpl favouritesDaoSqlImpl = new FavoriteDaoSqlImpl();
		favouritesDaoSqlImpl.removeFavorite(1, 5);
		System.out.println("MovieItem deleted");

	}

	private static void testgetAllFavorites() throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		FavoriteDaoSqlImpl favouritesDaoSqlImpl = new FavoriteDaoSqlImpl();
		try {
			List<Movies> movieList = favouritesDaoSqlImpl.getAllFavorites(2);
			System.out.println(movieList);
		} catch (FavoriteEmptyException e) {
			e.printStackTrace();
		}

	}

	public static void testAddFavorite() throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		FavoriteDaoSqlImpl favouritesDaoSqlImpl = new FavoriteDaoSqlImpl();
		favouritesDaoSqlImpl.addFavorite(1, 1);
		System.out.println("MovieItem added to the favourites successfully");
	}

}
