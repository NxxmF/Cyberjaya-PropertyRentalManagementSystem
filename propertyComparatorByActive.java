import java.util.Comparator;

// used to sort properties in home page by their activation status
public class propertyComparatorByActive implements Comparator<Property>{
	public int compare(Property a, Property b)
    {
        return a.getPropertyActivationStatus().compareTo(b.getPropertyActivationStatus());
    }
}
