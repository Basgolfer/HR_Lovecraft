package hrlovecraft.menus;

//import hrlovecraft.MenuPrompts;

import hrlovecraft.EmployeeWarehouse;

public class CreateNewEmployee extends Menu{

    private static final CreateNewEmployee INSTANCE = new CreateNewEmployee();

    public enum NewEmployeeSelections{NAME, ADDRESS, PHONE, EMAIL, SUBMIT, CANCEL}

    private CreateNewEmployee(){
        super(NewEmployeeSelections.values());
    }
    private String [] employee=new String [6];

    @Override
    public void userSelect(String userInput) {
        switch ( NewEmployeeSelections.valueOf(userInput)){
            case NAME: name();
                break;
            case ADDRESS: address();
                break;
            case PHONE: phone();
                break;
            case EMAIL: email();
            break;
            case SUBMIT: createEmployee();
            break;
            case CANCEL: cancel();
            break;

            default:
                display();

        }


    }

    private void cancel() {
        employee=new String [6];
        MainMenu.getInstance().display();
    }

    private void createEmployee() {

        eWH.add(employee);
        MainMenu.getInstance().display();
    }

    private void email() {
        System.out.print("Enter an email address: ");
        employee[5]=in.nextLine();
    }

    private void phone() {
        System.out.print("Enter a phone number: ");
        employee[4]=in.nextLine();
    }

    private void address() {
        System.out.print("Enter the street address: ");
        employee[1]=in.nextLine();
        System.out.print("Enter the city: ");
        employee[2]=in.nextLine();
        System.out.print("Enter the State: ");
        employee[3]=in.nextLine();
        INSTANCE.display();
    }

    private void name() {
        System.out.print("Enter the new Employee's Name: ");
        employee[0]=in.nextLine();
        INSTANCE.display();
    }

    public static CreateNewEmployee getInstance(){
        return INSTANCE;
    }
}
