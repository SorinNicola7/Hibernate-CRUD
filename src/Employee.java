import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="firm")
    private String firm;
    
    @Column(name="position")
    private String position;
    
    @Column(name="date_of_employment")
    @Temporal(TemporalType.DATE)
    private Date date_of_employment;
    
    @OneToMany(mappedBy="employee", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Course> courses = new ArrayList<>();
    
    public Employee() {}
    
    public Employee(String name, String firm, String position, Date date_of_employment) {
        this.name = name;
        this.firm = firm;
        this.position = position;
        this.date_of_employment = date_of_employment;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFirm() { return firm; }
    public void setFirm(String firm) { this.firm = firm; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public Date getDate_of_employment() { return date_of_employment; }
    public void setDate_of_employment(Date date_of_employment) { this.date_of_employment = date_of_employment; }
    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}