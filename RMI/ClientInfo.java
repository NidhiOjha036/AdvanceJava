package chat;

public class ClientInfo {

    String name;
    ChatClientInterface ref;

    public ClientInfo(String name, ChatClientInterface ref)
    {
        this.name = name;
        this.ref = ref;
    }

    public boolean equals(Object o)
    {
        if(o instanceof ClientInfo){
            return ((ClientInfo)o).equals(name);
        }
        else
        {
            return false;
        }
       
    }

}
