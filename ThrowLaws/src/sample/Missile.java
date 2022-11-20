package sample;

public class Missile {
    public static double _firstSpeed;
    public static double _degrees;
    public static double gravityA = 10;
    public static double moreHeight = 50;
    public static double wideScreen = 0;


    public static Position calcPosition(double firstSpeed, double degrees , double xPos) {
        _firstSpeed = firstSpeed;
        _degrees = degrees;
        double highestLevel = (Math.pow(firstSpeed * Math.sin(Math.toRadians(degrees)),2))/(2*gravityA);
        double timeToHighest = Math.sqrt(highestLevel/(0.5*gravityA));


        double yLevel = highestLevel;
        if (Math.sin(Math.toRadians(degrees)) >= 0){
            double rt;
            if (xPos < timeToHighest){
                rt = timeToHighest - xPos;
            }
            else if (xPos > timeToHighest){
                rt = xPos - timeToHighest;
            } else rt = timeToHighest;
            double minusED = 0.5 * gravityA * Math.pow(rt,2);
            yLevel -= minusED;
        }else {
            timeToHighest *= -1;
            double rt;
            if (xPos < timeToHighest){
                rt = timeToHighest - xPos;
            }
            else if (xPos > timeToHighest){
                rt = xPos - timeToHighest;
            } else rt = timeToHighest;
            double minusED = 0.5 * gravityA * Math.pow(rt,2);
            yLevel -= minusED;
        }
        double Xs = xPos * Math.cos(Math.toRadians(degrees));
        return new Position(Xs*wideScreen,yLevel + moreHeight);
    }

    public static double get_firstSpeed() {
        return _firstSpeed;
    }

    public static void set_firstSpeed(double _firstSpeed) {
        Missile._firstSpeed = _firstSpeed;
    }

    public static double get_degrees() {
        return _degrees;
    }

    public static void set_degrees(double _degrees) {
        Missile._degrees = _degrees;
    }

    public double getGravityA() {
        return gravityA;
    }

    public void setGravityA(double gravityA) {
        this.gravityA = gravityA;
    }
}
