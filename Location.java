public class Location {
    double x;
    double y;
    Location next;

    public Location(double _x, double _y) {
        x = _x;
        y = _y;
        next = null;
    }

    public Location(double _x, double _y, Location _next) {
        x = _x;
        y = _y;
        next = _next;
    }
}
