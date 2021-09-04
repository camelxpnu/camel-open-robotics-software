package orientation.readOnly;

import tools.AxisAngleTools;
import vector.readOnly.Tuple3DReadOnly;

public interface AxisAngleReadOnly
{
	public static final double EPS_ZERO_ORIENTATION = 1.0e-8;

	public Tuple3DReadOnly getAxis();

	public double getAngle();

	default boolean isZeroOrientation()
	{
		return Math.abs(getAngle()) <= EPS_ZERO_ORIENTATION;
	}

	default boolean isZeroOrientation(double epsilon)
	{
		return Math.abs(getAngle()) <= epsilon;
	}

	default double getX()
	{
		return getAxis().getX();
	}

	default double getY()
	{
		return getAxis().getY();
	}

	default double getZ()
	{
		return getAxis().getZ();
	}

	default double distance(AxisAngleReadOnly other)
	{
		return AxisAngleTools.distance(this, other);
	}
}
