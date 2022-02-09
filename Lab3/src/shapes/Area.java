package shapes;
//calculateArea doesnt recieve an arguement because i tried double value, but because of rectangle would need two values, it dint work
//So i did double... value but that would mean dealing with an array and doesnt make sense when its a cirle, so i used the fact that lambdas
//have access to local values to create my object.
@FunctionalInterface
public interface Area {
	double calculateArea();
}
