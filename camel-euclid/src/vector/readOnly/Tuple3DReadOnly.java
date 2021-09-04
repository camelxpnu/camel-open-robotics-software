package vector.readOnly;

import tools.EuclidCoreTools;

public interface Tuple3DReadOnly
{
	double getX();

	double getY();

	double getZ();

	default boolean containsNaN()
	{
		return EuclidCoreTools.containsNaN(getX(), getY(), getZ());
	}
}
