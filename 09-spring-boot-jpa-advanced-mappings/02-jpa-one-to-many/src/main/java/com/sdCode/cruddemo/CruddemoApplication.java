package com.sdCode.cruddemo;

import com.sdCode.cruddemo.dao.AppDAO;
import com.sdCode.cruddemo.entity.Course;
import com.sdCode.cruddemo.entity.Instructor;
import com.sdCode.cruddemo.entity.InstructorDetail;
import com.sdCode.cruddemo.entity.review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			findCoursesByInstructorByid(appDAO);
//			FindInstructorByIdJoinFetch(appDAO);
			createObjectCourseWithAssociatingReview(appDAO);

		};
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor1 = new Instructor("Saikat", "Dam", "saikatdam327@gmail.com");
		InstructorDetail instructorDetail1 = new InstructorDetail("https://www.saikat.org.in", "sdCode");

//		Instructor instructor2 = new Instructor("sourav", "roy", "souravdam333@gmail.com");
		InstructorDetail instructorDetail2 = new InstructorDetail("https://www.sourav.org.in", "srCode");

		//associate the objects
		instructor1.setInstructorDetail(instructorDetail1);
		instructor1.setInstructorDetail(instructorDetail2);

		//save the instructor
		System.out.println("Saving Instructor " + instructor1);

		System.out.println("Process Successfully Done ");
//		Course course1 = new Course("SDLoveToCode");
//		Course course2 = new Course("SdJava");
		Course course1 = new Course("LoveCode");
		Course course2 = new Course("LoveJava");
		instructor1.add(course1);
		instructor1.add(course2);

		appDAO.save(instructor1);

		System.out.println("The instructor is " + instructor1);
		System.out.println("The courses are " + instructor1.getCourses());
//		appDAO.save(instructor);
//   public void findInstructor(AppDAO appDAO){
//		int id=1;
//		appDAO.findById(id);
//		System.out.println("The id " + id + " record is successfully occupied");
//   }
//   private void findInstructorDetail(AppDAO appDAO){
//			int id = 1;
//			InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
//			System.out.println("The Instructor detail is " + instructorDetail);
//			System.out.println("The associated Instructor is " + instructorDetail.getInstructor());
//
//		}


	}
public void createObjectCourseWithAssociatingReview(AppDAO appDAO) {

	Course course1 = new Course("LoveToCode");
//	Course course2 = new Course("LoveJava");


	course1.addReview(new review("The video was outstanding"));
	course1.addReview(new review("The Worst video i have ever seen "));

    appDAO.saveData(course1);
	System.out.println("The Course1 is " + course1);
//	System.out.println("The courses are " + course1.getReviews());


}


	public void findCoursesByInstructorByid(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findById(id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		instructor.setCourses(courses);
		System.out.println("The Instructor is  " + instructor);
		System.out.println("The Courses are " + instructor.getCourses());
	}

	public void FindInstructorByIdJoinFetch(AppDAO appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("The Instructor is  " + instructor);
		System.out.println("The Courses are " + instructor.getCourses());

	}
}
