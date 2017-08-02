package son.duong.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import son.duong.entities.Feedback;

@Component
public class FeedbackDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public void addFeedback(Feedback feedback){
		System.out.println("in addFeedback "+ feedback );
		
		Session session = sessionFactory.getCurrentSession();
		session.save(feedback);
	}
	
	
	@Transactional
	public List<Feedback> getFeedbacks(){
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Feedback", Feedback.class);
		List<Feedback> result = q.list();
		return result;
	}
	
	@Transactional
	public List<Feedback> get2Feedbacks(){
		Session session = sessionFactory.getCurrentSession();
		NativeQuery<Feedback> query = session.createNativeQuery("select * from feedback order by rand() limit 2",Feedback.class);
		List<Feedback> result = query.list();
		return result;
	}
	

//	public void addFeedback(Feedback feedback){
//		try {
//			stmt.executeUpdate("insert into test.feedback values('"+feedback.getName()+"','"+feedback.getEmail()+"','"+feedback.getMsg()+"',"+feedback.getReg()+",'"+feedback.getCode()+"',"+feedback.getRating()+")");
//			System.out.println("Add Feedback"+ feedback);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally{
//			
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				
//			}finally{
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//		}
//	}
}
