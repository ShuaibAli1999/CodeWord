package code;
/**
 * This class create location instance that store the string codenames.
 */
public class Location {
/**
 * the code name
 */
private String name;
/**
 * This is constructor assigning the instance variable name to the pass-in string.
 */
public Location(String codename) {
	name=codename;
}
/**
 * This is a getter method to get access of the string store in the Location instance variable.
 */
public String getName() {
	return name;
}
}
