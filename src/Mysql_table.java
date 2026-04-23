import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query; 

public class Mysql_table extends JFrame {

    private JPanel contentPane;
    
    // Campuri GUI Angajat
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtFirm;
    private JTextField txtPosition;
    private JTextField txtDate;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mysql_table frame = new Mysql_table();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Mysql_table() {
        setTitle("Project Hibernate - Final Stable");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 850, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        sdf.setLenient(false);

        // --- BUTTONS PANEL ---
        JPanel topPanel = new JPanel(new BorderLayout());
        contentPane.add(topPanel, BorderLayout.NORTH);

        JToolBar toolBar1 = new JToolBar();
        toolBar1.setFloatable(false);
        JButton btnAdd = new JButton("➕ Add");
        JButton btnUpdate = new JButton("📝 Update"); 
        JButton btnDelete = new JButton("❌ Delete");
        JButton btnSearch = new JButton("🔍 Search ID");
        JButton btnCourses = new JButton("📚 Courses Menu");
        
        toolBar1.add(btnAdd);
        toolBar1.add(btnUpdate);
        toolBar1.add(btnDelete);
        toolBar1.add(btnSearch);
        toolBar1.add(new JToolBar.Separator());
        toolBar1.add(btnCourses);
        
        JToolBar toolBar2 = new JToolBar();
        toolBar2.setFloatable(false);
        
        JButton btnShowAll = new JButton("👥 Show All");
        JButton btnEmpFirm = new JButton("🏢 By Firm"); 
        JButton btnExperience = new JButton("🕒 Experience > X"); 
        JButton btnEmpByCourse = new JButton("🎓 By Course"); 
        JButton btnEditCourse = new JButton("📘 Search/Edit Course"); 

        toolBar2.add(btnShowAll); 
        toolBar2.add(new JToolBar.Separator());
        toolBar2.add(btnEmpFirm);
        toolBar2.add(btnExperience);
        toolBar2.add(btnEmpByCourse);
        toolBar2.add(btnEditCourse);

        topPanel.add(toolBar1, BorderLayout.NORTH);
        topPanel.add(toolBar2, BorderLayout.SOUTH);
        
        // --- MAIN FORM ---
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWidths = new int[]{100, 200}; 
        gbl.rowHeights = new int[]{30, 30, 30, 30, 30}; 
        gbl.columnWeights = new double[]{0.0, 1.0}; 
        gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
        panel.setLayout(gbl);
        
        // --- ROWS ---
        JLabel lblId = new JLabel("ID:");
        GridBagConstraints gbc_lblId = new GridBagConstraints();
        gbc_lblId.anchor = GridBagConstraints.EAST;
        gbc_lblId.insets = new Insets(5, 5, 5, 5);
        gbc_lblId.gridx = 0; gbc_lblId.gridy = 0;
        panel.add(lblId, gbc_lblId);

        txtId = new JTextField();
        GridBagConstraints gbc_txtId = new GridBagConstraints();
        gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtId.insets = new Insets(5, 0, 5, 5);
        gbc_txtId.gridx = 1; gbc_txtId.gridy = 0;
        panel.add(txtId, gbc_txtId);
        txtId.setColumns(10);

        JLabel lblName = new JLabel("Name:");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.EAST;
        gbc_lblName.insets = new Insets(5, 5, 5, 5);
        gbc_lblName.gridx = 0; gbc_lblName.gridy = 1;
        panel.add(lblName, gbc_lblName);

        txtName = new JTextField();
        GridBagConstraints gbc_txtName = new GridBagConstraints();
        gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtName.insets = new Insets(5, 0, 5, 5);
        gbc_txtName.gridx = 1; gbc_txtName.gridy = 1;
        panel.add(txtName, gbc_txtName);

        JLabel lblFirm = new JLabel("Firm:");
        GridBagConstraints gbc_lblFirm = new GridBagConstraints();
        gbc_lblFirm.anchor = GridBagConstraints.EAST;
        gbc_lblFirm.insets = new Insets(5, 5, 5, 5);
        gbc_lblFirm.gridx = 0; gbc_lblFirm.gridy = 2;
        panel.add(lblFirm, gbc_lblFirm);

        txtFirm = new JTextField();
        GridBagConstraints gbc_txtFirm = new GridBagConstraints();
        gbc_txtFirm.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtFirm.insets = new Insets(5, 0, 5, 5);
        gbc_txtFirm.gridx = 1; gbc_txtFirm.gridy = 2;
        panel.add(txtFirm, gbc_txtFirm);

        JLabel lblPos = new JLabel("Position:");
        GridBagConstraints gbc_lblPos = new GridBagConstraints();
        gbc_lblPos.anchor = GridBagConstraints.EAST;
        gbc_lblPos.insets = new Insets(5, 5, 5, 5);
        gbc_lblPos.gridx = 0; gbc_lblPos.gridy = 3;
        panel.add(lblPos, gbc_lblPos);

        txtPosition = new JTextField();
        GridBagConstraints gbc_txtPosition = new GridBagConstraints();
        gbc_txtPosition.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPosition.insets = new Insets(5, 0, 5, 5);
        gbc_txtPosition.gridx = 1; gbc_txtPosition.gridy = 3;
        panel.add(txtPosition, gbc_txtPosition);

        JLabel lblDate = new JLabel("Date (yyyy.MM.dd):");
        GridBagConstraints gbc_lblDate = new GridBagConstraints();
        gbc_lblDate.anchor = GridBagConstraints.EAST;
        gbc_lblDate.insets = new Insets(5, 5, 5, 5);
        gbc_lblDate.gridx = 0; gbc_lblDate.gridy = 4;
        panel.add(lblDate, gbc_lblDate);

        txtDate = new JTextField();
        GridBagConstraints gbc_txtDate = new GridBagConstraints();
        gbc_txtDate.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtDate.insets = new Insets(5, 0, 5, 5);
        gbc_txtDate.gridx = 1; gbc_txtDate.gridy = 4;
        panel.add(txtDate, gbc_txtDate);

        // ================= ACTIONS =================

        // 0. SHOW ALL EMPLOYEES
        btnShowAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    // FIX: Curatam cache-ul pentru a vedea datele proaspete
                    session.clear();
                    
                    Query q = session.createQuery("FROM Employee");
                    List<Employee> list = (List<Employee>) q.list();
                    
                    if(list.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Database is empty.");
                        return;
                    }

                    StringBuilder sb = new StringBuilder();
                    for(Employee emp : list) {
                        sb.append("ID: ").append(emp.getId())
                          .append(" | Name: ").append(emp.getName())
                          .append(" | Firm: ").append(emp.getFirm())
                          .append(" | Pos: ").append(emp.getPosition())
                          .append(" | Date: ").append(sdf.format(emp.getDate_of_employment()))
                          .append("\n--------------------------------------------------\n");
                    }

                    JTextArea textArea = new JTextArea(sb.toString());
                    textArea.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setPreferredSize(new Dimension(500, 400));
                    
                    JOptionPane.showMessageDialog(null, scrollPane, "All Employees List", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) { ex.printStackTrace(); } finally { session.close(); }
            }
        });

        // 1. ADD EMPLOYEE
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dateStr = txtDate.getText();
                if(!dateStr.matches("\\d{4}\\.\\d{2}\\.\\d{2}")) {
                    JOptionPane.showMessageDialog(null, "Error Date! Correct format: xxxx.xx.xx");
                    return;
                }
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = null;
                try {
                    tx = session.beginTransaction();
                    Employee emp = new Employee(txtName.getText(), txtFirm.getText(), txtPosition.getText(), sdf.parse(dateStr));
                    session.save(emp);
                    tx.commit();
                    txtId.setText(String.valueOf(emp.getId()));
                    JOptionPane.showMessageDialog(null, "Employee Saved!");
                } catch (Exception ex) {
                    if(tx!=null) tx.rollback();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                } finally { session.close(); }
            }
        });

        // 2. SEARCH EMPLOYEE
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    session.clear(); // FIX: Clear cache
                    int id = Integer.parseInt(txtId.getText());
                    Employee emp = (Employee) session.get(Employee.class, id);
                    if(emp != null) {
                        txtName.setText(emp.getName());
                        txtFirm.setText(emp.getFirm());
                        txtPosition.setText(emp.getPosition());
                        txtDate.setText(sdf.format(emp.getDate_of_employment()));
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee not found.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID");
                } finally { session.close(); }
            }
        });

        // 3. UPDATE EMPLOYEE
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dateStr = txtDate.getText();
                if(!dateStr.matches("\\d{4}\\.\\d{2}\\.\\d{2}")) {
                    JOptionPane.showMessageDialog(null, "Error Date! Correct format: 2024.10.12");
                    return;
                }
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = null;
                try {
                    tx = session.beginTransaction();
                    int id = Integer.parseInt(txtId.getText());
                    Employee emp = (Employee) session.get(Employee.class, id);
                    if(emp != null) {
                        emp.setName(txtName.getText());
                        emp.setFirm(txtFirm.getText());
                        emp.setPosition(txtPosition.getText());
                        emp.setDate_of_employment(sdf.parse(dateStr));
                        session.update(emp);
                        tx.commit();
                        JOptionPane.showMessageDialog(null, "Employee Updated!");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID not found.");
                    }
                } catch (Exception ex) {
                    if(tx!=null) tx.rollback();
                    JOptionPane.showMessageDialog(null, "Error updating.");
                } finally { session.close(); }
            }
        });

        // 4. DELETE EMPLOYEE
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = null;
                try {
                    tx = session.beginTransaction();
                    int id = Integer.parseInt(txtId.getText());
                    Employee emp = (Employee) session.get(Employee.class, id);
                    if(emp != null) {
                        session.delete(emp);
                        tx.commit(); // FARA RESETARE ID PT A EVITA BLOCAJUL
                        JOptionPane.showMessageDialog(null, "Deleted!");
                        txtName.setText(""); txtFirm.setText(""); txtPosition.setText(""); txtDate.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Employee not found.");
                    }
                } catch(Exception ex) { 
                    if(tx!=null) tx.rollback(); 
                    JOptionPane.showMessageDialog(null, "Error deleting.");
                } finally { session.close(); }
            }
        });

        // 5. OPEN COURSES MENU
        btnCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idS = txtId.getText();
                if(idS.isEmpty()) { JOptionPane.showMessageDialog(null, "Enter Employee ID first!"); return; }
                Session s = HibernateUtil.getSessionFactory().openSession();
                try {
                    s.clear(); // FIX: Clear cache
                    Employee eObj = (Employee) s.get(Employee.class, Integer.parseInt(idS));
                    if(eObj!=null) openCoursesWindow(eObj);
                    else JOptionPane.showMessageDialog(null, "Employee not found");
                } catch(Exception ex) { ex.printStackTrace(); } finally { s.close(); }
            }
        });

        // 6. FILTER: BY FIRM
        btnEmpFirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firm = JOptionPane.showInputDialog("Enter firm name:");
                if(firm == null || firm.trim().isEmpty()) return;

                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    session.clear(); // FIX: Clear cache
                    Query q = session.createQuery("FROM Employee WHERE firm = :f");
                    q.setParameter("f", firm);
                    List<Employee> list = (List<Employee>) q.list();
                    
                    StringBuilder sb = new StringBuilder();
                    for(Employee emp : list) {
                        sb.append(emp.getName()).append(" (").append(emp.getPosition()).append(")\n");
                    }
                    if(list.isEmpty()) JOptionPane.showMessageDialog(null, "No employees found.");
                    else JOptionPane.showMessageDialog(null, sb.toString());
                } catch (Exception ex) { ex.printStackTrace(); } finally { session.close(); }
            }
        });

        // 7. FILTER: EXPERIENCE
        btnExperience.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = JOptionPane.showInputDialog("Years of experience > X:");
                if(s==null) return;
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    session.clear(); // FIX: Clear cache - CITESTE DIRECT DIN BAZA DE DATE
                    
                    int ani = Integer.parseInt(s);
                    java.util.Calendar cal = java.util.Calendar.getInstance();
                    cal.add(java.util.Calendar.YEAR, -ani);
                    
                    Query q = session.createQuery("FROM Employee WHERE date_of_employment < :d");
                    q.setParameter("d", cal.getTime());
                    List<Employee> l = (List<Employee>) q.list();
                    StringBuilder sb = new StringBuilder();
                    for(Employee emp : l) sb.append(emp.getName()).append(" - ").append(sdf.format(emp.getDate_of_employment())).append("\n");
                    
                    JOptionPane.showMessageDialog(null, sb.length()==0 ? "Nobody found" : sb.toString());
                } catch(Exception ex) { ex.printStackTrace(); } finally { session.close(); }
            }
        });

        // 8. FILTER: BY COURSE 
        btnEmpByCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String courseName = JOptionPane.showInputDialog("Enter course name:");
                if(courseName == null || courseName.trim().isEmpty()) return;
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    session.clear(); // FIX: Clear cache
                    
                    String hql = "SELECT distinct e FROM Employee e JOIN e.courses c WHERE c.name = :cn";
                    Query q = session.createQuery(hql);
                    q.setParameter("cn", courseName);
                    
                    List<Employee> list = (List<Employee>) q.list();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Employees who took '").append(courseName).append("':\n");
                    for(Employee emp : list) {
                        sb.append("- ").append(emp.getName()).append(" (ID: ").append(emp.getId()).append(")\n");
                    }
                    JOptionPane.showMessageDialog(null, list.isEmpty() ? "No one." : sb.toString());
                } catch (Exception ex) { 
                    ex.printStackTrace(); 
                    JOptionPane.showMessageDialog(null, "Error searching: " + ex.getMessage());
                } finally { session.close(); }
            }
        });

        // 9. SEARCH/EDIT COURSE
        btnEditCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String courseName = JOptionPane.showInputDialog("Enter exact course name to search:");
                if(courseName == null || courseName.trim().isEmpty()) return;
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                    session.clear(); 
                    Query q = session.createQuery("FROM Course WHERE name = :n");
                    q.setParameter("n", courseName);
                    q.setMaxResults(1); 
                    List<Course> list = (List<Course>) q.list();
                    if(list.isEmpty()) JOptionPane.showMessageDialog(null, "Course not found!");
                    else openEditCourseWindow(list.get(0));
                } catch (Exception ex) { ex.printStackTrace(); } finally { session.close(); }
            }
        });
    }

    // --- SUB-WINDOW: Manage Courses for Employee ---
    private void openCoursesWindow(final Employee selectedEmployee) {
        JFrame frame = new JFrame("Courses for: " + selectedEmployee.getName());
        frame.setSize(400, 550); 
        frame.setLayout(null);

        final JTextArea listArea = new JTextArea();
        listArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listArea);
        scrollPane.setBounds(10, 10, 360, 150);
        frame.add(scrollPane);

        JLabel l1 = new JLabel("Name:"); l1.setBounds(10, 170, 50, 20); frame.add(l1);
        final JTextField tName = new JTextField(); tName.setBounds(60, 170, 120, 20); frame.add(tName);
        
        JLabel l2 = new JLabel("Hours:"); l2.setBounds(200, 170, 40, 20); frame.add(l2);
        final JTextField tHours = new JTextField(); tHours.setBounds(240, 170, 50, 20); frame.add(tHours);

        JLabel l3 = new JLabel("Value:"); l3.setBounds(10, 200, 50, 20); frame.add(l3);
        final JTextField tVal = new JTextField(); tVal.setBounds(60, 200, 50, 20); frame.add(tVal);
        
        JLabel l4 = new JLabel("Year:"); l4.setBounds(150, 200, 40, 20); frame.add(l4);
        final JTextField tYear = new JTextField(); tYear.setBounds(190, 200, 50, 20); frame.add(tYear);

        JLabel l5 = new JLabel("Diploma (y/n):"); l5.setBounds(10, 230, 100, 20); frame.add(l5);
        final JTextField tDiploma = new JTextField(); tDiploma.setBounds(110, 230, 50, 20); frame.add(tDiploma);

        JButton btnAdd = new JButton("Add Course");
        btnAdd.setBounds(10, 270, 150, 30);
        frame.add(btnAdd);

        JLabel lDel = new JLabel("Delete ID:"); lDel.setBounds(10, 330, 70, 20); frame.add(lDel);
        final JTextField tDel = new JTextField(); tDel.setBounds(80, 330, 40, 20); frame.add(tDel);
        JButton btnDel = new JButton("Delete"); btnDel.setBounds(130, 330, 80, 20); frame.add(btnDel);

        refreshList(listArea, selectedEmployee.getId());

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Session s = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = null;
                try {
                    tx = s.beginTransaction();
                    Employee emp = (Employee) s.get(Employee.class, selectedEmployee.getId());
                    
                    Course c = new Course();
                    c.setName(tName.getText());
                    try { c.setNumber_of_hours(Integer.parseInt(tHours.getText())); } catch(Exception ex) { c.setNumber_of_hours(0); }
                    try { c.setValue(Double.parseDouble(tVal.getText())); } catch(Exception ex) { c.setValue(0.0); }
                    try { c.setYear(Integer.parseInt(tYear.getText())); } catch(Exception ex) { c.setYear(2024); }
                    c.setGraduation_diploma(tDiploma.getText()); 
                    
                    c.setEmployee(emp);
                    s.save(c);
                    tx.commit();
                    
                    refreshList(listArea, selectedEmployee.getId());
                    JOptionPane.showMessageDialog(null, "Course Added!");
                    
                } catch(Exception ex) { 
                    if(tx!=null) tx.rollback(); 
                    JOptionPane.showMessageDialog(null, "Error adding course.");
                } finally { s.close(); }
            }
        });

        btnDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Session s = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = null;
                try {
                    tx = s.beginTransaction();
                    Query q = s.createQuery("DELETE FROM Course WHERE idCourse = :id");
                    q.setParameter("id", Integer.parseInt(tDel.getText().trim()));
                    int res = q.executeUpdate();
                    tx.commit(); // FARA RESETARE ID
                    
                    if(res > 0) {
                        refreshList(listArea, selectedEmployee.getId());
                        tDel.setText("");
                        JOptionPane.showMessageDialog(null, "Course deleted!");
                    } else JOptionPane.showMessageDialog(null, "Invalid ID");
                } catch(Exception ex) { if(tx!=null) tx.rollback(); } finally { s.close(); }
            }
        });

        frame.setVisible(true);
    }
    
    // --- SUB-WINDOW: Edit Course ---
    private void openEditCourseWindow(final Course c) {
        final JFrame f = new JFrame("Edit Course: " + c.getName());
        f.setSize(350, 400); 
        f.setLayout(new GridLayout(7, 2, 10, 10)); 

        final JTextField tfName = new JTextField(c.getName());
        final JTextField tfHours = new JTextField(String.valueOf(c.getNumber_of_hours()));
        final JTextField tfValue = new JTextField(String.valueOf(c.getValue()));
        final JTextField tfYear = new JTextField(String.valueOf(c.getYear()));
        final JTextField tfDiploma = new JTextField(c.getGraduation_diploma());

        f.add(new JLabel("  Name:"));   f.add(tfName);
        f.add(new JLabel("  Hours:"));  f.add(tfHours);
        f.add(new JLabel("  Value:"));  f.add(tfValue);
        f.add(new JLabel("  Year:"));   f.add(tfYear);
        f.add(new JLabel("  Diploma:"));f.add(tfDiploma);

        JButton btnSave = new JButton("Save Changes");
        f.add(new JLabel("")); 
        f.add(btnSave);
        
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Session s = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = null;
                try {
                    tx = s.beginTransaction();
                    Course courseToUpdate = (Course) s.get(Course.class, c.getIdCourse());
                    courseToUpdate.setName(tfName.getText());
                    try { courseToUpdate.setNumber_of_hours(Integer.parseInt(tfHours.getText())); } catch(Exception ex) {}
                    try { courseToUpdate.setValue(Double.parseDouble(tfValue.getText())); } catch(Exception ex) {}
                    try { courseToUpdate.setYear(Integer.parseInt(tfYear.getText())); } catch(Exception ex) {}
                    courseToUpdate.setGraduation_diploma(tfDiploma.getText());

                    s.update(courseToUpdate);
                    tx.commit();
                    JOptionPane.showMessageDialog(null, "Course Updated!");
                    f.dispose();
                } catch(Exception ex) { 
                    if(tx!=null) tx.rollback(); 
                    JOptionPane.showMessageDialog(null, "Error updating course.");
                } finally { s.close(); }
            }
        });
        f.setVisible(true);
    }

    // FIX: Refresh prin reconstruire text + clear cache
    private void refreshList(JTextArea area, int empId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.clear(); // Clear cache pt date proaspete
            Query q = s.createQuery("FROM Course WHERE employee.id = :id");
            q.setParameter("id", empId);
            List<Course> l = (List<Course>) q.list();
            
            StringBuilder sb = new StringBuilder();
            for(Course c : l) {
                sb.append("[ID:" + c.getIdCourse() + "] " + c.getName() + 
                            " | " + c.getNumber_of_hours() + "h | Value:" + c.getValue() + 
                            " | " + c.getGraduation_diploma() + "\n");
            }
            area.setText(sb.toString());
            area.repaint();

            
        } finally { s.close(); }
    }
}