package json_cv;
 
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
//import Filtered.object;
 
public class object implements JSONAware {
 
    private int id_object;
    private int cid_object;
    private int sid_object;
    private int pid_object;
    private int status_object;
    
    public object(int id_object, int cid_object, int sid_object, int pid_object, int status_object) {
        super();
        this.id_object = id_object;
        this.cid_object = cid_object;
        this.sid_object = sid_object;
        this.pid_object = pid_object;
        this.status_object = status_object;
    }
    public int getid_object(){
    	return id_object;
    }
    public int getcid_object(){
    	return cid_object;
    }
    public int getsid_object(){
    	return sid_object;
    }
    public int getpid_object(){
    	return pid_object;
    }
    public int getstatus_object(){
    	return status_object;
    }
 
    public String toJSONString() {
 
        StringBuffer sb = new StringBuffer(); 
        sb.append("{");
        sb.append("\"id\":\"" + getid_object() + "\""); 
        sb.append(",");
        sb.append("\"cid\":\"" + getcid_object() + "\""); 
        sb.append(",");
        sb.append("\"sid\":\"" + getsid_object() + "\""); 
        sb.append(",");
        sb.append("\"pid\":\"" + getpid_object() + "\""); 
        sb.append(",");
        sb.append("\"status\":\"" + getstatus_object() + "\""); 
        sb.append("}"); 
        return sb.toString();
 
    }
    public static void main(String[] args){    	   
    	List<object> list = new ArrayList<object>();
    	list.add(new object(1, 1, 1,1,12));
    	list.add(new object(1, 1, 1,1,12));
    	list.add(new object(1, 1, 1,1,12));
        String JSONResult = JSONArray.toJSONString(list);
 
        System.out.println(JSONResult);  
   
    }
 
}
