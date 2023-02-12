import java.io.Serializable;
import java.util.*;

public class Contact implements Serializable {
    private String fullName;

    private Map<String, Map<String, String>> data;

    public Contact() {
        this.data = new LinkedHashMap<>();
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void addData(String field, String type, String value) {
        Map<String, String> fieldData = data.computeIfAbsent(field, (f) -> new LinkedHashMap<>());
        fieldData.put(type, value);
    }

    public Collection<String> getPhones() {
        return data.get("TEL").values();
    }

    @Override
    public String toString() {
        return "Contact{" +
                "fullName='" + fullName + '\'' +
                ", data=" + data +
                '}';
    }
}
