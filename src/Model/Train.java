package Model;

public class Train {
    private String Color;
    private int Velocity;

    public Train() { }

    public void SetColor(String color){
        this.Color = color;
    }

    public void SetVelocity(int velocity){
        this.Velocity = velocity;
    }

    public String GetColor(){
        return Color;
    }

    public int GetVelocity(){
        return Velocity;
    }
}
