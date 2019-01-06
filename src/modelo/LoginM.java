package modelo;

public class LoginM {

    public String getUsrper() {
        return usrper;
    }

    public void setUsrper(String usrper) {
        this.usrper = usrper;
    }

    public String getPswper() {
        return pswper;
    }

    public void setPswper(String pswper) {
        this.pswper = pswper;
    }
    private String usrper, pswper;
    @Override
    public String toString(){
        return "["+this.usrper+","+ this.pswper+"]";
    }
}
