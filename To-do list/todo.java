import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Task {
    private HashMap<Integer,String> map = new HashMap<>();
    private HashMap<Integer,Boolean> map1 = new HashMap<>();
   
    void run(){
        System.out.println("Hello , what would you like to do ?");
        System.out.println("1. Add a task");
        System.out.println("2. Check tasks");
        System.out.println("3. Delete a task");
        System.out.println("4. Update status");
        System.out.println("5. Exit Menu");
        

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        
        switch(x){
        case 1 : 
           System.out.println("Enter serial number with the task.");
           int y = sc.nextInt();
           sc.nextLine();
           String str = sc.nextLine();
           addTask(y,str);
           run();
           break ;
        case 2 : 
           showTasks();
           run();
           break ;
        case 3 : 
           System.out.println("Enter the serial number of task you want to remove.");
           int z = sc.nextInt();
           deleteTask(z);
           sc.close();
           run();
           break;
        case 4 : 
           showTasks();
           System.out.println("Enter the task number of which you want to update status.");
           int t = sc.nextInt();
           boolean b = sc.nextBoolean();
           addStatus(t,b);
           run();
           break;
        case 5 :
        System.out.println("Exited successfully");
        break;

        default :  System.out.println("invalid");
        }
 }

    void addTask(int id , String title){
        map.put(id,title);
    }

    void showTasks(){
        for (Map.Entry<Integer,String>e:map.entrySet()){
            int taskId = e.getKey();
           String taskTitle= e.getValue();
            boolean completed = map1.getOrDefault(taskId, false);  // Get status from map1
            System.out.println( taskId + " : " + taskTitle + "  : " + (completed ? "completed" : "not completed"));
            System.out.println();
        }
    }

    void deleteTask(int x){
        map.remove(x);
        }
    
    void addStatus(int id , boolean x){
        if(map.containsKey(id)){
        map1.put(id,x);
          } 
        else {
        System.out.println("Task ID not found!");
          }                                    
        }

    }
public class todo {
    public static void main(String[] args) {
        Task t = new Task();
        t.run();
    }
}
