package v1;

import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Random;

public class Driver {
	
	public static void main(String[] args) {

		// Build the objects needed to represent the registration process

		Catalog catalog = new Catalog();
		Term term = new Term("Fall 2016"); // change to the current term
		Faculty faculty = new Faculty();
		Student student = new Student(1, "Stein"); // change to your last name

		// Populate these objects
		createInstructors(faculty); // Send the faculty object to method for
									// instructor population
		createCourses(catalog); // Send the catalog object to method for course
								// population
		createTerm(term, catalog, faculty);

		SectionTallyGUI stGUI = new SectionTallyGUI(term, student);
	}

	private static void createInstructors(Faculty faculty) {
		faculty.addInstructor(new Instructor(101, "Johnson"));
		faculty.addInstructor(new Instructor(102, "Kay"));
		faculty.addInstructor(new Instructor(103, "Xu"));
		faculty.addInstructor(new Instructor(104, "Mulligan"));
		faculty.addInstructor(new Instructor(105, "Muldoon"));
		faculty.addInstructor(new Instructor(106, "Stanzione"));
		faculty.addInstructor(new Instructor(107, "Brady"));
		faculty.addInstructor(new Instructor(108, "Sawyer"));
		faculty.addInstructor(new Instructor(109, "Brown"));
		faculty.addInstructor(new Instructor(110, "Harrison"));
		faculty.addInstructor(new Instructor(111, "Ford"));
		faculty.addInstructor(new Instructor(112, "Danzinger"));
		faculty.addInstructor(new Instructor(113, "Clarke"));
		faculty.addInstructor(new Instructor(114, "Abraham"));
		faculty.addInstructor(new Instructor(115, "Perkowski"));
		faculty.addInstructor(new Instructor(116, "Brando"));
	}

	private static void createCourses(Catalog catalog) {
		catalog.addCourse(new Course("ART 01.101", "Art Appreciation",
				Department.Art));
		catalog.addCourse(new Course("ART 01.201", "Painting with Oils",
				Department.Art));
		catalog.addCourse(new Course("ART 01.202",
				"Painting with Water Colors", Department.Art));
		catalog.addCourse(new Course("BIOL 01.110", "Genetics",
				Department.Biology));
		catalog.addCourse(new Course("BIOL 04.301", "Anatomy and Physiology",
				Department.Biology));
		catalog.addCourse(new Course("CHEM 01.101",
				"Introduction to Chemistry", Department.Chemistry));
		catalog.addCourse(new Course("CHEM 01.201", "Organic Chemistry",
				Department.Chemistry));
		catalog.addCourse(new Course("CHEM 01.301", "Analytical Chemistry",
				Department.Chemistry));
		catalog.addCourse(new Course("CSC 04.114",
				"Object Oriented Programming", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 04.301",
				"Human Computer Interaction", Department.Computer_Science));
		catalog.addCourse(new Course("CSC 07.211", "Artificial Intelligence",
				Department.Computer_Science));
		catalog.addCourse(new Course("CSC 04.370", "Software Engineering",
				Department.Computer_Science));
		catalog.addCourse(new Course("CSC 04.210",
				"Data Structures and Algorithms", Department.Computer_Science));
		catalog.addCourse(new Course("ECON 01.101", "Microeconomics",
				Department.Economics));
		catalog.addCourse(new Course("HIS 01.101", "Western Civilization",
				Department.History));
		catalog.addCourse(new Course("HIS 01.331", "Civil Wars",
				Department.History));
		catalog.addCourse(new Course("MUS 01.214", "The Genres of Rock Music",
				Department.Music));
		catalog.addCourse(new Course("PHIL 01.111", "Ethics",
				Department.Philosophy));
		catalog.addCourse(new Course("PHIL 01.221", "Existentialism",
				Department.Philosophy));
		catalog.addCourse(new Course("PHY 02.121", "Introduction to Mechanics",
				Department.Physics));
		catalog.addCourse(new Course("PSY 04.114", "Abnormal Psychology",
				Department.Psychology));
	}

	private static void createTerm(Term term, Catalog catalog, Faculty faculty) {
		ArrayList<Timeslot> timeslots = createTimeslots();
		ArrayList<Section> sections = createSections(catalog, timeslots, faculty);
		term.addSections(sections);
	} // end createTerm
	
	public static ArrayList<Timeslot> createTimeslots(){
		ArrayList<Timeslot> timeslots = new ArrayList<Timeslot>();
		for(int i = 1; i < 6; i++){
			for (int j = 9; j < 19; j++){
				timeslots.add(new Timeslot(DayOfWeek.of(i), LocalTime.of(j, 0), LocalTime.of(j, 50)));
			}
		}
		return timeslots;
	} // end createTimeslots
	
	public static ArrayList<Section> createSections(Catalog catalog, ArrayList<Timeslot> timeslots, Faculty faculty){
		ArrayList<Course> courses = catalog.getCourses();
		ArrayList<Section> sections = new ArrayList<Section>();
		java.util.Iterator<Course> iter = courses.iterator();
		while(iter.hasNext()){
			Course course = iter.next();
			Timeslot[] tradTimeslots = {getRandomTimeslot(timeslots), getRandomTimeslot(timeslots)};
			Timeslot[] hybridTimeslots = {getRandomTimeslot(timeslots)};
			sections.add(new Traditional(course, getRandomInstructor(faculty), tradTimeslots));
			sections.add(new Hybrid(course, getRandomInstructor(faculty), hybridTimeslots));
			sections.add(new Online(course, getRandomInstructor(faculty)));
		}
		return sections;
	} // end createSections
	
	public static Timeslot getRandomTimeslot(ArrayList<Timeslot> timeslots){
		Random rand = new Random();
		int randomInteger = rand.nextInt(50);
		return timeslots.get(randomInteger);
	} // end getRandomTimeslot
	
	public static Instructor getRandomInstructor(Faculty faculty){
		Random random = new Random();
		int randomNumber = random.nextInt(15 - 0) + 0;
		Instructor randProf = faculty.getIndex(randomNumber);
		return randProf;
	} // end getRandomInstructor
}

//private static void createTerm(Term term, Catalog catalog, Faculty faculty) {
//int count = catalog.size();
//int postionInCatalog = 0;
//for (int i = 0; i < count; i++) {
//
//	// To get a random Prof in the faculty
//	Instructor randProf = new Instructor(0, null);
//	Random random = new Random();
//	int randomNumber = random.nextInt(15 - 0) + 0;
//	randProf = faculty.getIndex(randomNumber);
//
//	// get Course in the catalog
//	Course tempCourse = catalog.getIndex(postionInCatalog);
//	postionInCatalog++;
//
//	// outline for adding each course/prof to a term
//	/*
//	 * for(int c=0; c<=2; c++){ if(c==0){
//	 * 
//	 * term.addSection(new Traditional(tempCourse, randProf, null)); }
//	 * 
//	 * if(c==1){
//	 * 
//	 * term.addSection(new Hybrid(tempCourse, randProf,null)); }
//	 * 
//	 * if(c==2){ term.addSection(new Online(tempCourse, randProf)); }
//	 * 
//	 * }
//	 */
//
//}
//} // end createTerm