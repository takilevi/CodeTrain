package Model;

/**
*@param Color The color of the train.
*@param Velocity The velocity of the train.
*@param Capacity The capacity of the train.
*/
public class Train {
    private String Color;
    private int Velocity;
    private int Capacity;
    
    public Train() { }

    public void SetColor(String color){
        this.Color = color;
    }

    public void SetVelocity(int velocity){
        this.Velocity = velocity;
    }
    
    public void SetCapacity(int capacity){
        this.Capacity = capacity;
    }
    
    /**
    *@return The color of the train.
    */
    public String GetColor(){
        return Color;
    }
    
    /**
    *@return The velocity of the train.
    */
    public int GetVelocity(){
        return Velocity;
    }
    
    /**
    *@return The capacity of the train.
    */
    public int GetCapacity(){
        return Capacity;
    }
}
