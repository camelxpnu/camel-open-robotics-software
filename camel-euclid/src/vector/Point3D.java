package vector;

import basics.Tuple3DBasics;
import vector.readOnly.Tuple3DReadOnly;

public class Point3D extends Tuple3DBasics
{
	public Point3D()
	{
		setToZero();
	}

	public Point3D(double x, double y, double z)
	{
		set(x, y, z);
	}

	public Point3D(double... array)
	{
		set(array);
	}

	public Point3D(Tuple3DReadOnly other)
	{
		set(other);
	}
}