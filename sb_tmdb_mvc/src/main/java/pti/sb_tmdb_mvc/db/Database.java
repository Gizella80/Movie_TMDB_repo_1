package pti.sb_tmdb_mvc.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;


import pti.sb_tmdb_mvc.model.User;


@Repository
public class Database {
	
	private SessionFactory sessionFactory;
	
	public Database(){
		
		Configuration config = new Configuration();
		config.configure();
		
		sessionFactory = config.buildSessionFactory();
	}

	public User getUserById(int userId) {
		User user = null;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		//USER 
		user = session.get(User.class, userId);
		

		//MovieIds 
		if(user != null) {
			
			
			NativeQuery<Object[]> query = 
					session.createNativeQuery("SELECT * FROM seenmovies WHERE userid = ?1", Object[].class);
			query.setParameter(1, userId);
			List<Object[]> rows = query.getResultList();
			
			for(int index = 0; index < rows.size(); index++) {
				
				Object[] currentRow = rows.get(index);
				int movieId = Integer.parseInt( currentRow[2].toString() );
				
				user.addMovieId(movieId);
			
			}
		}

		
		tx.commit();
		session.close();
		
		return user;
	
	}

	public void mergeSeenMovies(int userId, int movieId) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		NativeQuery query =
				session.createNativeQuery("INSERT INTO seenmovies (userid , tmdbmovieid)  VALUES (?1,?2)",Object[].class);
				query.setParameter(1, userId);
				query.setParameter(2, movieId);
				query.executeUpdate();
		
		tx.commit();
		session.close();
		
		
	}

	
}
