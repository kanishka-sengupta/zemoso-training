package design_patterns.structural_patterns;


import java.util.ArrayList;

interface IEmployee{
    void showEmployeeDetails();
}

class Developer implements IEmployee{
    private String name,position;
    private long empID;

    public Developer(String name,long empID,String position){
        this.name=name;
        this.position=position;
        this.empID=empID;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(
                "Developer{" +
                        "name='" + name + '\'' +
                        ", position='" + position + '\'' +
                        ", empID=" + empID +
                        '}'
        );
    }
}
class HR implements IEmployee{
    private String name,position;
    private long empID;

    public HR(String name,long empID,String position){
        this.name=name;
        this.position=position;
        this.empID=empID;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(
                "HR{" +
                        "name='" + name + '\'' +
                        ", position='" + position + '\'' +
                        ", empID=" + empID +
                        '}'
        );
    }
}

class CompanyDirectory implements IEmployee{
    private ArrayList<IEmployee> employees=new ArrayList<IEmployee>();

    @Override
    public void showEmployeeDetails() {
        for (IEmployee e:
             employees) {
            e.showEmployeeDetails();
        }
    }

    public void addEmployee(IEmployee employee){
        employees.add(employee);
    }

    public void removeEmployee(IEmployee employee){
        employees.remove(employee);
    }
}
public class CompositePattern {
    public static void main(String[] args) {
        CompanyDirectory engDirectory=new CompanyDirectory();
        CompanyDirectory hrDirectory=new CompanyDirectory();
        CompanyDirectory companyDirectory=new CompanyDirectory();

        engDirectory.addEmployee(
                new Developer(
                    "Random",101,"Junior Dev"
                )
        );

        engDirectory.addEmployee(
                new Developer(
                        "Moses",102,"Senior Dev"
                )
        );

        hrDirectory.addEmployee(
                new HR(
                        "Ele",201,"HR"
                )
        );

        hrDirectory.addEmployee(
                new HR(
                        "Rani",202,"HR HEAD"
                )
        );

        companyDirectory.addEmployee(engDirectory);
        companyDirectory.addEmployee(hrDirectory);

        companyDirectory.showEmployeeDetails();

    }
}
