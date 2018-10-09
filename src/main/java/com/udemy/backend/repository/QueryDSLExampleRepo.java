
/**
 * Se necesitan declarar las Clases Q que se han generado 
 * previamente por cada Modelo que encuentre QueryDSL
 * 
 * 
 * hay que agregar el QCourse por terminal ejecutando: # mvn eclipse:eclipse
 * hara que los recursos auto generados los meta en los recursos de la aplicacion y que no sea
 * externos
 * 
 */
package com.udemy.backend.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backend.entity.Course;
import com.udemy.backend.entity.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

	private QCourse qCourse = QCourse.course;

	@PersistenceContext
	private EntityManager em;

	public Course find(boolean exist) {

		/*
		 * Siempre que queramos usar DSL debemos usar JPAQuery em entity manager se
		 * ocupara para sacar las entidades de la persistencia , los campos
		 */
		JPAQuery<Course> query = new JPAQuery<Course>(em);

		
		BooleanBuilder predicateBuilder = new BooleanBuilder (qCourse.description.endsWith("OP") );
		
		//el obj qe adminte el where es un predicate 
		
		//qCourse.description.endsWith("OP");

		if (exist) {
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}

		return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
		 
		/* trae todas las columnas */
		//Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		
		/* trae solo name y description */
		/*Course course2 = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(qCourse.id.eq(23))			
				.fetchOne();
		*/
		/** trae las solumnas con un filtro between */
		/*List<Course> course = query.select(qCourse).from(qCourse.hours.between(20, 50)).fetch();*/

		// query.select(qCourse).from(qCourse).where(qCourse.id.eq(23));
	}

}
