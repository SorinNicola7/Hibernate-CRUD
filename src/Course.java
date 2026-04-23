import javax.persistence.*;

@Entity                            // <--- THIS WAS MISSING
@Table(name="courses")


public class Course {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private int idCourse;

	@Column(name="name")
    private String name;
	
	@Column(name="number_of_hours")
    private int number_of_hours;
	
	@Column(name="value")
	private double value;
	
	@Column(name="graduation_diploma")
    private String graduation_diploma;
	
	@Column(name="year")
	private int year;
	
	@ManyToOne
    @JoinColumn(name = "id_employee") 
    private Employee employee;
	
	public Course() {};
	
	public Course(String name, int number_of_hours, double value, String graduation_diploma, int year)
	{
		this.name = name;
		this.number_of_hours = number_of_hours;
		this.value = value;
		this.graduation_diploma = graduation_diploma;
		this.year = year;
		
	}

	public int getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber_of_hours() {
		return number_of_hours;
	}

	public void setNumber_of_hours(int number_of_hours) {
		this.number_of_hours = number_of_hours;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getGraduation_diploma() {
		return graduation_diploma;
	}

	public void setGraduation_diploma(String graduation_diploma) {
		this.graduation_diploma = graduation_diploma;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
