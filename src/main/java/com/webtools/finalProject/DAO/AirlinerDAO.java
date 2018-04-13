package com.webtools.finalProject.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.webtools.finalProject.pojo.Airliner;
import com.webtools.finalProject.pojo.Airplane;

@Repository
public class AirlinerDAO extends DAO {

//	public AirlinerDAO() throws Exception {
//		// Create airliners:
//		String[] names = { "JetBlue", "United Airline", "American Airline" };
//		for (String name : names) {
//			Airliner airliner = new Airliner(name);
//			// Create airplanes for each airliner
//			List<Airplane> fleet = airliner.getFleet();
//			String[] modelNumberList = { "Boeing 787", "Airbus a380", "Boeing 777", "Airbus b220" };
//			for (int i = 0; i < 10; i++) {
//				for (String modelNumber : modelNumberList) {
//					Airplane airplane = new Airplane(modelNumber);
//					airplane.generateSeats(airplane);
//					airplane.setAirliner(airliner);
//					fleet.add(airplane);
//				}
//			}
//			create(airliner);
//		}
//	}
//
//	public void create(Airliner airliner) throws Exception {
//		try {
//			begin();
//			getSession().save(airliner);
//			commit();
//		} catch (HibernateException e) {
//			rollback();
//			throw new Exception(e.getMessage());
//		}
//	}
}
