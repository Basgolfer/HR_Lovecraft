package hrlovecraft.menus;

//import hrlovecraft.Menu;

import hrlovecraft.EmployeeWarehouse;
import hrlovecraft.State;

public class CreateNewEmployee extends Menu{

    private static final CreateNewEmployee INSTANCE=new CreateNewEmployee();

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
            case SUBMIT: checkAndSubmitEmployeeInfo();
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

        //eWH.add(employee);
        //MainMenu.getInstance().display();
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

    public void checkAndSubmitEmployeeInfo(){
        try{
            for (String s:employee)
                if(s==null)
                    throw new Exception("Fill out all fields");
            State.valueOf(employee[3]);
            Long.parseLong(employee[4]);
            if(employee[4].length()<10)
                throw new Exception("Phone Number: not enough digits");
            eWH.add(employee);
            MainMenu.getInstance().display();
        }catch (Exception ex){
            System.out.println(ex);
            display();
        }

    }
}
