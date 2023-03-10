package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final String HQL_SEARCH = "from User user where user.car.model =:model and user.car.series =:series";

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void addUser(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   public User findUser(String model, int series) {
      TypedQuery<User> findUser = sessionFactory.getCurrentSession().createQuery(HQL_SEARCH)
              .setParameter("model", model)
              .setParameter("series", series).setMaxResults(1);
      return findUser.getSingleResult();
   }
}
