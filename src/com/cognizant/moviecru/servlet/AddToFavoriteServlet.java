package com.cognizant.moviecru.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecru.dao.FavoriteDao;
import com.cognizant.moviecru.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecru.dao.FavoriteDaoSqlImpl;
import com.cognizant.moviecru.dao.MovieDao;
import com.cognizant.moviecru.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecru.dao.MovieDaoSqlImpl;
import com.cognizant.moviecru.model.Movies;

/**
 * 
 * @author Prakash_K
 *
 */

/**
 * Servlet implementation class AddToFavoriteServlet
 */
@WebServlet("/AddToFavoriteServlet")
public class AddToFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavoriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		long userId = 1;

		System.out.println("inside do get");
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();
		FavoriteDao FavoriteDao = favoriteDaoSqlImpl;
		FavoriteDao.addFavorite(userId, movieId);

		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = movieDaoSqlImpl;
		List<Movies> movieList = movieDao.getMovieListCustomer();

		request.setAttribute("addFavoriteStatus", true);
		request.setAttribute("customerMovieList", movieList);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
