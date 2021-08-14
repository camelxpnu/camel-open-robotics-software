package vector;

import basics.Tuple3DBasics;
import vector.readOnly.Tuple3DReadOnly;

public class Vector3D extends Tuple3DBasics
{
	public Vector3D()
	{
		setToZero();
	}

	public Vector3D(double x, double y, double z)
	{
		set(x, y, z);
	}

	public Vector3D(double... array)
	{
		set(array);
	}

	public Vector3D(Tuple3DReadOnly other)
	{
		set(other);
	}

	public void normalize()
	{
		if (containsNaN())
			return;
		scale(1.0 / length());
	}

	/**
	 * Sets this vector to {@code other} and then calls {@link #normalize()}.
	 *
	 * @param other the other vector to copy the values from. Not modified.
	 */
	public void setAndNormalize(Tuple3DReadOnly other)
	{
		set(other);
		normalize();
	}

	public void cross(Tuple3DReadOnly other)
	{
		cross(this, other);
	}

	public void cross(Tuple3DReadOnly tuple1, Tuple3DReadOnly tuple2)
	{
		double x = tuple1.getY() * tuple2.getZ() - tuple1.getZ() * tuple2.getY();
		double y = tuple1.getZ() * tuple2.getX() - tuple1.getX() * tuple2.getZ();
		double z = tuple1.getX() * tuple2.getY() - tuple1.getY() * tuple2.getX();
		set(x, y, z);
	}
}