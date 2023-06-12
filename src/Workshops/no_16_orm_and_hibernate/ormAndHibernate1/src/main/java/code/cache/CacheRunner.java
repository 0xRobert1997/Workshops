package code.cache;

public class CacheRunner {

    public static void main(String[] args) {
        CachedEmployeeRepository cachedEmployeeRepository = new CachedEmployeeRepository();

        cachedEmployeeRepository.deleteAll();

        cachedEmployeeRepository.insertData(ExampleData.someEmployee1());
        CachedEmployee cachedEmployee = cachedEmployeeRepository.insertData(ExampleData.someEmployee2());
        cachedEmployeeRepository.insertData(ExampleData.someEmployee3());

        cachedEmployeeRepository.l1c(cachedEmployee.getEmployeeId());
    }
}
