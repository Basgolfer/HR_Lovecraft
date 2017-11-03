package hrlovecraft.menus;

import hrlovecraft.*;

public class EmployeeUpdate extends Menu {

    private static final EmployeeUpdate INSTANCE = new EmployeeUpdate();



    public enum UpdateSelections {NAME, ADDRESS, PHONE, EMAIL, DEPARTMENT, POSITION, SALARY, BENEFITS, BACK, MAIN}

    private EmployeeUpdate() {
        super(UpdateSelections.values(),"");
    }

    @Override
    public void userSelect(String userInput) {
        switch (UpdateSelections.valueOf(userInput)){
            case NAME: updateName();
            break;
            case ADDRESS:// updateAddress();
            break;
            case PHONE: updatePhone();
            break;
            case EMAIL:updateEmail();
            break;
            case DEPARTMENT:updateDepartment();
            break;
            case POSITION:updatePosition();
            break;
            case SALARY: updateSalary();
            break;
            case BENEFITS:updateBenefits();
            break;
            case BACK: EmployeeManagement.getInstance().display();
            break;
            case MAIN: MainMenu.getInstance().display();
            default:display();
        }
    }

    private void updateBenefits() {


    }

    private void updateSalary() {
        System.out.println("Enter the new salary range for the employee: ");
        String salaryRange=in.nextLine();
        employee.setSalaryTier(SalaryTier.valueOf(salaryRange));
        EmployeeUpdate.getINSTANCE().display();
    }

    private void updatePosition() {
        System.out.println("Enter the new position name for the employee: ");
        String position=in.nextLine();
        employee.setPosition(Position.valueOf(position));
        EmployeeUpdate.getINSTANCE().display();
    }

    private void updateDepartment() {
        System.out.println("Enter the new department name for the employee: ");
        String dept=in.nextLine();
        employee.setDepartment(Department.valueOf(dept));
        EmployeeUpdate.getINSTANCE().display();
    }

    private void updateEmail() {
        System.out.println("Enter the new email address number for the employee: ");
        String emailAddr=in.nextLine();
        employee.getContactInfo().setEmail(emailAddr);
        EmployeeUpdate.getINSTANCE().display();
    }

    private void updatePhone() {
        System.out.println("Enter the new phone number for the employee: ");
        long phoneNum=in.nextLong();
        employee.getContactInfo().setPhoneNumber(phoneNum);
        EmployeeUpdate.getINSTANCE().display();
    }

    private void updateAddress() {
        System.out.print("\nEnter the street address: ");
        String addr=in.nextLine();
        employee.getContactInfo().setStreetAddress(addr);
        System.out.print("Enter the new city: ");
        addr=in.nextLine();
        employee.getContactInfo().setCity(addr);
        boolean flag=false;
        while(!flag){
        try{
            System.out.print("Enter the State: ");
            addr=in.nextLine();
            State state=State.valueOf(addr);
            employee.getContactInfo().setState(state);
            flag=true;
        }catch (Exception e){
            System.out.println("Invalid State Entered.");
        }
        }
        System.out.println("Address Update Successful.");
        EmployeeUpdate.INSTANCE.display();
    }

    private void updateName() {
        System.out.println("Enter the new name for the employee: ");
        String name=in.nextLine();
        employee.setName(name);
        EmployeeUpdate.getINSTANCE().display();
    }

    public static EmployeeUpdate getINSTANCE() {
        return INSTANCE;
    }


}
