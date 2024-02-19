package com.sdCode.cruddemo;

import com.sdCode.cruddemo.dao.AppDAO;
import com.sdCode.cruddemo.entity.Instructor;
import com.sdCode.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
//		 createInstructor(appDAO);
//			findInstructor(appDAO);
			findInstructorDetail(appDAO);
		};
	}
	private void createInstructor(AppDAO appDAO){
		Instructor instructor=new Instructor("Saikat","Dam","saikatdam327@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.saikat.org.in","sdCode");

		//associate the objects
		instructor.setInstructorDetail(instructorDetail);

		//save the instructor
		System.out.println("Saving Instructor " + instructor);
		appDAO.save(instructor);
		System.out.println("Process Successfully Done ");
	}
   public void findInstructor(AppDAO appDAO){
		int id=1;
		appDAO.findById(id);
		System.out.println("The id " + id + " record is successfully occupied");
   }
   private void findInstructorDetail(AppDAO appDAO){
		int id=1;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("The Instructor detail is " + instructorDetail);
		System.out.println("The associated Instructor is " + instructorDetail.getInstructor());
   }
}
