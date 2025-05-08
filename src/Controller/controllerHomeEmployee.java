package Controller;

import Model.Employee;
import View.employee;
import View.homeEmployee;
import View.loginForm;
import View.registerShift;
import java.sql.SQLException;

public class controllerHomeEmployee {
    private employee employeeView;
    private homeEmployee homeEmployee;
    private JpanelLoader jloader;
    private registerShift registerShift;
    private Employee employee;
    
    public controllerHomeEmployee(homeEmployee homeEmployee) throws SQLException {
        this.employeeView = new employee();
        this.homeEmployee = homeEmployee;
        employee = new Employee();
        jloader = new JpanelLoader();
        callData();
    }
    
    public void handleRegister() throws SQLException{
        registerShift = new registerShift();
        jloader.jPanelLoader(homeEmployee.getTotalPanel(), registerShift);
    }
    
    public void callData() throws SQLException{
        Employee empReturn = employee.returnEmpID(loginForm.username);
        homeEmployee.setTextTotalShift(String.valueOf(empReturn.getTotalShip()));
    }
    
}
