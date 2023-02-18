package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Volga", 21);
      User user1 = new User("User1","Lastname1", "user1@mail.ru", car1);
      userService.addUser(user1);

      Car car2 = new Car("Vaz", 2106);
      User user2 = new User("User2","Lastname2", "user2@mail.ru", car2);
      userService.addUser(user2);

      Car car3 = new Car("Gaz", 21);
      User user3 = new User("User3","Lastname3", "user3@mail.ru", car3);
      userService.addUser(user3);

      Car car4 = new Car("Vaz", 2109);
      User user4 = new User("User4","Lastname4", "user4@mail.ru", car4);
      userService.addUser(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      System.out.println(userService.findUser("Gaz", 21).toString());
      context.close();
   }
}

