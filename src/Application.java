
import static com.robertkoszewski.quickquery.Query.SELECT;
import static com.robertkoszewski.quickquery.model.Compare.*;
import static com.robertkoszewski.quickquery.model.Order.*;

/**
 * Example Application
 * @author Robert Koszewski
 */
public class Application {

	public static void main(String[] args){

		// Example SELECT Queries
		System.out.println(
				SELECT("name", "password").FROM("table").WHERE("name", EQUALS, "koszewski").AND("password", EQUALS, 1234).OR("password", EQUALS, 0000));
		
		System.out.println(
				SELECT().FROM("a").WHERE("id", NOTEQUALS, 2));
		
		System.out.println(
				SELECT().FROM("table").WHERE("age", GREATERTHAN, 5));
		
		System.out.println(
				SELECT("name", "password").FROM("table").WHERE("enabled", EQUALS, true).ORDERBY("name", ASC).ORDERBY("surname", DESC));
		
		System.out.println(
				SELECT("user").FROM("table").GROUPBY("group", "subgroup").HAVING("name", EQUALS, "pepe"));
		
		// Removes Duplicate Values (See OrderBy and GroupBy)
		System.out.println(
				SELECT("name", "password").FROM("table").WHERE("enabled", EQUALS, true).GROUPBY("group", "subgroup", "group").ORDERBY("name", ASC).ORDERBY("name", DESC));

	}

	// Stuff to be implemented: 
	// - SELECT * FROM Customers WHERE Country='Germany' AND (City='Berlin' OR City='München');
	// - Inner/Outer/Left/Right Joins
}
