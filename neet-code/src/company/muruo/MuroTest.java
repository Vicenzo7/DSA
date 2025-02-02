package company.muruo;

public class MuroTest {

    private static MuroTest test;

    private MuroTest() {
    }


    public  static MuroTest getInstance() {
        if (test == null) {
            synchronized (MuroTest.class) {
                if(test == null) {
                    test = new MuroTest();
                }
            }
        }
        return test;
    }


    /*
        Table 1 Employee Table
        id, name, doj, manager_id

        Table 2 Salary
        employee_id , salary

        Find all the employees whos salary is greater then of their manager
        and their doj < of their manager


        select * from employee e join employee e2 e.id == e2.manager_id
        join salary s on e.id == s.employee_id
        where  e1.

       BLACK ROCK


        circuit breaker pattern
        Sealed Classes


    */
}
