import java.util.Scanner;
public class payroll {
    public static void main(String[] args) {
        varsData vars = new varsData();
        Scanner inputData = new Scanner(System.in);
        //Initialize the variables from varsData class
        System.out.println("=======Payroll Program========");
        System.out.print("Enter Staff ID        : ");
        vars.staffId = inputData.next();
        System.out.print("Enter First Name      : ");
        vars.fName = inputData.next();
        System.out.print("Enter Last Name       : ");
        vars.lName = inputData.next();
        System.out.print("Enter Gender (M or F) : ");
        vars.gender = inputData.next();
        System.out.print("Enter Marital Status  : ");
        vars.mStatus = inputData.next();
        System.out.print("Enter Basic Salary    : ");
        vars.bSal = inputData.nextDouble();

        //Computations
        vars.hAllow = 0.2 * vars.bSal; // House Allowance
        vars.tAllow = 0.9255 * vars.hAllow; // Transport Allowance
        vars.mAllow = 1.0327 * vars.tAllow; // Medical Allowance
        //Compute Bonus
        if (vars.gender == "M" && vars.mStatus == "Married"){
            vars.bonus = 0.15 * vars.bSal; // Male and Married
        }
        else if (vars.gender == "F" && vars.mStatus == "Married"){
            vars.bonus = 0.125 * vars.bSal; //Female and Married
        }
        else {
            vars.bonus = 0.0975 * vars.bSal; // Others
        }
        //Compute Gross Pay
        vars.gross = vars.bSal + vars.hAllow + vars.tAllow + vars.mAllow + vars.bonus;
        //Compute PAYEE
        if (vars.gross >= 0 && vars.gross <= 10000){
            vars.payee = 0.05 * vars.gross; // If Gross Pay is between 0 and 10000
        }
        else if (vars.gross >= 10001 && vars.gross <= 20000){
            vars.payee = 0.1 * vars.gross; // If Gross Pay is between 10001 and 20000
        }
        else if (vars.gross >= 20001 && vars.gross <= 30000){
            vars.payee = 0.2 * vars.gross; // If Gross Pay is between 20001 and 30000
        }
        else {
            vars.payee = 0.3 * vars.gross; // If Gross Pay is above 30000
        }
        //Compute NSSF
        vars.nssf = 0.15 * vars.gross;
        //Compute NHIF
        vars.nhif = vars.nssf + 3500;
        //Compute Net Pay
        vars.net = vars.gross - vars.payee - vars.nssf - vars.nhif;

        //Results / Output
        System.out.println("=====Employee Details======");
        System.out.println("Staff ID        : " + vars.staffId);
        System.out.println("Full Names      : " + vars.fName + " " + vars.lName);
        System.out.println("Gender          : " + vars.gender);
        System.out.println("Marital Status  : " + vars.mStatus);
        System.out.println("Basic Salary    : " + vars.bSal);
        System.out.println("====Benefits=====");
        System.out.println("House Allowance     : " + vars.hAllow);
        System.out.println("Transport Allowance : " + vars.tAllow);
        System.out.println("Medical Allowance   : " + vars.mAllow);
        System.out.println("Bonus               : " + vars.bonus);
        System.out.println("====Total Gross Pay=====");
        System.out.println("Gross Pay : " + vars.gross);
        System.out.println("====Deductions=====");
        System.out.println("PAYEE : " + vars.payee);
        System.out.println("NSSF  : " + vars.nssf);
        System.out.println("NHIF  : " + vars.nhif);
        System.out.println("====Total Net Pay=====");
        System.out.println("Net Pay : " + vars.net);
    }
}
