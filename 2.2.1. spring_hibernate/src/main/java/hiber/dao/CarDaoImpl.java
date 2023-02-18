package hiber.dao;

import hiber.model.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class CarDaoImpl implements CarDao {
    private Session session;

    public void addCar(Car car) {
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
    }

    public Car getCarById(Long id) {
        return session.get(Car.class, id);
    }

    public void update(Car car) {
        Transaction transaction = session.beginTransaction();
        session.update(car);
        transaction.commit();
    }

    public void delete(Car car) {
        Transaction transaction = session.beginTransaction();
        session.delete(car);
        transaction.commit();
    }

    public List<Car> getCarsByModel(String model) {
        Query query = session.createQuery("from Car where model = :model");
        query.setParameter("model", model);
        return query.list();
    }

    public List<Car> getCarsBySeries(int series) {
        Query query = session.createQuery("from Car where series = :series");
        query.setParameter("series", series);
        return query.list();
    }
}
