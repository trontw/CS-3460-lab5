public class Location {
    double x;
    double y;
    Location next;
    //Cell Manipulation:
    //These will be used to keep track of the locations
    //within each cell, as a linked-list.
    //Empty Cell 
    public Location(double _x, double _y) {
        x = _x;
        y = _y;
        next = null;
    }
    //Cell Manipulation:
    //These will be used to keep track of the locations
    //within each cell, as a linked-list.
    //Occupied Cell - insert at head
    public Location(double _x, double _y, Location _next) {
        x = _x;
        y = _y;
        next = _next;
    }
}
